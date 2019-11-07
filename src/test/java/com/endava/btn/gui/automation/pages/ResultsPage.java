package com.endava.btn.gui.automation.pages;

import com.endava.btn.gui.automation.helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage extends BasePage {

    @FindBy(className = "found")
    private WebElement titleResults;


    public ResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getTitleText() {
        DriverFacade.waitForVisibilityOfElement(titleResults);
        return titleResults.getText();
    }
}
