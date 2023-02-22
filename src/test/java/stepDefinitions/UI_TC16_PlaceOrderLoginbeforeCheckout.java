package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AutomationPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static utilities.Driver.getDriver;
import static utilities.ReusableMethods.*;

public class UI_TC16_PlaceOrderLoginbeforeCheckout {

    AutomationPage page = new AutomationPage();

    static String phoneNumber;
    static String firstname;
    static String lastname;
    static String country;

    @And("Fill email, password and click Login button")
    public void fillEmailPasswordAndClickLoginButton() {
        //getDriver().switchTo().newWindow(WindowType.TAB).get(ConfigurationReader.getProperty("automationExercisesUrl"));
        List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windows.get(1));

        String email = Faker.instance().internet().emailAddress();
        String password = Faker.instance().internet().password();
        firstname = Faker.instance().name().firstName();
        lastname = Faker.instance().name().lastName();
        phoneNumber = Faker.instance().phoneNumber().cellPhone();

        jsScrollClick(page.signupLoginLink);
        page.nameBoxSignup.sendKeys(Faker.instance().name().name());
        page.emailBoxSignup.sendKeys(email);
        page.signupButton.click();
        page.genderList.get(0).click();
        page.passwordBoxNewSignup.sendKeys(password);

        selectDropDown(page.dayDDM);
        selectDropDown(page.monthDDM);
        selectDropDown(page.yearDDM);
        jsScrollClick(page.newsletter);
        jsScrollClick(page.partners);

        jsScroll(page.firstnameBoxNewSignup);
        waitFor(2);
        getActions()
                .click(page.firstnameBoxNewSignup)
                .sendKeys(firstname).sendKeys(Keys.TAB)
                .sendKeys(lastname).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().company().name()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().address().streetAddress()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().address().fullAddress()).sendKeys(Keys.TAB).perform();

        selectDdmIndex(page.country);
        country = select(page.country).getFirstSelectedOption().getText();
        jsScroll(page.country);
        waitFor(2);

        getActions()
                .click(page.state)
                .sendKeys(Faker.instance().address().state()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().address().city()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(phoneNumber).perform();
        jsScrollClick(page.createAccountButton);


        getDriver().switchTo().window(windows.get(0));


        page.emailBoxLogin.sendKeys(email);
        page.passwordBoxLogin.sendKeys(password);

        ReusableMethods.jsScrollClick(page.loginButton);
    }
     @And("Enter description in comment text area and click Place Order.")
     public void enterDescriptionInCommentTextAreaAndClickPlaceOrder() {
         page.ProceedToCheckout.click();
         Assert.assertTrue(page.addressDetails.isDisplayed());
         page.orderButton.sendKeys("This product is awesome");
         page.placeOrderButton.click();
         getDriver().navigate().refresh();
         page.orderButton.sendKeys("This product is awesome");
         page.placeOrderButton.click();


     }
    @And("Enter payment details: Name on Card, Card Number, CVC, Expiration date.")
    public void enterPaymentDetailsNameOnCardCardNumberCVCExpirationDate() {
       Driver.getDriver().navigate().refresh();
       page.placeOrderButton.click();
      // page.dismisButton.click();
       ReusableMethods.getActions().click(page.nameOnCardTextBox)
               .sendKeys("AutomationExcersize Attempt")
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

}
