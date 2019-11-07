package com.endava.btn.gui.automation.steps;

import com.endava.btn.gui.automation.helpers.DriverFactory;
import com.endava.btn.gui.automation.pages.HomePage;
import com.endava.btn.gui.automation.pages.popups.LogInPopUp;
import com.endava.btn.gui.automation.utils.PropertyManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepdefs {

    private WebDriver webDriver = DriverFactory.getWebDriver();

    HomePage homePage;
    LogInPopUp logInPopUp;

    private final Logger LOGGER = Logger.getLogger(LoginStepdefs.class.getName());

    @Given("^a user clicks on the log in hyperlink$")
    public void aUserClicksOnTheLogInHyperlink() {
        homePage = new HomePage(webDriver);
        homePage.clickOnTheLogInHyperlink();
    }

    @And("^the user enters the valid credentials$")
    public void theUserEntersTheValidCredentials() throws InterruptedException {
        logInPopUp = new LogInPopUp(webDriver);
        logInPopUp.enterValidCredentials();
    }

    @When("^the user clicks on the Log In button$")
    public void theUserClicksOnTheLogInButton() {
        logInPopUp.clickTheLoginButton();
    }

    @Then("^the user successfully logs in on the system$")
    public void theUserSuccessfullyLogsInOnTheSystem() {
        LOGGER.info("Actual: " + homePage.getUsername());
        LOGGER.info("Equals: " + PropertyManager.getAuthValueByKey("userName"));
        assertEquals(homePage.getUsername(), PropertyManager.getAuthValueByKey("userName"));
    }
}
