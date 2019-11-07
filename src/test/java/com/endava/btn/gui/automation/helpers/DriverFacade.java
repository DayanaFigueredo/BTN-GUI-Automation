package com.endava.btn.gui.automation.helpers;


import org.awaitility.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class DriverFacade {
    private static int timeoutInSeconds = 10;
    private static WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), timeoutInSeconds);

    public static void maximizeWindow() {
        DriverFactory.getWebDriver().manage().window().maximize();
    }

    public static void waitForVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void clickAsJavascriptExecutor(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver();
        js.executeScript("arguments[0].click()", webElement);
    }

    public static void awaitToFindElement(By webElement) {
        await().atMost(5, TimeUnit.MINUTES)
                .pollInterval(Duration.ONE_SECOND)
                .until(() -> {
                            try {
                                DriverFactory.getWebDriver().findElement(webElement);
                                return true;
                            } catch (NoSuchElementException e) {
                                return false;
                            }
                        }
                );
    }
}