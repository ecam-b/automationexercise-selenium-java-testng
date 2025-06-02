package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    private By subscriptionEmailFieldLocator = By.id("susbscribe_email");
    private By submitSubscriptionButtonLocator = By.id("subscribe");
    private By subscriptionTitleLocation = By.cssSelector("div.single-widget h2");
    private By successfullySubscribedMessageLocator = By.cssSelector("div.alert-success.alert");
    private By productsVisiblesLocator = By.cssSelector("tr td.cart_product");
    private By productPriceLocator = By.cssSelector("tr td.cart_price");
    private By quantityLocator = By.cssSelector("td.cart_quantity");
    private By totalPriceLocator = By.cssSelector("td.cart_total p.cart_total_price");


    public CartPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void scrollToBottonPage() {
        scrollToBotton();
    }

    public void enterSubscriptionEmail(String email) {
        type(email, subscriptionEmailFieldLocator);
    }

    public void clickSubmitSubscription() {
        click(submitSubscriptionButtonLocator);
    }

    public String getSubscriptionTitle() {
        return getText(subscriptionTitleLocation, true);
    }

    public String getSuccessfulSendSubscription() {
        return getText(successfullySubscribedMessageLocator, false);
    }

    public int countProductsAvailables() {
        List<WebElement> products = findAll(productsVisiblesLocator);
        return products.size();
    }

    public boolean productPriceIsDisplayed() {
        return validateIfMessageIsDisplayed(productPriceLocator);
    }

    public boolean productQuantityIsDisplayed() {
        return validateIfMessageIsDisplayed(quantityLocator);
    }

    public boolean productTotalPriceIsDisplayed() {
        return validateIfMessageIsDisplayed(totalPriceLocator);
    }


}
