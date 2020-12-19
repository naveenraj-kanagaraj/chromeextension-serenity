package saka.keyBoardShortCuts;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import saka.navigation.homePage;

public class keyboardShortcutsSteps extends UIInteractionSteps {

    homePage homePage;
    @Step
    public void openSakaHomePageByKeyBoardShortCuts() throws InterruptedException {
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.COMMAND, Keys.SPACE));
        Thread.sleep(8000);
    }

    public void closeSakaHomePageByKeyBoardShortCuts() {
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.ESCAPE));
    }

    public void changeSakaModeByKeyBoardShortCuts() {
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.SPACE));
    }

    public void switchToBookmarkSearch() {
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.COMMAND, "b"));
    }

    public void switchToHistorySearch() {
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.COMMAND, Keys.SHIFT,"e"));
    }

    public void switchToRecentlyClosedTabsSearch() {
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.COMMAND, Keys.SHIFT,"c"));
    }

    public void SwitchToTabsSearch() {
        homePage.getDriver().findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.COMMAND, Keys.SHIFT,"a"));
    }
}
