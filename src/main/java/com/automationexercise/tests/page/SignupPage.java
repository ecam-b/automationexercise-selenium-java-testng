package com.automationexercise.tests.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage{
    private By maleCheckboxLocator = By.id("id_gender1");
    private By femaleCheckboxLocator = By.id("id_gender2");
    private By passwordFieldLocator = By.id("password");
    private By daySelectLocator = By.id("days");
    private By monthSelectLocator = By.id("months");
    private By yearSelectLocator = By.id("years");
    private By newsletterCheckboxLocator = By.id("newsletter");
    private By specialOffersCheckboxLocator = By.id("optin");
    private By firstNameFieldLocator = By.id("first_name");
    private By lastNameFieldLocator = By.id("last_name");
    private By companyNameFieldLocator = By.id("company");
    private By addressFieldLocator = By.id("address1");
    private By address2FieldLocator = By.id("address2");
    private By countrySelectLocator = By.id("country");
    private By stateFieldLocator = By.id("state");
    private By cityFieldLocator = By.id("city");
    private By zipcodeFieldLocator = By.id("zipcode");
    private By mobileNumberFieldLocator = By.id("mobile_number");
    private By createAccountButtonLocator = By.xpath("//button[@data-qa='create-account']");




    public SignupPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void clickGender(String gender) {
        if (gender.toLowerCase() == "female") {
            click(femaleCheckboxLocator);
        } else {
            click(maleCheckboxLocator);
        }
    }

    public void enterPassword(String password) {
        type(password, passwordFieldLocator);
    }

    public void selectDay(String opcion) {
        selectByVisibleOption(opcion, daySelectLocator);
    }

    public void selectMonth(String opcion) {
        selectByVisibleOption(opcion, monthSelectLocator);
    }

    public void selectYear(String opcion) {
        selectByVisibleOption(opcion, yearSelectLocator);
    }

    public void clickNewsletterCheckbox() {
        click(newsletterCheckboxLocator);
    }

    public void clickSpecialOffersCheckbox() {
        click(specialOffersCheckboxLocator);
    }

    public void enterFirstName(String firstName) {
        type(firstName, firstNameFieldLocator);
    }

    public void enterLasttName(String lastName) {
        type(lastName, lastNameFieldLocator);
    }

    public void enterCompanyName(String companyName) {
        type(companyName, companyNameFieldLocator);
    }

    public void enterAddress(String address) {
        type(address, addressFieldLocator);
    }

    public void enterAddress2(String address2) {
        type(address2, address2FieldLocator);
    }

    public void selectCountry(String option) {
        selectByVisibleOption(option, countrySelectLocator);
    }

    public void enterState(String state) {
        type(state, stateFieldLocator);
    }

    public void enterCity(String city) {
        type(city, cityFieldLocator);
    }

    public void enterZipcode(String zipcode) {
        type(zipcode, zipcodeFieldLocator);
    }

    public void enterMobileNumber(String number) {
        type(number, mobileNumberFieldLocator);
    }

    public AccountCreatedPage clickCreateAccount() {
        click(createAccountButtonLocator);
        return new AccountCreatedPage(driver, log);
    }


}
