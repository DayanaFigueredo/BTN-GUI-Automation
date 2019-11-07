package com.endava.btn.gui.automation.steps;

import com.endava.btn.gui.automation.helpers.DriverFacade;
import com.endava.btn.gui.automation.helpers.DriverFactory;
import com.endava.btn.gui.automation.utils.PropertyManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Hooks {
    private WebDriver webDriver;
    private String baseURL = PropertyManager.getConfigValueByKey("url");


    @Before
    public void before() {
        this.webDriver = DriverFactory.setWebDriver("non headless");
        DriverFacade.maximizeWindow();
        webDriver.get(baseURL);
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.embed(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (WebDriverException e) {
                System.out.println(e.getMessage());
            }
        }
        webDriver.quit();
    }
}