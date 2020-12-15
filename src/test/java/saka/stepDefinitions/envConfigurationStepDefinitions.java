package saka.stepDefinitions;

import io.cucumber.java.Before;
import net.thucydides.core.annotations.Steps;
import saka.sharedFlows.envConfigurationSteps;

public class envConfigurationStepDefinitions {

    @Steps
    envConfigurationSteps envConfiguration;

    @Before(order=1)
    public void loadTestDataAsSessionVariables()
    {
        envConfiguration.loadEnvironmentPropertiesAsSerenitySessionVariables();
    }

    @Before(order=2)
    public void loadchromebrowser()
    {

    }

}
