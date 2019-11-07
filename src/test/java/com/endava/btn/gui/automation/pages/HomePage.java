package com.endava.btn.gui.automation.pages;

import com.endava.btn.gui.automation.helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {


    @FindBy(xpath = "//select[@name='selectCity']//following-sibling::div//b")
    private WebElement dropdownCity;
    @FindBy(xpath = "//select[@name='selectStreetType']//following-sibling::div//b")
    private WebElement dropdownStreetType;
    @FindBy(className = "active-result")
    private List<WebElement> activeDropdownOptions;
    @FindBy(xpath = "//span[contains(text(),'Legal Entity Search')]")
    private WebElement searchPopUp;
    @FindBy(xpath = "//div[@id='dynamicFields']//input[@name='street']")
    private WebElement inputStreet;
    @FindBy(xpath = "//div[@id='dynamicFields']//input[@name='corner']")
    private WebElement inputCorner;
    @FindBy(xpath = "//div[@id='dynamicFields']//input[@name='number']")
    private WebElement inputNumber;
    @FindBy(id = "search")
    private WebElement buttonSearch;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void selectOptionsOnTheRequiredFields(String city, String nomenclature) {
        DriverFacade.waitForVisibilityOfElement(dropdownCity);
        dropdownCity.click();
        for (WebElement option : activeDropdownOptions) {
            if (option.getText().equals(city)) option.click();
        }
        dropdownStreetType.click();
        for (WebElement option : activeDropdownOptions) {
            if (option.getText().equals(nomenclature)) option.click();
        }
    }

    public void fillTheRequiredFields(String street, String corner, String number) {
        inputStreet.sendKeys(street);
        inputCorner.sendKeys(corner);
        inputNumber.sendKeys(number);
    }

    public void clickSearchButton() {
        buttonSearch.click();
    }
}
