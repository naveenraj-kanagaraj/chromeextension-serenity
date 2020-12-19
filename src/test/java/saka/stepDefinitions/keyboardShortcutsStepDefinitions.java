package saka.stepDefinitions;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import saka.keyBoardShortCuts.keyboardShortcutsSteps;
import saka.navigation.navigateTo;

public class keyboardShortcutsStepDefinitions {


    @Steps
    keyboardShortcutsSteps keyboardShortcutsSteps;

    @Then("Press Keyboard shorcuts to open saka")
    public void pressKeyboardShorcutsToOpenSaka() throws InterruptedException {
        keyboardShortcutsSteps.openSakaHomePageByKeyBoardShortCuts();
    }

    @Then("Press Keyboard shorcuts to close saka")
    public void pressKeyboardShorcutsToCloseSaka() {
        keyboardShortcutsSteps.closeSakaHomePageByKeyBoardShortCuts();
    }

    @Then("Press Keyboard shorcuts to change mode")
    public void pressKeyboardShorcutsToChangeMode() {
        keyboardShortcutsSteps.changeSakaModeByKeyBoardShortCuts();
    }

    @Then("press Keyboard shortcuts to Switch To saka Bookmark Search")
    public void pressKeyboardShortcutsToSwitchToSakaBookmarkSearch() {
        keyboardShortcutsSteps.switchToBookmarkSearch();

    }

    @Then("press Keyboard shortcuts to Switch To saka History Search")
    public void pressKeyboardShortcutsToSwitchToSakaHistorySearch() {
        keyboardShortcutsSteps.switchToHistorySearch();
    }

    @Then("press Keyboard shortcuts to Switch To saka Recently Closed Tabs Search")
    public void pressKeyboardShortcutsToSwitchToSakaRecentlyClosedTabsSearch() {
        keyboardShortcutsSteps.switchToRecentlyClosedTabsSearch();
    }

    @Then("press Keyboard shortcuts to Switch To saka Tabs Search")
    public void pressKeyboardShortcutsToSwitchToSakaTabsSearch() {
        keyboardShortcutsSteps.SwitchToTabsSearch();
    }
}
