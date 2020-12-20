package saka.sharedFlows;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import saka.navigation.homePage;

public class sakaSearchListSteps  extends UIInteractionSteps {
    homePage homePage;

    public void openNthNumberTabFromSakaList(String listNum) {
        String winHandleBefore = homePage.getDriver().getWindowHandle();
        Serenity.setSessionVariable("sakaTab").to(winHandleBefore);
        $(By.xpath("//ul[contains(@class,'mdc-list')]/li["+listNum+"]")).click();
        for(String winHandle :  homePage.getDriver().getWindowHandles()){
            homePage.getDriver().switchTo().window(winHandle);
            Serenity.setSessionVariable("resultTabHandle").to(winHandle);
        }
    }

    public String getNthNumberResultFromSakaList(String listNum) {
        return $(By.xpath("//ul[contains(@class,'mdc-list')]/li["+listNum+"]//span[@class='mdc-list-item__text suggestion-text']/span[2]")).getText();
    }
}
