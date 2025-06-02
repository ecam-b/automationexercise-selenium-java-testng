package com.automationexercise.tests.cart;

import com.automationexercise.tests.base.TestUtilities;
import com.automationexercise.tests.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends TestUtilities {

    @Test
    public void verifySubscriptionInHomePageTest() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        log.info("Ejecutando verifySubscriptionInHomePage");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        CartPage cartPage = navBarPage.clickCartLink();
        //4. Scroll down to footer
        cartPage.scrollToBottonPage();
        //5. Verify text 'SUBSCRIPTION'
        Assert.assertEquals(cartPage.getSubscriptionTitle(), "subscription", "No se visualiza el mensaje 'SUBSCRIPTION'.");
        //6. Enter email address in input and click arrow button
        cartPage.enterSubscriptionEmail("testing@gmail.com");
        cartPage.clickSubmitSubscription();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertEquals(cartPage.getSuccessfulSendSubscription(), "You have been successfully subscribed!", "No se visualiza el mensaje 'You have been successfully subscribed!'.");
    }

    @Test
    public void addProductsInCartTest() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        log.info("Ejecutando addProductsInCart");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Click 'Products' button
        ProductsPage productsPage = navBarPage.clickProductsLink();
        //5. Hover over first product and click 'Add to cart'
        productsPage.addProductToCartButton(1);
        //6. Click 'Continue Shopping' button
        productsPage.clickContinueShopping();
        //7. Hover over second product and click 'Add to cart'
        productsPage.addProductToCartButton(2);
        productsPage.clickContinueShopping();
        //8. Click 'View Cart' button
        CartPage cartPage = navBarPage.clickCartLink();
        //9. Verify both products are added to Cart
        Assert.assertEquals(cartPage.countProductsAvailables(), 2, "No se encuentra en numero correcto de productos seleccionados");
        //10. Verify their prices, quantity and total price
        Assert.assertTrue(cartPage.productPriceIsDisplayed(), "El precio del producto no se encuentra visible.");
        Assert.assertTrue(cartPage.productQuantityIsDisplayed(), "La cantidad del producto no se encuentra visible.");
        Assert.assertTrue(cartPage.productTotalPriceIsDisplayed(), "El precio total del producto no se encuentra visible.");
    }

    @Test
    public void verifyProductQuantityInCartTest() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        log.info("Ejecutando verifyProductQuantityInCart");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Click 'View Product' for any product on home page
        HomePage homePage = new HomePage(driver, log);
        ProductDetailsPage details = homePage.clickFirstViewProductButton();
        //5. Verify product detail is opened
        Assert.assertTrue(details.productNameIsDisplayed(), "No se observe el nombre del producto.");
        //6. Increase quantity to 4
        String quantity = "4";
        details.enterQuantityProduct(quantity);
        //7. Click 'Add to cart' button
        details.clickAddToCart();
        //8. Click 'View Cart' button
        CartPage cartPage = details.clickViewCartLink();
        //9. Verify that product is displayed in cart page with exact quantity
        Assert.assertEquals(cartPage.getQuantityProduct(), quantity, "El numero de productos guardados no es correcto.");
    }
}
