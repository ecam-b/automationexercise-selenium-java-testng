package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By newUserNameFieldLocator = By.name("name");
    private By newUserEmailFieldLocator = By.xpath("//input[@data-qa='signup-email']");
    private By signUpButtonLocator = By.xpath("//button[@data-qa='signup-button']");
    private By userEmailFieldLocator = By.xpath("//input[@data-qa='login-email']");
    private By passwordFieldLocator = By.name("password");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void enterNewUserName(String username) {
        type(username, newUserNameFieldLocator);
    }

    public void enterNewEmail(String email) {
        type(email, newUserEmailFieldLocator);
    }

    public void clickSignUpButton() {
        click(signUpButtonLocator);
    }

    public SignupPage fillSignup(String username, String email) {
        enterNewUserName(username);
        enterNewEmail(email);
        clickSignUpButton();
        return new SignupPage(driver, log);
    }
}
