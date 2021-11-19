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
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
@ComponentScan(basePackages = {"helpers"})
@PropertySource("application.properties")
public class donationFirstPage {

    @Autowired
    protected driverHelper driverHelper;
    @Value("${amount.value.empty}")
    String amountValueEmptyString;
    @Value("${amount.type.empty}")
    String amountTypeEmptyString;
    @Value("${amount.value.invalid}")
    String amountValueInvalidString;
    private String okCookieBtnSelector = "onetrust-accept-btn-handler";
    private String otherAmountInputSelector = "otherAmount";
    private String ownMoneyRadioBtnSelector = "//input[@id='typeRadioGroup0']/parent::label";
    private String motivationDropdownSelector = "motivation";
    private String destinationRadioBtnSelector = "//input[@id='destinationRadioGroup0']/parent::label";
    private String continueBtnSelector = "//span[text()='Continue']/parent::button";
    private String donationAmountErrorSelector = "donationAmount-error";
    private String donationTypeErrorSelector = "typeRadioGroup-error";

    public void clickCookieButton() throws InterruptedException {
        WebDriverWait wait = driverHelper.setupWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(okCookieBtnSelector)));
        WebElement okCookieButton = driverHelper.findElementById(okCookieBtnSelector);
        okCookieButton.click();
        //had to add this as it appears Cookie policy is sometimes loading twice on the page
        Thread.sleep(3000);
        if (okCookieButton.isDisplayed()) {
            okCookieButton.click();
        }
    }

    public void enterOtherAmountValue(String otherAmountValue) {
        WebElement otherAmountInput = driverHelper.findElementById(otherAmountInputSelector);
        otherAmountInput.sendKeys(otherAmountValue);
    }

    public void clickOwnMoneyRadioBtn() {
        WebElement ownMoneyRadioBtn = driverHelper.findElementByXpath(ownMoneyRadioBtnSelector);
        driverHelper.moveToElement(ownMoneyRadioBtn);
        ownMoneyRadioBtn.click();
    }

    public void selectMotivation(String motivation) {
        WebElement motivationDropdown = driverHelper.findElementByName(motivationDropdownSelector);
        driverHelper.moveToElement(motivationDropdown);
        Select clickThis = new Select(motivationDropdown);
        clickThis.selectByVisibleText(motivation);
    }

    public void clickDestinationRadioBtn() {
        WebElement destinationRadioBtn = driverHelper.findElementByXpath(destinationRadioBtnSelector);
        driverHelper.moveToElement(destinationRadioBtn);
        destinationRadioBtn.click();
    }

    public void clickContinueBtn() {
        WebElement continueBtn = driverHelper.findElementByXpath(continueBtnSelector);
        driverHelper.moveToElement(continueBtn);
        continueBtn.click();
    }

    public void verifyDonationAmountEmptyErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(donationAmountErrorSelector).getText(), amountValueEmptyString, "Unexpected amount value error message returned");
    }

    public void verifyDonationTypeEmptyErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(donationTypeErrorSelector).getText(), amountTypeEmptyString, "Unexpected amount type error message returned");
    }

    public void verifyDonationAmountInvalidErrorMessage() {
        Assert.assertEquals(driverHelper.findElementById(donationAmountErrorSelector).getText(), amountValueInvalidString, "Unexpected amount value error message returned");
    }
}
