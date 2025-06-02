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
    public void registerUserWithExistingEmailTest() {
        // Pre-conditions: Para este test es necesario tener un usuario creado, se puede hacer con pasos de ejecuciones previos con APIs
        log.info("Ejecutando registerUserWithExistingEmail");
        // Open page
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Click on 'Signup / Login' button
        LoginPage loginPage = navBarPage.clikSignAndLoginLink();
        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        loginPage.fillSignup("Elian", "ecam-b101@gmail.com");
        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertEquals(loginPage.getMessageEmailAlreadyExist(), "Email Address already exist!", "No se visualiza el mensaje 'Email Address already exist!'");
    }

}
