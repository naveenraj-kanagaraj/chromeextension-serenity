#########################################
# Dockerfile for Marketer UI image
#########################################
FROM amazonlinux:2
# COPY ID_RSA KEY TO ROOT USER
COPY id_rsa /root/.ssh/id_rsa
# INSTALL DEPENDENCIES
RUN yum update -y && \
    yum install -y git sudo wget curl vim bzip2 tar python3 jq && \
    yum groupinstall -y "Development Tools" && \
    chmod 400 /root/.ssh/id_rsa && \
    ssh-keyscan github.com > /root/.ssh/known_hosts
# INSTALL JAVA 12
RUN wget https://download.java.net/java/GA/jdk12/GPL/openjdk-12_linux-x64_bin.tar.gz && \
    mkdir /usr/lib/jdk && \
    tar -xvzf openjdk-12_linux-x64_bin.tar.gz -C /usr/lib/jdk && \
    echo "export PATH=$PATH:/usr/lib/jdk/jdk-12/bin" >> /etc/bashrc && \
    echo "export JAVA_HOME="/usr/lib/jdk/jdk-12"" >> /etc/bashrc && \
    source /etc/bashrc && \
    update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jdk/jdk-12/bin/java" 0 && \
    update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jdk/jdk-12/bin/javac" 0 && \
    update-alternatives --set java /usr/lib/jdk/jdk-12/bin/java && \
    update-alternatives --set javac /usr/lib/jdk/jdk-12/bin/javac
# INSTALL MAVEN
RUN wget https://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo && \
    sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo && \
    yum install -y apache-maven
# INSTALL GOOGLE CHROME AND FIREFOX
RUN curl https://intoli.com/install-google-chrome.sh | bash && \
    cd /usr/local && \
    wget http://ftp.mozilla.org/pub/firefox/releases/81.0/linux-x86_64/en-US/firefox-81.0.tar.bz2 && \
    tar xvjf firefox-81.0.tar.bz2 && \
    ln -s /usr/local/firefox/firefox /usr/bin/firefox
# INSTALL CHROMEDRIVER & GECKODRIVER
RUN export cd_version=$(curl http://chromedriver.storage.googleapis.com/LATEST_RELEASE) && \
    wget https://chromedriver.storage.googleapis.com/$cd_version/chromedriver_linux64.zip && \
    unzip chromedriver_linux64.zip && \
    mv chromedriver /usr/bin/chromedriver && \
    chown root:root /usr/bin/chromedriver && \
    chmod +x /usr/bin/chromedriver && \
    export gd_version=$(curl -s https://api.github.com/repos/mozilla/geckodriver/releases/latest%7C jq --raw-output '.tag_name') && \
    wget https://github.com/mozilla/geckodriver/releases/download/$gd_version/geckodriver-$gd_version-linux64.tar.gz && \
    tar -xvzf geckodriver* && \
    mv geckodriver /usr/bin/geckodriver && \
    sudo chown root:root /usr/bin/geckodriver && \
    sudo chmod +x /usr/bin/geckodriver
# ADDING a Jenkins User
RUN useradd -ms /bin/bash jenkins && \
    echo 'jenkins:test' | chpasswd && echo "jenkins ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers && \
    mkdir /home/jenkins/.ssh
# COPY ID_RSA KEY FOR JENKINS USER
COPY id_rsa /home/jenkins/.ssh/id_rsa
RUN chmod 400 /home/jenkins/.ssh/id_rsa && \
    ssh-keyscan github.com > /home/jenkins/.ssh/known_hosts && \
    chown jenkins:jenkins -R /home/jenkins/
# INSTALL AWSCLI
RUN pip3 install awscli
# EXPOSE SSH PORT
EXPOSE 22