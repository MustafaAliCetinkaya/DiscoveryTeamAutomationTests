package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AutomationPage;
import utilities.BrowserUtils;
import utilities.ReusableMethods;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class UI_TC10_VerifySubscriptionInHomePage {

    AutomationPage page = new AutomationPage();

    @And("Scroll down to footer")
    public void scrollDownToFooter() {
        ReusableMethods.jsScroll(page.subscriptionTitle);
    }

    @And("Verify text SUBSCRIPTION")
    public void verifyTextSUBSCRIPTION() throws IOException {
        assertTrue(page.subscriptionTitle.isDisplayed());
        ReusableMethods.getScreenshotWebElement("SUBSCRIPTION Text", page.subscriptionTitle);
    }

    @And("Enter email address in input and click arrow button")
    public void enterEmailAddressInInputAndClickArrowButton() {
        page.subscriptionEmailBox.sendKeys(Faker.instance().internet().emailAddress());
        BrowserUtils.clickWithJS(page.subscriptionOkButton);
    }

    @Then("Verify success message You have been successfully subscribed! is visible")
    public void verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible() throws IOException {
        ReusableMethods.waitForClickablility(page.successMessageAlert,3);
        assertTrue(page.successMessageAlert.isDisplayed());
        ReusableMethods.getScreenshotWebElement("SuccessMessageAlert", page.successMessageAlert);
    }
}
