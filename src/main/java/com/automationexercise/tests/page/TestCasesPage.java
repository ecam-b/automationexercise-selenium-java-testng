package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {
    private By titleTestCasesPageLocator = By.cssSelector("h2.title");

    public TestCasesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getTitleText() {
        return waitUltilElementIsDisplayed(titleTestCasesPageLocator).getText().toLowerCase();
    }

}
