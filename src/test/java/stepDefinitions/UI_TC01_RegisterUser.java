package stepDefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AutomationPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static utilities.Driver.getDriver;

public class UI_TC01_RegisterUser {
    AutomationPage auto = new AutomationPage();

    @Given("On the user automation homepage")
    public void onTheUserAutomationHomepage() {
        getDriver().get(ConfigurationReader.getProperty("automationExercisesUrl"));
    }

    @Then("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {
        String expectedData = "https://automationexercise.com/";
        String actualData = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedData, actualData);
    }

    @And("Click on Signup  Login button")
    public void clickOnSignupLoginButton() {
        auto.signUp.click();
    }

    @Then("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        auto.userSignup.isDisplayed();
    }

    @And("Enter name and email address")
    public void enterNameAndEmailAddress() {
        auto.userName.click();
        ReusableMethods.getActions().sendKeys(ReusableMethods.getFaker().name().name()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().internet().emailAddress()).perform();
    }

    @And("Click Signup button")
    public void clickSignupButton() {
        auto.signUp2.click();
    }

    @Then("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible() {
        auto.enter.isDisplayed();
    }

    @And("Fill details: Title, Name, Email, Password, Date of birth")
    public void fillDetailsTitleNameEmailPasswordDateOfBirth() {
        auto.mr.click();
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().internet().password()).pause(2).perform();
        ReusableMethods.waitFor(2);
        ReusableMethods.jsScrollClick(auto.day);
        ReusableMethods.selectDropDown(auto.day);
        ReusableMethods.selectDropDown(auto.month);
        ReusableMethods.selectDropDown(auto.year);
    }

    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
        ReusableMethods.jsScrollClick(auto.newslatter);
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        ReusableMethods.jsScrollClick(auto.partners);
    }

    @Then("Fill details: First name, Last name, Company, Address, Address, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address_country_state_city_zipcode_mobile_number() {
        ReusableMethods.jsScrollClick(auto.firstname);
        ReusableMethods.getActions().click(auto.firstname)
                .sendKeys(ReusableMethods.getFaker().name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().address().streetAddress()).perform();

        ReusableMethods.jsScrollClick(auto.country);
        ReusableMethods.selectDropDown(auto.country);
        ReusableMethods.jsScroll(auto.state);
        ReusableMethods.getActions().click(auto.state).
                sendKeys(Faker.instance().address().state()).
                sendKeys(Keys.TAB).
                sendKeys(Faker.instance().address().city()).
                sendKeys(Keys.TAB).
                sendKeys(Faker.instance().address().zipCode()).
                sendKeys(Keys.TAB).
                sendKeys(ReusableMethods.getFaker().phoneNumber().phoneNumber()).perform();
    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        auto.createAccount.click();
    }

    @Then("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {
        ReusableMethods.waitForVisibility(auto.accountCreate, 10);
    }

    @And("Click Continue button")
    public void clickContinueButton() {
        ReusableMethods.visibilityOfWait(auto.continueButton);
        ReusableMethods.jsClick(auto.continueButton);
    }

    @Then("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
        auto.logged.isDisplayed();
    }

    @And("Click Delete Account button")
    public void clickDeleteAccountButton() {
        ReusableMethods.jsClick(auto.delete);
    }

    @And("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton() {
        auto.accountDelete.isDisplayed();

    }

}