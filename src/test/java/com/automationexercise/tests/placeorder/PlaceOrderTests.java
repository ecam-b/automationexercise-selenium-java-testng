package com.automationexercise.tests.placeorder;

import com.automationexercise.tests.base.TestUtilities;
import com.automationexercise.tests.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTests extends TestUtilities {

    @Test
    public void placeOrderRegisterWhileCheckoutTest() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        log.info("Ejecutando placeOrderRegisterWhileCheckoutTest");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Add products to cart
        HomePage homePage = new HomePage(driver, log);
        homePage.addProductToCartButton(1);
        homePage.clickContinueShopping();
        //5. Click 'Cart' button
        CartPage cartPage = navBarPage.clickCartLink();
        //6. Verify that cart page is displayed
        //7. Click Proceed To Checkout
        cartPage.clickProceedToCheckout();
        //8. Click 'Register / Login' button
        LoginPage loginPage = cartPage.clickRegisterOrLoginLink();
        //9. Fill all details in Signup and create account
        String address1 = "Cra 34 N43-23";
        String address2 = "Street 56 N34-2";
        SignupPage signupPage = loginPage.fillSignup("Elian", "ecam-b4@gmail.com");
        AccountCreatedPage accountCreatedPage = signupPage.createNewAccount(
                "male",
                "testing123",
                "27",
                "April",
                "2000",
                "Jonh",
                "David",
                "Testing SA",
                address1,
                address2,
                "Canada",
                "Ontario",
                "Toronto",
                "123443",
                "3223343343"
        );
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertEquals(accountCreatedPage.getAccountResultMessage(), "ACCOUNT CREATED!", "No se visualiza el mensaje 'ACCOUNT CREATED!'");
        accountCreatedPage.clickContinueButton();
        //11. Verify ' Logged in as username' at top
        Assert.assertTrue(navBarPage.isLoggerInAsUserDisplayed(), "No se visualiza el mensaje 'Logged in as username'.");
        //12.Click 'Cart' button
        CartPage cartPage1 = navBarPage.clickCartLink();
        //13. Click 'Proceed To Checkout' button
        CheckoutPage checkoutPage = cartPage1.clickProceedToCheckout();
        //14. Verify Address Details and Review Your Order
        Assert.assertEquals(checkoutPage.getAddress1Text(), address1, "La dirección mostrada no corresponde a la guardada para la cuenta.");
        Assert.assertEquals(checkoutPage.getAddress2Text(), address2, "La dirección mostrada no corresponde a la guardada para la cuenta.");
        //15. Enter description in comment text area and click 'Place Order'
        checkoutPage.enterDescription("Description");
        PaymentPage paymentPage = checkoutPage.clickPlaceOrder();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        paymentPage.fillCreditCardForm("Mastercard", "5031755734530604", "123", "11", "30");
        //17. Click 'Pay and Confirm Order' button
        PaymentDonePage paymentDonePage = paymentPage.clickPayAndConfirmOrder();
        //18. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(paymentDonePage.getContratulationMessage().contains("your order has been confirmed!"), "No se observa el texto esperado.");
        //19. Click 'Delete Account' button
        DeleteAccountPage deleteAccountPage = navBarPage.clickDeleteAccountLink();
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertEquals(deleteAccountPage.getAccountResultMessage(), "ACCOUNT DELETED!", "No se visualiza el mensaje 'ACCOUNT DELETED!'");
        deleteAccountPage.clickContinueButton();
    }

    @Test
    public void placeOrderRegisterBeforeCheckoutTest() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        log.info("Ejecutando placeOrderRegisterBeforeCheckout");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Click 'Signup / Login' button
        LoginPage loginPage = navBarPage.clikSignAndLoginLink();
        //5. Fill all details in Signup and create account
        String address1 = "Cra 34 N43-23";
        String address2 = "Street 56 N34-2";
        SignupPage signupPage = loginPage.fillSignup("Elian", "ecam-b6@gmail.com");
        AccountCreatedPage accountCreatedPage = signupPage.createNewAccount(
                "male",
                "testing123",
                "27",
                "April",
                "2000",
                "Jonh",
                "David",
                "Testing SA",
                address1,
                address2,
                "Canada",
                "Ontario",
                "Toronto",
                "123443",
                "3223343343"
        );
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertEquals(accountCreatedPage.getAccountResultMessage(), "ACCOUNT CREATED!", "No se visualiza el mensaje 'ACCOUNT CREATED!'");
        accountCreatedPage.clickContinueButton();
        //7. Verify ' Logged in as username' at top
        Assert.assertTrue(navBarPage.isLoggerInAsUserDisplayed(), "No se visualiza el mensaje 'Logged in as username'.");
        //8. Add products to cart
        HomePage homePage = new HomePage(driver, log);
        homePage.addProductToCartButton(1);
        homePage.clickContinueShopping();
        //9. Click 'Cart' button
        CartPage cartPage = navBarPage.clickCartLink();
        //10. Verify that cart page is displayed
        //11. Click Proceed To Checkout
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckout();
        //12. Verify Address Details and Review Your Order
        Assert.assertEquals(checkoutPage.getAddress1Text(), address1, "La dirección mostrada no corresponde a la guardada para la cuenta.");
        Assert.assertEquals(checkoutPage.getAddress2Text(), address2, "La dirección mostrada no corresponde a la guardada para la cuenta.");
        //13. Enter description in comment text area and click 'Place Order'
        checkoutPage.enterDescription("Description");
        PaymentPage paymentPage = checkoutPage.clickPlaceOrder();
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        paymentPage.fillCreditCardForm("Mastercard", "5031755734530604", "123", "11", "30");
        //15. Click 'Pay and Confirm Order' button
        PaymentDonePage paymentDonePage = paymentPage.clickPayAndConfirmOrder();
        //16. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(paymentDonePage.getContratulationMessage().contains("your order has been confirmed!"), "No se observa el texto esperado.");
        //17. Click 'Delete Account' button
        DeleteAccountPage deleteAccountPage = navBarPage.clickDeleteAccountLink();
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertEquals(deleteAccountPage.getAccountResultMessage(), "ACCOUNT DELETED!", "No se visualiza el mensaje 'ACCOUNT DELETED!'");
        deleteAccountPage.clickContinueButton();
    }

    @Test
    public void placeOrderLoginBeforeCheckoutTest() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        log.info("Ejecutando placeOrderLoginBeforeCheckoutTest");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Click 'Signup / Login' button
        LoginPage loginPage = navBarPage.clikSignAndLoginLink();
        //5. Fill email, password and click 'Login' button
        loginPage.enterEmailLogin("ecam-b101@gmail.com");
        loginPage.enterPasswordLogin("testing123");
        HomePage homePage = loginPage.clickLoginButton();
        //6. Verify 'Logged in as username' at top
        Assert.assertTrue(navBarPage.isLoggerInAsUserDisplayed(), "No se visualiza el mensaje 'Logged in as username'.");
        //7. Add products to cart
        homePage.addProductToCartButton(1);
        homePage.clickContinueShopping();
        //8. Click 'Cart' button
        CartPage cartPage = navBarPage.clickCartLink();
        //9. Verify that cart page is displayed
        //10. Click Proceed To Checkout
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckout();
        //11. Verify Address Details and Review Your Order
        //12. Enter description in comment text area and click 'Place Order'
        checkoutPage.enterDescription("Description");
        PaymentPage paymentPage = checkoutPage.clickPlaceOrder();
        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        paymentPage.fillCreditCardForm("Mastercard", "5031755734530604", "123", "11", "30");
        //14. Click 'Pay and Confirm Order' button
        PaymentDonePage paymentDonePage = paymentPage.clickPayAndConfirmOrder();
        //15. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(paymentDonePage.getContratulationMessage().contains("your order has been confirmed!"), "No se observa el texto esperado.");
        //16. Click 'Delete Account' button
        //DeleteAccountPage deleteAccountPage = navBarPage.clickDeleteAccountLink();
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        //Assert.assertEquals(deleteAccountPage.getAccountResultMessage(), "ACCOUNT DELETED!", "No se visualiza el mensaje 'ACCOUNT DELETED!'");
        //deleteAccountPage.clickContinueButton();
    }
}
