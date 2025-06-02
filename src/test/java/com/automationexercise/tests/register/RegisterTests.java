package com.automationexercise.tests.register;

import com.automationexercise.tests.base.TestUtilities;
import com.automationexercise.tests.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests extends TestUtilities {

    @Test
    public void registerUserTest() {
        log.info("Ejecutando registerUserTest");
        // Open page
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        // Go Signup and Login page
        LoginPage loginPage = navBarPage.clikSignAndLoginLink();
        // Enter name and email address
        // Click 'Signup' button
        SignupPage signupPage = loginPage.fillSignup("Elian", "ecam-b10@gmail.com");
        // Fill details: Title, Name, Email, Password, Date of birth
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
        // Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertEquals(accountCreatedPage.getAccountResultMessage(), "ACCOUNT CREATED!", "No se visualiza el mensaje 'ACCOUNT CREATED!'");
        // Click 'Continue' button
        accountCreatedPage.clickContinueButton();
        // Verify that 'Logged in as username' is visible
        Assert.assertTrue(navBarPage.isLoggerInAsUserDisplayed(), "No se visualiza el mensaje 'Logged in as username'.");
        // Click 'Delete Account' button
        DeleteAccountPage deleteAccountPage = navBarPage.clickDeleteAccountLink();
        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertEquals(deleteAccountPage.getAccountResultMessage(), "ACCOUNT DELETED!", "No se visualiza el mensaje 'ACCOUNT DELETED!'");
        deleteAccountPage.clickContinueButton();
    }

    @Test
    public void loginUserWithCorrectEmailAndPassword() {
        log.info("Ejecutando loginUserWithCorrectEmailAndPassword");
        // Open page
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        // Create new
        //4. Click on 'Signup / Login' button
        LoginPage loginPage = navBarPage.clikSignAndLoginLink();
        SignupPage signupPage = loginPage.fillSignup("Test", "ecam-b10@gmail.com");
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
        Assert.assertEquals(loginPage1.getTitleLogiPage(), "Login to your account", "No se visualiza el mensaje 'Login to your account");
        //6. Enter correct email address and password
        //7. Click 'login' button
        loginPage1.enterEmailLogin("ecam-b10@gmail.com");
        loginPage1.enterPasswordLogin("testing123");
        HomePage homePage = loginPage1.clickLoginButton();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(navBarPage.isLoggerInAsUserDisplayed(), "No se visualiza el mensaje 'Logged in as username'.");
        //9. Click 'Delete Account' button
        DeleteAccountPage deleteAccountPage = navBarPage.clickDeleteAccountLink();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertEquals(deleteAccountPage.getAccountResultMessage(), "ACCOUNT DELETED!", "No se visualiza el mensaje 'ACCOUNT DELETED!'");
        deleteAccountPage.clickContinueButton();
    }
}
