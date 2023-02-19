package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AutomationPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class UI_TC14_15_PlaceOrderRegisterWhileCheckout {


    AutomationPage page = new AutomationPage();

    @And("Add products to cart")
    public void addProductsToCart() {
        try {
            ReusableMethods.jsScrollClick(page.firstProductAddToCart.get(2));

        } catch (Exception e) {

            System.out.println("Check first product");
            e.printStackTrace();
        }
    }

    @And("Click Cart button.")
    public void clickCartButton() {
        try {
            ReusableMethods.waitForVisibility(page.continueShoppingButton, 5);
            ReusableMethods.jsScrollClick(page.continueShoppingButton);

        } catch (Exception e) {

        }
        ReusableMethods.jsScrollClick(page.cartIcon);
    }

    @Then("Verify that cart page is displayed")
    public void verifyThatCartPageIsDisplayed() {
        ReusableMethods.waitFor(2);

        Assert.assertTrue(page.shoppingCart.isDisplayed());
    }

    @And("Click Proceed To Checkout")
    public void clickProceedToCheckout() {
        page.proceedToCheckoutButton.click();
    }

    @And("Click Register  Login button")
    public void clickRegisterLoginButton() {
        ReusableMethods.waitForVisibility(page.registerLoginButton, 5);
        page.registerLoginButton.click();
    }

    @And("Fill all details in Signup and create account")
    public void fillAllDetailsInSignupAndCreateAccount() {
        page.userName.click();
        ReusableMethods.getActions().sendKeys(ReusableMethods.getFaker().name().name()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().internet().emailAddress()).perform();

        page.signUp2.click();

        page.enter.isDisplayed();

        page.mr.click();
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().internet().password()).perform();

        ReusableMethods.jsScrollClick(page.day);

        ReusableMethods.selectDropDown(page.day);
        ReusableMethods.selectDropDown(page.month);
        ReusableMethods.selectDropDown(page.year);

        ReusableMethods.jsScrollClick(page.firstname);

        ReusableMethods.getActions().click(page.firstname)
                .sendKeys(ReusableMethods.getFaker().name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().address().streetAddress()).perform();

        ReusableMethods.jsScrollClick(page.country);

        ReusableMethods.selectDropDown(page.country);
        ReusableMethods.jsScroll(page.state);
        ReusableMethods.getActions().click(page.state).
                sendKeys(Faker.instance().address().state()).
                sendKeys(Keys.TAB).
                sendKeys(Faker.instance().address().city()).
                sendKeys(Keys.TAB).
                sendKeys(Faker.instance().address().zipCode()).
                sendKeys(Keys.TAB).
                sendKeys(ReusableMethods.getFaker().phoneNumber().phoneNumber()).perform();

        ReusableMethods.jsScroll(page.createAccount);
        ReusableMethods.jsScrollClick(page.createAccount);
    }

    @Then("Verify ACCOUNT CREATED! and click Continue button")
    public void verifyACCOUNTCREATEDAndClickContinueButton() {
        // ReusableMethods.waitForVisibility(auto.accountCreate, 10);
        Assert.assertTrue(page.accountCreate.isDisplayed());
        ReusableMethods.jsScrollClick(page.continueButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.jsScrollClick(page.continueButton);
    }

    @Then("Verify  Logged in as username at top")
    public void verifyLoggedInAsUsernameAtTop() {
        page.logged.isDisplayed();
    }

    @Then("Verify Address Details and Review Your Order")
    public void verifyAddressDetailsAndReviewYourOrder() throws IOException {
        ReusableMethods.waitForVisibility(page.addressDetailsHeader, 5);
        Assert.assertTrue(page.addressDetailsHeader.isDisplayed());

        ReusableMethods.jsScroll(page.reviewYourOrderHeader);
        ReusableMethods.waitForVisibility(page.reviewYourOrderHeader, 5);
        Assert.assertTrue(page.reviewYourOrderHeader.isDisplayed());

        ReusableMethods.getScreenshotWebElement("Cart Items", page.cartItemsVerify);
    }


    @And("Enter description in comment text area and click Place Order")
    public void enterDescriptionInCommentTextAreaAndClickPlaceOrder() {
        page.messageTextBox.sendKeys(ReusableMethods.getFaker().toString());
        ReusableMethods.jsScrollClick(page.placeOrderButton);
    }

    @And("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enterPaymentDetailsNameOnCardCardNumberCVCExpirationDate() {
        ReusableMethods.getActions().click(page.nameOnCardTextBox)
                .sendKeys("AutomationExercise Attempt")
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.getFaker().business().creditCardNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().number().digits(3))
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.dateMonth())
                .sendKeys(Keys.TAB)
                .sendKeys(ReusableMethods.dateYear())
                .perform();
    }

    @And("Click Pay and Confirm Order button")
    public void clickPayAndConfirmOrderButton() {
        page.payAndConfirmOrderButton.click();
    }

    @Then("Verify success message Your order has been placed successfully!")
    public void verifySuccessMessageYourOrderHasBeenPlacedSuccessfully() {
        Assert.assertTrue(page.alertSuccessButton.isDisplayed());
    }

    @Then("Verify ACCOUNT DELETED! and click Continue button")
    public void verifyACCOUNTDELETEDAndClickContinueButton() {
        ReusableMethods.waitForVisibility(page.accountDeletedText, 5);
        Assert.assertTrue(page.accountDeletedText.isDisplayed());
        page.continueButton.click();
    }


}
