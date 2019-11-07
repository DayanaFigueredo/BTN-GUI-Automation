package com.endava.btn.gui.automation.pages.popups;

import com.endava.btn.gui.automation.helpers.DriverFacade;
import com.endava.btn.gui.automation.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPopUp {

    WebDriver webDriver;

    @FindBy(id = "email")
    private WebElement inputEmail;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(id = "login")
    private WebElement buttonLogin;

    private final By iframeXpath = By.xpath("//iframe");
    private final By popupLogin = By.className("user-form-container-popup");

    public LogInPopUp(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void enterValidCredentials() {
        DriverFacade.awaitToFindElement(iframeXpath);
        webDriver.switchTo().frame(webDriver.findElement(iframeXpath));
        DriverFacade.awaitToFindElement(popupLogin);
        inputEmail.sendKeys(PropertyManager.getAuthValueByKey("userEmail"));
        inputPassword.sendKeys(PropertyManager.getAuthValueByKey("userPassword"));
    }

    public void clickTheLoginButton() {
        DriverFacade.awaitToFindElement(popupLogin);
        buttonLogin.click();
    }
}
