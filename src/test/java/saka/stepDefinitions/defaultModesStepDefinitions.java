package saka.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import saka.bookmarks.bookmarkSteps;
import saka.bookmarks.bookmarksComponentObject;
import saka.defaultmodes.defaultModesSteps;
import saka.navigation.homePage;
import saka.navigation.navigateTo;
import static org.assertj.core.api.Assertions.assertThat;


public class defaultModesStepDefinitions {

    @Steps
    navigateTo navigateTo;

    @Steps
    defaultModesSteps defaultModesSteps;

    @Steps
    bookmarkSteps bookmarkSteps;


    @Then("Make default mode of saka as {string}")
    public void makeDefaultModeOfSakaAs(String mode) {
        navigateTo.openSakaOptionsPage();
        defaultModesSteps.selectDefaultMode(mode);

    }

    @And("Verify Selected Option In Saka HomePage is {string}")
    public void verifySelectedOptionInSakaHomePageIs(String mode) {
        String value = navigateTo.returnSakaSearchAttribute("aria-label");
        assertThat(mode).isEqualTo(value);
    }
}
