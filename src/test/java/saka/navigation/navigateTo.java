package saka.navigation;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class navigateTo extends UIInteractionSteps {
    homePage homePage;


    @Step("Open the CRM home page")
    public void theHomePage(){
        homePage.open();
    }

}
