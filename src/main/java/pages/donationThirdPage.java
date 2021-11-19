package pages;

import helpers.driverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
@ComponentScan(basePackages = {"helpers"})
public class donationThirdPage {

    @Autowired
    protected driverHelper driverHelper;
    @Value("${cruk.payment.url}")
    protected String paymentUrl;
    private String payPalOptionSelector = "//input[@id='paypal1']/parent::label";

    public void selectPaypalOption() {
        WebDriverWait wait = driverHelper.setupWait();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(payPalOptionSelector)));
        WebElement visaOption = driverHelper.findElementByXpath(payPalOptionSelector);
        visaOption.click();
    }

    public void userVerifyOnPaymentsPage() {
        Assert.assertEquals(driverHelper.driver.getCurrentUrl(), paymentUrl,"Unexpected URL found");
    }

}
