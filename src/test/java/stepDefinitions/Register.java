package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import org.openqa.selenium.Keys;
import pages.AutomationPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.*;

public class Register {

    AutomationPage page = new AutomationPage();
    static String email;
    static String password;
    static String name;
    static String company;
    static String phoneNumber;
    static String firstname;
    static String lastname;
    static String address1;
    static String address2;
    static String state;
    static String city;
    static String zipcode;
    static String country;
    static String gender;


    @Before(order = 1, value = "@TC002")
    public void registerUser() {

        email = Faker.instance().internet().emailAddress();
        password = Faker.instance().internet().password();

        Driver.getDriver().get(ConfigurationReader.getProperty("automationExercisesUrl"));
        jsScrollClick(page.signupLoginLink);
        page.nameBoxSignup.sendKeys(Faker.instance().name().name());
        page.emailBoxSignup.sendKeys(email);
        page.signupButton.click();
        page.genderList.get(0).click();
        page.passwordBoxNewSignup.sendKeys(password);
        ReusableMethods.jsScrollClick(page.dayDDM);
        selectDropDown(page.dayDDM);
        selectDropDown(page.monthDDM);
        selectDropDown(page.yearDDM);
        jsScrollClick(page.newsletter);
        jsScrollClick(page.partners);
        ReusableMethods.jsScrollClick(page.firstnameBoxNewSignup);
        jsScroll(page.firstnameBoxNewSignup);
        waitFor(3);
        getActions()
                .click(page.firstnameBoxNewSignup)
                .sendKeys(Faker.instance().name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().company().name()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().address().streetAddress()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().address().fullAddress()).sendKeys(Keys.TAB).perform();

        selectDdmIndex(page.country);
        jsScroll(page.country);
        waitFor(3);
        ReusableMethods.jsScrollClick(page.state);

        getActions()
                .click(page.state)
                .sendKeys(Faker.instance().address().state()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().address().city()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(Faker.instance().phoneNumber().cellPhone()).perform();
        jsScrollClick(page.createAccountButton);

        Driver.closeDriver();
    }

    public void register() {

        name = Faker.instance().name().name();
        company = Faker.instance().company().name();
        phoneNumber = Faker.instance().phoneNumber().cellPhone();
        firstname = Faker.instance().name().firstName();
        lastname = Faker.instance().name().lastName();
        address1 = Faker.instance().address().streetAddress();
        address2 = Faker.instance().address().streetAddress();
        state = Faker.instance().address().state();
        city = Faker.instance().address().city();
        zipcode = Faker.instance().address().zipCode();

        page.nameBoxSignup.sendKeys(name);
        page.emailBoxSignup.sendKeys(Faker.instance().internet().emailAddress());
        page.signupButton.click();

        int genderIndex = random().nextInt(page.genderList.size());
        page.genderList.get(genderIndex).click();
        gender = page.genderList.get(genderIndex).getText();


        page.passwordBoxNewSignup.sendKeys(Faker.instance().internet().password());

        selectDropDown(page.dayDDM);
        selectDropDown(page.monthDDM);
        selectDropDown(page.yearDDM);
        jsScrollClick(page.newsletter);
        jsScrollClick(page.partners);

        jsScroll(page.firstnameBoxNewSignup);
        waitFor(1);
        getActions()
                .click(page.firstnameBoxNewSignup)
                .sendKeys(firstname).sendKeys(Keys.TAB)
                .sendKeys(lastname).sendKeys(Keys.TAB)
                .sendKeys(company).sendKeys(Keys.TAB)
                .sendKeys(address1).sendKeys(Keys.TAB)
                .sendKeys(address2).sendKeys(Keys.TAB).perform();

        selectDdmIndex(page.country);
        jsScroll(page.country);
        country = select(page.country).getFirstSelectedOption().getText();
        waitFor(1);

        getActions()
                .click(page.state)
                .sendKeys(state).sendKeys(Keys.TAB)
                .sendKeys(city).sendKeys(Keys.TAB)
                .sendKeys(zipcode).sendKeys(Keys.TAB)
                .sendKeys(phoneNumber)
                .perform();
        jsScrollClick(page.createAccountButton);

    }
}