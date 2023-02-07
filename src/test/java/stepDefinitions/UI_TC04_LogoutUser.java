package stepDefinitions;

import io.cucumber.java.en.And;
import pages.AutomationPage;
import utilities.ConfigurationReader;
import utilities.ReusableMethods;

public class UI_TC04_LogoutUser {

    AutomationPage page = new AutomationPage();

    @And("Click Logout button")
    public void clickLogoutButton() {
        ReusableMethods.jsScrollClick(page.logoutButton);
    }

    @And("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        page.loginToYourAccountText.isDisplayed();
    }
}