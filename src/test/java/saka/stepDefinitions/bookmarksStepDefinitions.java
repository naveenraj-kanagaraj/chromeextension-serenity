package saka.stepDefinitions;

import com.assertthat.selenium_shutterbug.utils.web.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import saka.navigation.navigateTo;

import java.awt.*;

public class bookmarksStepDefinitions {

    @Steps
    navigateTo navigateTo;

    @Then("open browser bookmark manage page")
    public void openBrowserBookmarkManagePage() {
        navigateTo.openBookmarksInNewTab();
    }

    @And("bookmark an webpage {string} and store url in session varibale {string}")
    public void bookmarkAnWebpageAndStoreUrlInSessionVaribale(String url, String sessionUrlName) throws InterruptedException {
        Serenity.setSessionVariable(url).to(sessionUrlName);
        navigateTo.addNewBookmark();

    }
}
