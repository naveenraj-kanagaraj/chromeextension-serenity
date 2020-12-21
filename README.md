# chromeextension-serenity

For Test Execution - pls use the following command line

mvn clean verify -Denvironment=staging

For Headless mode

Change <headless.mode = true> in serenity.properties

To Execute Saka Keyboard shortcuts cases

       mvn clean verify -Denvironment=staging -Dtags=@keyboardShortcuts
       
To Execute Saka modify Default mode cases
       
        mvn clean verify -Denvironment=staging -Dtags=@defaultMode
       
Reports Path
    
     target/site/serenity/index.html 
     
     
![Cucumber Feature File Validation](https://github.com/freshmarketer/freshmarketer-serenity/workflows/Cucumber%20Feature%20File%20Validation/badge.svg)
