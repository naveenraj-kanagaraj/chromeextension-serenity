package saka.defaultmodes;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.Select;
import saka.bookmarks.bookmarksComponentObject;

import java.time.Duration;

public class defaultModesSteps  extends UIInteractionSteps {

    @Step
    public void selectDefaultMode(String mode){

        if (withTimeoutOf(Duration.ofSeconds(30)).find(defaultModesComponentObject.modesDropdown).isPresent()) {
            Select dropModes = new Select($(defaultModesComponentObject.modesDropdown));
            dropModes.selectByVisibleText(mode);
            $(defaultModesComponentObject.modeSaveBtn).click();
        }
    }

}
