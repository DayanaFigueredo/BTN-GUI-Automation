package com.endava.btn.gui.automation.pages.popups;

import com.endava.btn.gui.automation.helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapPopUp {

    WebDriver webDriver;

    @FindBy(id = "confirm")
    private WebElement buttonConfirm;
    @FindBy(xpath = "//a[@class='mapSaveAddress']//span")
    private WebElement labelDesiredAddres;
    @FindBy(className = "spinner")
    private WebElement spinner;

    private String desiredAddress;

    public MapPopUp(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        setDesiredAddress();
    }

    public void clickConfirmButton() {
        buttonConfirm.click();
        if (spinner.isEnabled()) DriverFacade.clickAsJavascriptExecutor(buttonConfirm);
    }

    private void setDesiredAddress() {
        DriverFacade.waitForVisibilityOfElement(labelDesiredAddres);
        desiredAddress = labelDesiredAddres.getText();
    }

    public String getDesiredAddress() {
        return desiredAddress;
    }

    public boolean getConfirmButton() {
        DriverFacade.waitForVisibilityOfElement(labelDesiredAddres);
        return buttonConfirm.isSelected();
    }
}
