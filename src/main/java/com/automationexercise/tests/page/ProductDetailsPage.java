package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    private By productNameLocator = By.cssSelector("div.product-information h2");
    private By productCategoryLocator = By.cssSelector("div.product-information p");
    private By availabilityLocator = By.xpath("(//div[@class='product-information']/p)[2]");
    private By conditionLocator = By.xpath("(//div[@class='product-information']/p)[3]");
    private By brandLocator = By.xpath("(//div[@class='product-information']/p)[4]");


    public ProductDetailsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public boolean productNameIsDisplayed() {
        return validateIfMessageIsDisplayed(productNameLocator);
    }

    public boolean productCategoryIsDisplayed() {
        return validateIfMessageIsDisplayed(productCategoryLocator);
    }

    public boolean availabilityIsDisplayed() {
        return validateIfMessageIsDisplayed(availabilityLocator);
    }

    public boolean conditionIsDisplayed() {
        return validateIfMessageIsDisplayed(conditionLocator);
    }

    public boolean brandIsDisplayed() {
        return validateIfMessageIsDisplayed(brandLocator);
    }

}
