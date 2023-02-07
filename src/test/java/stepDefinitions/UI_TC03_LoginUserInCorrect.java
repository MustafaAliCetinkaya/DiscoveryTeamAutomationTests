package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AutomationPage;

public class UI_TC03_LoginUserInCorrect {

    AutomationPage page = new AutomationPage();

    @Then("Enter incorrect email address and password")
    public void enter_incorrect_email_address_and_password() {
        page.emailBoxLogin.sendKeys("invalid@gmail.com");
        page.passwordBoxLogin.sendKeys("i.n.v.l.i.d.007");
    }

    @Then("Verify error Your email or password is incorrect! is visible")
    public void verify_error_your_email_or_password_is_incorrect_is_visible() {
        Assert.assertTrue(page.yourEmailOrPasswordIsIncorrect.isDisplayed());
    }
}

