package com.endava.btn.gui.automation.steps;

import com.endava.btn.gui.automation.helpers.DriverFactory;
import com.endava.btn.gui.automation.pages.HomePage;
import com.endava.btn.gui.automation.pages.ResultsPage;
import com.endava.btn.gui.automation.pages.popups.MapPopUp;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchStepdefs {
    private WebDriver webDriver = DriverFactory.getWebDriver();

    HomePage homePage;
    MapPopUp mapPopUp;
    ResultsPage resultsPage;

    private final Logger LOGGER = Logger.getLogger(SearchStepdefs.class.getName());

    @Given("^an user selects \"([^\"]*)\" City and \"([^\"]*)\" street type$")
    public void anUserSelectsCityAndStreetType(String city, String streetType) {
        homePage = new HomePage(webDriver);
        homePage.selectOptionsOnTheRequiredFields(city, streetType);
    }

    @And("^the user fills the fields with the following valid information$")
    public void theUserFillsTheFieldsWithTheFollowingValidInformation(DataTable dataTable) {
        List<String> data = dataTable.asList(String.class);
        homePage.fillTheRequiredFields(data.get(1), data.get(3), data.get(5));
    }

    @When("^the user clicks on the Search button$")
    public void theUserClicksOnTheSearchButton() {
        homePage.clickSearchButton();
    }

    @And("^confirm its location$")
    public void confirmItsLocation() {
        mapPopUp = new MapPopUp(webDriver);
        mapPopUp.clickConfirmButton();

    }

    @Then("^a list of restaurants for the desired location must be displayed$")
    public void aListOfRestaurantsForTheDesiredLocationMustBeDisplayed() {
        resultsPage = new ResultsPage(webDriver);
        LOGGER.info("Actual: " + resultsPage.getTitleText());
        LOGGER.info("Contains: " + mapPopUp.getDesiredAddress());
        assertTrue(resultsPage.getTitleText().contains(mapPopUp.getDesiredAddress()));
    }

    //---------------------------------------------------------------------------------------------------Second Scenario
    @Then("^the user must be able to confirm its location$")
    public void theUserIsAbleToConfirmItsLocation() {
        mapPopUp = new MapPopUp(webDriver);
        assertTrue(mapPopUp.getConfirmButton());
    }

}
