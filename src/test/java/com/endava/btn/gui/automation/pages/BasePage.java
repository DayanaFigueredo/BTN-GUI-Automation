package com.endava.btn.gui.automation.pages;

import com.endava.btn.gui.automation.helpers.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    WebDriver webDriver;

    @FindBy(id = "lnkLogin")
    private WebElement hyperlinkLogin;
    @FindBy(xpath = "//section[@class='userNav']//li[@class='userInfo']")
    private WebElement labelUsername;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnTheLogInHyperlink() {
        DriverFacade.waitForVisibilityOfElement(hyperlinkLogin);
        hyperlinkLogin.click();
    }

    public String getUsername() {
        DriverFacade.waitForVisibilityOfElement(labelUsername);
        return labelUsername.getText();
    }
}
