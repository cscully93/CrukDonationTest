package pages;

import helpers.driverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
@ComponentScan(basePackages = {"helpers"})
public class donationSecondPage {

    @Autowired
    protected driverHelper driverHelper;
    @Value("${firstname.empty}")
    String firstnameEmptyString;
    @Value("${surname.empty}")
    String surnameEmptyString;
    @Value("${email.address.empty}")
    String emailEmptyString;
    @Value("${phone.number.empty}")
    String phoneNumberEmptyString;
    @Value("${postcode.empty}")
    String postCodeEmptyString;
    @Value("${firstname.invalid}")
    String firstnameInvalidString;
    @Value("${surname.invalid}")
    String surnameInvalidString;
    @Value("${email.address.invalid}")
    String emailInvalidString;
    @Value("${phone.number.invalid}")
    String phoneNumberInvalidString;
    @Value("${postcode.invalid}")
    String postCodeInvalidString;
    @Value("${surname.short}")
    String surnameShortString;
    private String titleDropdownSelector = "title";
    private String firstNameSelector = "forename";
    private String surnameSelector = "surname";
    private String emailAddressSelector = "emailAddress";
    private String phoneNumberSelector = "phoneNumber";
    private String postCodeSelector = "postalCode";
    private String findAddressBtnSelector = "//span[text()='Find address']/parent::button";
    private String addressDropdownSelector = "addressSelection";
    private String continueBtnSelector = "//span[contains(text(),'Continue')]/parent::button";
    private String firstNameSelectorErrorSelector = "forename-error";
    private String surnameSelectorErrorSelector = "surname-error";
    private String emailAddressErrorSelector = "emailAddress-error";
    private String phoneNumberErrorSelector = "phoneNumber-error";
    private String postcodeErrorSelector = "postalCode-error";

    public void selectTitle(String title) {
        WebDriverWait wait = driverHelper.setupWait();
        wait.until(ExpectedConditions.elementToBeClickable(By.name(titleDropdownSelector)));
        WebElement titleDropdown = driverHelper.findElementByName(titleDropdownSelector);
        driverHelper.moveToElement(titleDropdown);
        Select clickThis = new Select(titleDropdown);
        clickThis.selectByVisibleText(title);
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameField = driverHelper.findElementById(firstNameSelector);
        driverHelper.moveToElement(firstNameField);
        firstNameField.sendKeys(firstName);
    }

    public void enterSurname(String surname) {
        WebElement surnameField = driverHelper.findElementById(surnameSelector);
        driverHelper.moveToElement(surnameField);
        surnameField.sendKeys(surname);
    }

    public void enterEmailAddress(String email) {
        WebElement emailAddress = driverHelper.findElementById(emailAddressSelector);
        driverHelper.moveToElement(emailAddress);
        emailAddress.sendKeys(email);
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneNumberField = driverHelper.findElementById(phoneNumberSelector);
        driverHelper.moveToElement(phoneNumberField);
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void enterPostCode(String postCode) {
        WebElement postCodeField = driverHelper.findElementById(postCodeSelector);
        driverHelper.moveToElement(postCodeField);
        postCodeField.sendKeys(postCode);
        WebElement findAddressBtn = driverHelper.findElementByXpath(findAddressBtnSelector);
        findAddressBtn.click();
        WebDriverWait wait = driverHelper.setupWait();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(addressDropdownSelector)));
        WebElement addressSelector = driverHelper.findElementById(addressDropdownSelector);
        driverHelper.moveToElement(addressSelector);
        Select clickThis = new Select(addressSelector);
        clickThis.selectByIndex(1);
    }

    public void enterInvalidPostCode(String postCode) {
        WebElement postCodeField = driverHelper.findElementById(postCodeSelector);
        driverHelper.moveToElement(postCodeField);
        postCodeField.sendKeys(postCode);
    }

    public void clickContinueBtn() throws InterruptedException {
        Thread.sleep(500);
        WebElement continueBtn = driverHelper.findElementByXpath(continueBtnSelector);
        driverHelper.moveToElement(continueBtn);
        continueBtn.click();
    }

    public void verifyFirstNameEmptyErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(firstNameSelectorErrorSelector).getText(), firstnameEmptyString, "Unexpected first name error message returned");
    }

    public void verifySurnameEmptyErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(surnameSelectorErrorSelector).getText(), surnameEmptyString, "Unexpected last name error message returned");
    }

    public void verifyEmailAddressEmptyErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(emailAddressErrorSelector).getText(), emailEmptyString, "Unexpected email address error message returned");
    }

    public void verifyPhoneNumberEmptyErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(phoneNumberErrorSelector).getText(), phoneNumberEmptyString, "Unexpected phone number error message returned");
    }

    public void verifyPostCodeEmptyErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(postcodeErrorSelector).getText(), postCodeEmptyString, "Unexpected post code error message returned");
    }

    public void verifyFirstNameInvalidErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(firstNameSelectorErrorSelector).getText(), firstnameInvalidString, "Unexpected first name error message returned");
    }

    public void verifySurnameEmptyInvalidMessage() {
        Assert.assertEquals(driverHelper.findElementById(surnameSelectorErrorSelector).getText(), surnameInvalidString, "Unexpected last name error message returned");
    }

    public void verifyEmailAddressInvalidErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(emailAddressErrorSelector).getText(), emailInvalidString, "Unexpected email address error message returned");
    }

    public void verifyPhoneNumberInvalidErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(phoneNumberErrorSelector).getText(), phoneNumberInvalidString, "Unexpected phone number error message returned");
    }

    public void verifyPostCodeInvalidErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(postcodeErrorSelector).getText(), postCodeInvalidString, "Unexpected post code error message returned");
    }

    public void verifySurnameShortErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(surnameSelectorErrorSelector).getText(), surnameShortString, "Unexpected last name error message returned");
    }
}
