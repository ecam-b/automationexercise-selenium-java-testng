package com.automationexercise.tests.contactus;

import com.automationexercise.tests.base.TestUtilities;
import com.automationexercise.tests.page.ContactUsPage;
import com.automationexercise.tests.page.NavBarPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTests extends TestUtilities {

    @Test
    public void contactUsFormTest() {
        log.info("Ejecutando contactUsFormTest");
        //Open page
        NavBarPage navBarPage = new NavBarPage(driver, log);
        navBarPage.openPage();
        //4. Click on 'Contact Us' button
        ContactUsPage contactUsPage = navBarPage.clickContactUsLink();
        //6. Enter name, email, subject and message
        contactUsPage.enterName("Testing con selenium");
        contactUsPage.enterEmail("testing@gmail.com");
        contactUsPage.enterSubject("Pruebas automatizadas");
        contactUsPage.enterMessage("Comentario de prueba");
        //7. Upload file
        String fileName = "instagram.png";
        contactUsPage.selectFile(fileName);
        //8. Click 'Submit' button
        contactUsPage.clickSubmitButton();
        //9. Click OK button
        contactUsPage.acceptAlert();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertEquals(contactUsPage.getMessageSuccessSubmitted(), "Success! Your details have been submitted successfully.", "No se visualiza el mensaje 'Success! Your details have been submitted successfully.'");
    }
}
