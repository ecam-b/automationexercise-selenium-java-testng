package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentDonePage extends BasePage{
    private By congratulationsMessage = By.cssSelector("div.col-sm-9 p");

    public PaymentDonePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getContratulationMessage() {
        return getText(congratulationsMessage, true);
    }


}
