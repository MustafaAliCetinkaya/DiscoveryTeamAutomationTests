package stepDefinitions;

import io.cucumber.java.en.And;
import pages.AutomationPage;
import utilities.ConfigurationReader;

public class UI_TC05_RegisterUserwithExistingEmail {

    AutomationPage page = new AutomationPage();
    @And("Enter name and already registered email address")
    public void enterNameAndAlreadyRegisteredEmailAddress() {
        page.nameBoxSignup.sendKeys(ConfigurationReader.getProperty("name"));
        page.emailBoxSignup.sendKeys(ConfigurationReader.getProperty("aeInvalidEmail"));
    }
    @And("Verify error Email Address already exist! is visible")
    public void verifyErrorEmailAddressAlreadyExistIsVisible() {
        page.emailAlreadyExistText.isDisplayed();
    }
}