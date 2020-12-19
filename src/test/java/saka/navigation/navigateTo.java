package saka.navigation;



import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;


import org.openqa.selenium.By;

import org.yecht.Data;
import saka.bookmarks.bookmarksComponentObject;



import java.time.Duration;

public class navigateTo extends UIInteractionSteps {
    homePage homePage;


    @Step("Open the CRM home page")
    public void theHomePage(){
        homePage.open();
    }

    @Step("add new tab")
    public void addnewtab(String Url,String tabName)
    {
        String winHandleBefore = homePage.getDriver().getWindowHandle();
        String script = "window.open('"+Url+"', '_blank')";
        homePage.evaluateJavascript(script);
        for(String winHandle :  homePage.getDriver().getWindowHandles()){
        homePage.getDriver().switchTo().window(winHandle);
            Serenity.setSessionVariable(tabName).to(winHandle);
        }
       homePage.getDriver().switchTo().window(winHandleBefore);
    }

    @Step("switch to target tab")
    public void switchToTargetTab(String tabName)
    {
        homePage.getDriver().switchTo().window(Serenity.sessionVariableCalled(tabName));
    }

    @Step("saka homepage")
    public void openSakaHomePage() {
        homePage.openUrl("chrome-extension://nbdfpcokndmapcollfpjdpjlabnibjdi/saka.html");
    }

    @Step("saka homepage")
    public void openSakaOptionsPage() {
        homePage.openUrl("chrome-extension://nbdfpcokndmapcollfpjdpjlabnibjdi/options.html");
    }

    @Step
    public void navigateToSakaBookmarks() {

        if (withTimeoutOf(Duration.ofSeconds(30)).find(bookmarksComponentObject.navigate_to_bookmark).isPresent()) {
            $(bookmarksComponentObject.navigate_to_bookmark).click();
        }
    }

    @Step
    public String returnSakaSearchAttribute(String attribute)
    {
        String value = $(bookmarksComponentObject.sakaSearch).getAttribute(attribute);
        return value;
    }

    @Step
    public void openBookmarksInNewTab()
    {
        homePage.openUrl("chrome://bookmarks/");

    }

    @Step
    public void addNewBookmark() throws InterruptedException {
        homePage.openUrl("https://www.youtube.com/");
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        Thread.sleep(8000);
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.COMMAND, "l"));
        Thread.sleep(8000);
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.COMMAND, "d"));
        Thread.sleep(8000);
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.ENTER));
        homePage.getDriver().switchTo().alert().accept();
        Thread.sleep(3000);
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.ENTER));
    }

    @Step
    public String returnCurrentUrl(){
        String url = homePage.getDriver().getCurrentUrl();
        return url;
    }

}
