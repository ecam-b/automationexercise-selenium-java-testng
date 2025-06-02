package com.automationexercise.tests.products;

import com.automationexercise.tests.base.TestUtilities;
import com.automationexercise.tests.page.NavBarPage;
import com.automationexercise.tests.page.ProductDetailsPage;
import com.automationexercise.tests.page.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends TestUtilities {

    @Test
    public void verifyAllProductsAndProductDetailPageTest() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        log.info("Ejecutando verifyAllProductsAndProductDetailPageTest");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Click on 'Products' button
        ProductsPage productsPage = navBarPage.clickProductsLink();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertEquals(productsPage.getTitleProductsPage(), "ALL PRODUCTS", "No se visualiza el mensaje 'ALL PRODUCTS'.");
        //6. The products list is visible
        Assert.assertTrue(productsPage.getAllProductsList());
        //7. Click on 'View Product' of first product
        ProductDetailsPage details = productsPage.clickFirstViewProductButton();
        //8. User is landed to product detail page
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(details.productNameIsDisplayed(), "No se puede visualizar el nombre del producto.");
        Assert.assertTrue(details.productCategoryIsDisplayed(), "No se puede visualizar la categoria del producto.");
        Assert.assertTrue(details.availabilityIsDisplayed(), "No se puede visualizar la disponibilidad del producto.");
        Assert.assertTrue(details.conditionIsDisplayed(), "No se puede visualizar la condición del producto.");
        Assert.assertTrue(details.brandIsDisplayed(), "No se puede visualizar la marca del producto.");
    }

    @Test
    public void searchProductTest() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        log.info("Ejecutando searchProductTest");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Click on 'Products' button
        ProductsPage productsPage = navBarPage.clickProductsLink();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertEquals(productsPage.getTitleProductsPage(), "ALL PRODUCTS", "No se visualiza el mensaje 'ALL PRODUCTS'.");
        //6. Enter product name in search input and click search button
        String product = "regular fit";
        productsPage.searchAnyProduct(product);
        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertEquals(productsPage.getTitleSearchedProducts(), "searched products", "No se visualiza el mensaje 'SEARCHED PRODUCTS'.");
        //8. Verify all the products related to search are visible
        Assert.assertTrue(productsPage.getNameProductFound().contains(product), "No se visualiza el mensaje el producto buscado.");
    }
}
