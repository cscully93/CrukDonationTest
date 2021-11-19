package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"helpers", "pages"})
public class steps {

    private static final ConfigurableApplicationContext context = SpringApplication.run(steps.class);
    private static final helpers.driverHelper driverHelper = context.getBean(helpers.driverHelper.class);
    private static final pages.donationFirstPage firstPage = context.getBean(pages.donationFirstPage.class);
    private static final pages.donationSecondPage secondPage = context.getBean(pages.donationSecondPage.class);
    private static final pages.donationThirdPage thirdPage = context.getBean(pages.donationThirdPage.class);

    @Before
    public void before(Scenario scenario) {
        String scenarioName = scenario.getName();
        System.out.println("------------------------------");
        System.out.println("Running Scenario: " + scenarioName);
        System.out.println("------------------------------");
        driverHelper.setupWebDriver();
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driverHelper.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure on Scenario: " + scenario.getName()); // ... and embed it in the report.
        }
        driverHelper.closeDriver();
        System.out.println("------------------------------");
        System.out.println("Scenario has completed");
        System.out.println("------------------------------");
    }

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() throws InterruptedException {
        firstPage.clickCookieButton();
    }

    @When("the user enters other amount of {}")
    public void the_user_enters_other_amount_of(String otherAmountValue) {
        firstPage.enterOtherAmountValue(otherAmountValue);
    }

    @And("the user selects the own money radio button")
    public void the_user_selects_the_own_money_radio_button() {
        firstPage.clickOwnMoneyRadioBtn();
    }

    @When("the user selects motivation of {}")
    public void select_motivation_of_in_memory_of_someone(String motivation) {
        firstPage.selectMotivation(motivation);
    }

    @And("the user selects the greatest need radio button")
    public void the_user_selects_greatest_need_radio_button() {
        firstPage.clickDestinationRadioBtn();
    }

    @When("the user clicks on Continue button")
    public void the_user_click_on_continue_button() {
        firstPage.clickContinueBtn();
    }

    @When("the user clicks on Continue button on second page")
    public void the_user_click_on_continue_button_second_page() throws InterruptedException { secondPage.clickContinueBtn(); }

    @When("the user selects title as {}")
    public void the_user_selects_title(String title) {
        secondPage.selectTitle(title);
    }

    @When("the user enters first name as {}")
    public void the_user_enters_first_name(String firstName) {
        secondPage.enterFirstName(firstName);
    }

    @When("the user enters surname as {}")
    public void the_user_enters_surname(String surname) {
        secondPage.enterSurname(surname);
    }

    @When("the user enters email address as {}")
    public void the_user_email_address(String emailAddress) {
        secondPage.enterEmailAddress(emailAddress);
    }

    @When("the user enters phone number as {}")
    public void the_user_phone_number_as(String phoneNumber) {
        secondPage.enterPhoneNumber(phoneNumber);
    }

    @When("the user enters post code as {}")
    public void the_user_enter_post_code(String postCode) {
        secondPage.enterPostCode(postCode);
    }

    @When("the user selects the PayPal option")
    public void the_user_selects_visa() {
        thirdPage.selectPaypalOption();
    }

    @Then("verify the user is on the payments page")
    public void userVerifyOnPaymentsPage() {
        thirdPage.userVerifyOnPaymentsPage();
    }

    @Then("verify correct empty error messages are displayed on donation page")
    public void verify_correct_empty_error_messages_are_displayed() {
        firstPage.verifyDonationAmountEmptyErrorMessage();
        firstPage.verifyDonationTypeEmptyErrorMessage();
    }

    @Then("verify correct invalid error messages are displayed on donation page")
    public void verify_correct_invalid_error_messages_are_displayed_on_first_page() {
        firstPage.verifyDonationAmountInvalidErrorMessage();
    }

    @Then("verify correct empty error messages are displayed on contact details page")
    public void verify_correct_empty_error_messages_are_displayed_on_second_page() {
        secondPage.verifyFirstNameEmptyErrorMessage();
        secondPage.verifySurnameEmptyErrorMessage();
        secondPage.verifyEmailAddressEmptyErrorMessage();
        secondPage.verifyPhoneNumberEmptyErrorMessage();
        secondPage.verifyPostCodeEmptyErrorMessage();
    }

    @Given("the user completes the donation page")
    public void the_user_completes_donation_page() {
        firstPage.enterOtherAmountValue("25");
        firstPage.clickOwnMoneyRadioBtn();
        firstPage.selectMotivation("I or a loved one has cancer");
        firstPage.clickDestinationRadioBtn();
        firstPage.clickContinueBtn();
    }

    @Given("the user enters invalid post code as {}")
    public void the_user_enters_invalid_post_code_as_xox(String invalidPostCode) {
        secondPage.enterInvalidPostCode(invalidPostCode);
    }

    @Then("verify correct invalid error messages are displayed on contact details page")
    public void verify_correct_invalid_error_messages_are_displayed_on_second_page() {
        secondPage.verifyFirstNameInvalidErrorMessage();
        secondPage.verifySurnameEmptyInvalidMessage();
        secondPage.verifyEmailAddressInvalidErrorMessage();
        secondPage.verifyPhoneNumberInvalidErrorMessage();
        secondPage.verifyPostCodeInvalidErrorMessage();
    }

    @Then("verify correct surname too short error message is displayed on contact details page")
    public void verify_correct_surname_too_short_error_message_is_displayed_on_contact_details_page() {
        secondPage.verifySurnameShortErrorMessage();
    }

}
