package saka.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import saka.navigation.navigateTo;
import saka.sharedFlows.sakaSearchListSteps;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class browserStepDefinitions {

    @Steps
    navigateTo navigateTo;

    @Steps
    sakaSearchListSteps sakaSearchListSteps;

    @Given("open browser")
    public void openBrowser() throws InterruptedException {
        navigateTo.theHomePage();
    }

    @Given("open new tab with {string} and store it in session variable {string}")
    public void openNewTabWithAndStoreItInSessionVariable(String url, String tabName) {
        Serenity.setSessionVariable(url).to(tabName+"url");
        navigateTo.addnewtab(url,tabName);
    }

    @Then("open The Saka Homepage")
    public void openTheSakaHomepage() {
        navigateTo.openSakaHomePage();
    }

    @And("Navigate to Saka bookmarks")
    public void navigateToSakaBookmarks() throws InterruptedException {
        navigateTo.navigateToSakaBookmarks();
        Thread.sleep(3000);
    }

    @And("Verify current url is not equal to saka url")
    public void verifyCurrentUrlIsNotEqualToSakaUrl() {
        String url = navigateTo.returnCurrentUrl();
        assertThat("chrome-extension://nbdfpcokndmapcollfpjdpjlabnibjdi/saka.html").isNotEqualTo(url);
    }

    @And("Swtich to tab of Name {string}")
    public void swtichToTabOfName(String tabName) {
        navigateTo.switchToTargetTab(tabName);
    }

    @And("Click {string} th result in the saka Tab mode")
    public void clickThResultInTheSakaTabMode(String listNum) {
        sakaSearchListSteps.openNthNumberTabFromSakaList(listNum);
    }

    @Then("Get the {string}th result url and store it in session variable {string}")
    public void getTheThResultUrlAndStoreItInSessionVariable(String listNum, String UrlName) {
        String url = sakaSearchListSteps.getNthNumberResultFromSakaList(listNum);
        Serenity.setSessionVariable(url).to(UrlName);
    }

    @And("Verify current url is equal to {string}")
    public void verifyCurrentUrlIsEqualTo(String expectedUrl) {
        String actualUrl = navigateTo.returnCurrentUrl();
        assertThat(expectedUrl).isNotEqualTo(actualUrl);
    }
}
