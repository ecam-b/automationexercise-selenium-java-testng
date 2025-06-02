package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage{
    private By nameFieldLocator = By.name("name");
    private By emailFieldLocator = By.name("email");
    private By subjectFieldLocator = By.name("subject");
    private By messageFieldLocator = By.id("message");
    private By choseFileLocator = By.name("upload_file");
    private By submitButtonLocator = By.name("submit");
    private By successMessageLocator = By.cssSelector("div.contact-form div.alert-success");


    public ContactUsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void enterName(String name) {
        type(name, nameFieldLocator);
    }

    public void enterEmail(String email) {
        type(email, emailFieldLocator);
    }

    public void enterSubject(String subject) {
        type(subject, subjectFieldLocator);
    }

    public void enterMessage(String message) {
        type(message, messageFieldLocator);
    }

    public void selectFile(String fileName) {
        log.info("Seleccionando  '" + fileName + "' file para subirlo.");
        //Ruta del archivo
        String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
        //Escribir la ruta del archivo en el input
        type(filePath, choseFileLocator);
    }

    public void clickSubmitButton() {
        click(submitButtonLocator);
    }

    public void acceptAlert() {
        switchToAlert().accept();
    }

    public String getMessageSuccessSubmitted() {
        return waitUltilElementIsDisplayed(successMessageLocator).getText();
    }

}
