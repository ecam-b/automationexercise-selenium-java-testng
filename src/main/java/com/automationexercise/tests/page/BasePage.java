package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected Logger log;

    public BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    protected WebElement waitUltilElementIsDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUltilElementIsClickeable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void type(String text, By locator) {
        waitUltilElementIsDisplayed(locator).sendKeys(text);
    }

    protected void click(By locator) {
        waitUltilElementIsClickeable(locator).click();
    }

    protected void selectByVisibleOption(String option, By locator) {
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdowm = new Select(dropdownElement);
        dropdowm.selectByVisibleText(option);
    }

    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    protected boolean validateIfMessageIsDisplayed(By locator) {
        try {
            waitUltilElementIsDisplayed(locator);
            return true;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected String getText(By locator, boolean lower) {
        String text = waitUltilElementIsDisplayed(locator).getText();
        return lower ? text.toLowerCase() : text;
    }
}
