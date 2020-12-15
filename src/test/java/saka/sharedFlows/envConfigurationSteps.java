package saka.sharedFlows;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import java.io.FileInputStream;
import java.util.Properties;

public class envConfigurationSteps {

    @Step
    public void loadEnvironmentPropertiesAsSerenitySessionVariables()
    {
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        String env = System.getProperty("environment");
        String filePath = "envProperties/"+env+".properties";

        try{
            inputStream = new FileInputStream(ClassLoader.getSystemResource(filePath).getFile());
            properties.load(inputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        for(String property : properties.stringPropertyNames())
        {
            Serenity.setSessionVariable(property).to(properties.getProperty(property));
        }
    }
}