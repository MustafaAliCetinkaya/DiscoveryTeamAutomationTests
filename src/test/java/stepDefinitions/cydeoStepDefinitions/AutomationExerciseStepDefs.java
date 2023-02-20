package stepDefinitions.cydeoStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.AutomationPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AutomationExerciseStepDefs {
    AutomationPage auto = new AutomationPage();

    @Given("User is on the automation webpage")
    public void user_is_on_the_automation_webpage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("automationExercisesUrl"));

    }
    @When("User clicks on the products button")
    public void user_clicks_on_the_products_button() {
        auto.forceToClickIfAdDisplayed(auto.productsButton);

    }
    @When("User types {string} to the search box and clicks on the search button")
    public void user_types_to_the_search_box_and_clicks_on_the_search_button(String string) {
        auto.searchProductBox.sendKeys(string);
        auto.searchButtonIcon.click();
    }


    @Then("First search result's price should be {string}")
    public void first_search_result_s_price_should_be(String string) {
        String firstProductPrice=auto.firstSearchProductPrice.getText().substring(4);
        System.out.println(firstProductPrice);
        Assert.assertEquals(string,firstProductPrice);
    }

    @Then("First search result's header should equal to {string}")
    public void firstSearchResultSHeaderShouldEqualTo(String string) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,400)", "");
        String firstProductName=auto.firstSearchProductName.getText();
        System.out.println(firstProductName);
        Assert.assertTrue(firstProductName.equals(string));
    }
}
