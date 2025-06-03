package com.automationexercise.tests.login;

import com.automationexercise.tests.base.TestUtilities;
import com.automationexercise.tests.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestUtilities {

    @Test
    public void loginUserWithCorrectEmailAndPasswordTest() {
        log.info("Ejecutando loginUserWithCorrectEmailAndPassword");
        // Open page
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        // Create new
        //4. Click on 'Signup / Login' button
        LoginPage loginPage = navBarPage.clikSignAndLoginLink();
        SignupPage signupPage = loginPage.fillSignup("Test", "ecam-b2@gmail.com");
        AccountCreatedPage accountCreatedPage = signupPage.createNewAccount(
                "male",
                "testing123",
                "27",
                "April",
                "2000",
                "Jonh",
                "David",
                "Testing SA",
                "Cra 34 N43-23",
                "Street 56 N34-2",
                "Canada",
                "Ontario",
                "Toronto",
                "123443",
                "3223343343"
        );
        accountCreatedPage.clickContinueButton();
        LoginPage loginPage1 = navBarPage.clickLogoutLink();

        //5. Verify 'Login to your account' is visible
        Assert.assertEquals(loginPage1.getTitleLogiPage(), "Login to your account", "No se visualiza el mensaje 'Login to your account'.");
        //6. Enter correct email address and password
        //7. Click 'login' button
        loginPage1.enterEmailLogin("ecam-b2@gmail.com");
        loginPage1.enterPasswordLogin("testing123");
        HomePage homePage = loginPage1.clickLoginButton();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(navBarPage.isLoggerInAsUserDisplayed(), "No se visualiza el mensaje 'Logged in as username'.");
        //9. Click 'Delete Account' button
        DeleteAccountPage deleteAccountPage = navBarPage.clickDeleteAccountLink();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertEquals(deleteAccountPage.getAccountResultMessage(), "ACCOUNT DELETED!", "No se visualiza el mensaje 'ACCOUNT DELETED!'.");
        deleteAccountPage.clickContinueButton();
    }

    @Test
    public void loginUserWithIncorrectEmailAndPasswordTest() {
        log.info("Ejecutando loginUserWithCorrectEmailAndPassword");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //Click on 'Signup / Login' button
        LoginPage loginPage = navBarPage.clikSignAndLoginLink();
        //Enter incorrect email address and password
        loginPage.enterEmailLogin("incorrectaEmail@gmail.com");
        loginPage.enterPasswordLogin("incorrectapassword1");
        //Click 'login' button
        HomePage homePage = loginPage.clickLoginButton();
        //Verify error 'Your email or password is incorrect!' is visible
        Assert.assertEquals(loginPage.getMessageInvalidPassword(), "Your email or password is incorrect!", "No se visualiza el mensaje 'Your email or password is incorrect!'.");
    }

    @Test
    public void logoutUserTest() {
        log.info("Ejecutando registerUserTest");
        // Open page
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        // Go Signup and Login page
        LoginPage loginPage = navBarPage.clikSignAndLoginLink();
        // Create new account
        SignupPage signupPage = loginPage.fillSignup("Elian", "ecam-b7@gmail.com");
        AccountCreatedPage accountCreatedPage = signupPage.createNewAccount(
                "male",
                "testing123",
                "27",
                "April",
                "2000",
                "Jonh",
                "David",
                "Testing SA",
                "Cra 34 N43-23",
                "Street 56 N34-2",
                "Canada",
                "Ontario",
                "Toronto",
                "123443",
                "3223343343"
        );
        accountCreatedPage.clickContinueButton();
        // Verify that 'Logged in as username' is visible
        Assert.assertTrue(navBarPage.isLoggerInAsUserDisplayed(), "No se visualiza el mensaje 'Logged in as username'.");
        // Click 'Logout' button
        LoginPage loginPage1 = navBarPage.clickLogoutLink();
        // Verify that user is navigated to login page
        Assert.assertEquals(loginPage1.getTitleLogiPage(), "Login to your account", "No se visualiza el mensaje 'Login to your account'.");
        // Delete account
        loginPage1.enterEmailLogin("ecam-b7@gmail.com");
        loginPage1.enterPasswordLogin("testing123");
        loginPage1.clickLoginButton();

        DeleteAccountPage deleteAccountPage = navBarPage.clickDeleteAccountLink();
        Assert.assertEquals(deleteAccountPage.getAccountResultMessage(), "ACCOUNT DELETED!", "No se visualiza el mensaje 'ACCOUNT DELETED!'");
        deleteAccountPage.clickContinueButton();
    }
}
