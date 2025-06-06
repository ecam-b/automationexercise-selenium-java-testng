package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class NavBarPage extends BasePage{
    private By signupAndLoginLinkLocator = By.partialLinkText("Signup");
    private By loggedLinkLocator = By.partialLinkText("Logged in as");
    private By deleteAccountLinkLocator = By.partialLinkText("Delete Account");
    private By logoutLinkLocator = By.partialLinkText("Logout");
    private By contactUsLinkLocator = By.partialLinkText("Contact");
    private By testCasesLinkLocator = By.partialLinkText("Test Cases");
    private By productsLinkLocator = By.partialLinkText("Products");
    private By cartLinkLocator = By.xpath("(//ul[@class='nav navbar-nav']/li/a)[3]");

    private String urlPage = "https://automationexercise.com/";

    public NavBarPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage() {
        openUrl(urlPage);
    }

    public void clickSignupAndLoginButton() {
        click(signupAndLoginLinkLocator);
    }

    public LoginPage clikSignAndLoginLink() {
        clickSignupAndLoginButton();
        return new LoginPage(driver, log);
    }

    public boolean isLoggerInAsUserDisplayed() {
        try {
            waitUltilElementIsDisplayed(loggedLinkLocator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public DeleteAccountPage clickDeleteAccountLink() {
        click(deleteAccountLinkLocator);
        return new DeleteAccountPage(driver, log);
    }

    public LoginPage clickLogoutLink() {
        click(logoutLinkLocator);
        return new LoginPage(driver, log);
    }

    public ContactUsPage clickContactUsLink() {
        click(contactUsLinkLocator);
        return new ContactUsPage(driver, log);
    }

    public TestCasesPage clickTestCasesLink() {
        click(testCasesLinkLocator);
        return new TestCasesPage(driver, log);
    }

    public ProductsPage clickProductsLink() {
        click(productsLinkLocator);
        return new ProductsPage(driver, log);
    }

    public CartPage clickCartLink() {
        click(cartLinkLocator);
        return new CartPage(driver, log);
    }


}
