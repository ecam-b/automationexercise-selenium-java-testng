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
        SignupPage signupPage = loginPage.fillSignup("Elian", "elian14@gmail.com");
        // Fill details: Title, Name, Email, Password, Date of birth
        signupPage.clickGender("male");
        signupPage.enterPassword("testing123");
        signupPage.selectDay("27");
        signupPage.selectMonth("April");
        signupPage.selectYear("2000");
        // Select checkbox 'Sign up for our newsletter!'
        signupPage.clickNewsletterCheckbox();
        // Select checkbox 'Receive special offers from our partners!'
        signupPage.clickSpecialOffersCheckbox();
        // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        signupPage.enterFirstName("Jonh");
        signupPage.enterLasttName("David");
        signupPage.enterCompanyName("testing SA");
        signupPage.enterAddress("Cra 34 N43-23");
        signupPage.enterAddress2("Calle 56 N34-2");
        signupPage.selectCountry("Canada");
        signupPage.enterState("Ontario");
        signupPage.enterCity("Toronto");
        signupPage.enterZipcode("123443");
        signupPage.enterMobileNumber("3223343343");
        // Click 'Create Account button'
        AccountCreatedPage accountCreatedPage = signupPage.clickCreateAccount();
        // Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertEquals("ACCOUNT CREATED!", accountCreatedPage.getAccountResultMessage(), "No se visualiza el mensaje 'ACCOUNT CREATED!'");
        // Click 'Continue' button
        accountCreatedPage.clickContinueButton();
        // Verify that 'Logged in as username' is visible
        Assert.assertTrue(navBarPage.isLoggerInAsUserDisplayed(), "No se visualiza el mensaje 'Logged in as username'.");
        // Click 'Delete Account' button
        DeleteAccountPage deleteAccountPage = navBarPage.clickDeleteAccountLink();
        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertEquals("ACCOUNT DELETED!", deleteAccountPage.getAccountResultMessage(), "No se visualiza el mensaje 'ACCOUNT DELETED!'");
        deleteAccountPage.clickContinueButton();

    }
}
