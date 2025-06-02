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
    private By searchProductFieldLocator = By.id("search_product");
    private By searchButtonLocator = By.id("submit_search");
    private By productFoundLocator = By.cssSelector("div.productinfo p");
    private By titleSearchedProductsLocator = By.cssSelector("h2.title");



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

    public void enterSearchProduct(String product) {
        type(product, searchProductFieldLocator);
    }

    public void clickSearchProductButton() {
        click(searchButtonLocator);
    }

    public void searchAnyProduct(String product) {
        enterSearchProduct(product);
        clickSearchProductButton();
    }

    public String getNameProductFound() {
        return getText(productFoundLocator, true);
    }

    public String getTitleSearchedProducts() {
        return getText(titleSearchedProductsLocator, true);
    }








}
