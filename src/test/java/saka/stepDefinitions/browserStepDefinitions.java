package saka.stepDefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import saka.navigation.navigateTo;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class browserStepDefinitions {

    @Steps
    navigateTo navigateTo;

    @Given("open browser")
    public void openBrowser() throws InterruptedException {
        navigateTo.theHomePage();
        Thread.sleep(3000);
    }
}
