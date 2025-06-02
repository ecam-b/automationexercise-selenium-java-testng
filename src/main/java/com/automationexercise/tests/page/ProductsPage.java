package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{
    private By titleAllProductsLocator = By.cssSelector("h2.title");
    private By productsCardsLocator = By.className("product-image-wrapper");
    private By viewProductButtonLocator = By.cssSelector("div.product-image-wrapper ul.nav a");


    public ProductsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getTitleProductsPage() {
        return waitUltilElementIsDisplayed(titleAllProductsLocator).getText();
    }

    public boolean getAllProductsList() {
        try {
            List<WebElement> allProducts = driver.findElements(productsCardsLocator);
            return true;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public ProductDetailsPage clickFirstViewProductButton() {
        scrollToElement(viewProductButtonLocator);
        click(viewProductButtonLocator);
        return new ProductDetailsPage(driver, log);
    }






}
