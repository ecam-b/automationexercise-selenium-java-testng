package com.automationexercise.tests.testcases;

import com.automationexercise.tests.base.TestUtilities;
import com.automationexercise.tests.page.NavBarPage;
import com.automationexercise.tests.page.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesTests extends TestUtilities {

    @Test
    public void verifyTestCasesPageTest() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        log.info("Ejecutando verifyTestCasesPageTest");
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Click on 'Test Cases' button
        TestCasesPage testCasesPage = navBarPage.clickTestCasesLink();
        //5. Verify user is navigated to test cases page successfully
        Assert.assertEquals(testCasesPage.getTitleText(), "test cases", "No se visualiza el mensaje 'Test Cases'");
    }
}
