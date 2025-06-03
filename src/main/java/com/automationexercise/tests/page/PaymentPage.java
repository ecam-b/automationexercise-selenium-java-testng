package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{
    private By nameOnCardFieldLocator = By.name("name_on_card");
    private By cardNumberFieldLocator = By.name("card_number");
    private By cvcFieldLocator = By.name("cvc");
    private By expiryMonthFieldLocator = By.name("expiry_month");
    private By expiryYearFieldLocator = By.name("expiry_year");
    private By payAndConfirmOrderLocator = By.id("submit");

    public PaymentPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void enterNameOnCard(String name) {
        type(name, nameOnCardFieldLocator);
    }

    public void enterCardNumber(String number) {
        type(number, cardNumberFieldLocator);
    }

    public void enterCvcCard(String cvc) {
        type(cvc, cvcFieldLocator);
    }

    public void enterExpiryMonth(String month) {
        type(month, expiryMonthFieldLocator);
    }

    public void enterExpiryYear(String year) {
        type(year, expiryYearFieldLocator);
    }

    public PaymentDonePage clickPayAndConfirmOrder() {
        click(payAndConfirmOrderLocator);
        return new PaymentDonePage(driver, log);
    }

    public void fillCreditCardForm(String name, String number, String cvc, String month, String year) {
        enterNameOnCard(name);
        enterCardNumber(number);
        enterCvcCard(cvc);
        enterExpiryMonth(month);
        enterExpiryYear(year);
    }


}
