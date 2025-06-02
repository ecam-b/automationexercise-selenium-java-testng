package com.automationexercise.tests.home;

import com.automationexercise.tests.base.TestUtilities;
import com.automationexercise.tests.page.HomePage;
import com.automationexercise.tests.page.NavBarPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTests extends TestUtilities {

    @Test
    public void verifySubscriptionInHomePage() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        log.info("Ejecutando verifySubscriptionInHomePage");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Scroll down to footer
        HomePage homePage = new HomePage(driver, log);
        homePage.scrollToBottonPage();
        //5. Verify text 'SUBSCRIPTION'
        Assert.assertEquals(homePage.getSubscriptionTitle(), "subscription", "No se visualiza el mensaje 'SUBSCRIPTION'.");
        //6. Enter email address in input and click arrow button
        homePage.enterSubscriptionEmail("testing@gmail.com");
        homePage.clickSubmitSubscription();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertEquals(homePage.getSuccessfulSendSubscription(), "You have been successfully subscribed!", "No se visualiza el mensaje 'You have been successfully subscribed!'.");
    }
}
