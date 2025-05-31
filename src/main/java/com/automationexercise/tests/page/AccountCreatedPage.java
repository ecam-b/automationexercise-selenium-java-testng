package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {
    private By accountCreatedMessageLocator = By.xpath("//h2[@data-qa='account-created']/b");
    private By continuebuttonLocator = By.xpath("//a[@data-qa='continue-button']");


    public AccountCreatedPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getAccountResultMessage() {
        return waitUltilElementIsDisplayed(accountCreatedMessageLocator).getText();
    }

    public HomePage clickContinueButton() {
        click(continuebuttonLocator);
        return new HomePage(driver, log);
    }


}
