package com.endava.btn.gui.automation.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver webDriver;
    private static final String HEADLESS = "headless";

    public static WebDriver setWebDriver(String mode) {
        ChromeOptions options = new ChromeOptions();
        if (HEADLESS.equals(mode)) {
            options.addArguments("--" + mode);
        }
        webDriver = new ChromeDriver(options);
        return webDriver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}