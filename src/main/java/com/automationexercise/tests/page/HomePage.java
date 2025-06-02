package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By subscriptionEmailFieldLocator = By.id("susbscribe_email");
    private By submitSubscriptionButtonLocator = By.id("subscribe");
    private By subscriptionTitleLocation = By.cssSelector("div.single-widget h2");
    private By successfullySubscribedMessageLocator = By.cssSelector("div.alert-success.alert");
    private By viewProductButtonLocator = By.cssSelector("div.product-image-wrapper ul.nav a");


    public HomePage(WebDriver driver, Logger log) {
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

    public ProductDetailsPage clickFirstViewProductButton() {
        scrollToElement(viewProductButtonLocator);
        click(viewProductButtonLocator);
        return new ProductDetailsPage(driver, log);
    }





}
