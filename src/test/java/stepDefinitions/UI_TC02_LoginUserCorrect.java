package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.AutomationPage;

import utilities.Driver;
import utilities.ReusableMethods;

public class UI_TC02_LoginUserCorrect {

    AutomationPage page = new AutomationPage();

    @Then("Verify Login to your account is visible")
    public void verifyLoginToYourAccountIsVisible() {
        Assert.assertTrue(page.loginToYourAccountText.isDisplayed());
    }
    @And("Enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {//Linked with Register class value--> @Before(order = 1, value = "@TC002")
        page.emailBoxLogin.sendKeys(Register.email);
        page.passwordBoxLogin.sendKeys(Register.password);
    }
    @And("Click login button")
    public void clickLoginButton() {
        ReusableMethods.jsScrollClick(page.loginButton);
    }
    @And("Verify that ACCOUNT DELETED! is visible")
    public void verifyThatACCOUNTDELETEDIsVisible() {
        ReusableMethods.jsScrollClick(page.delete);
        /*
        //Close the goddamn ad window
        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().switchTo().frame("ad_iframe");
        Driver.getDriver().findElement(By.cssSelector("div#dismiss-button")).click();
        Driver.getDriver().switchTo().parentFrame();*/

        Assert.assertTrue(page.accountDeletedText.isDisplayed());
    }
}