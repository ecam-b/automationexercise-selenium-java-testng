package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    private By address1Locator = By.xpath("(//ul[@id='address_delivery']/li[@class='address_address1 address_address2'])[2]");
    private By address2Locator = By.xpath("(//ul[@id='address_delivery']/li[@class='address_address1 address_address2'])[3]");
    private By descriptionFieldLocator = By.name("message");
    private By placeOrderButtonLocator = By.linkText("Place Order");

    public CheckoutPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getAddress1Text() {
        return getText(address1Locator, false);
    }

    public String getAddress2Text() {
        return getText(address2Locator, false);
    }

    public void enterDescription(String description) {
        type(description, descriptionFieldLocator);
    }

    public PaymentPage clickPlaceOrder() {
        click(placeOrderButtonLocator);
        return new PaymentPage(driver, log);
    }


}
