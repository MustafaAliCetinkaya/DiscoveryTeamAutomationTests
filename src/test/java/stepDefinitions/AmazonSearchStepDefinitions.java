package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AmazonSearchStepDefinitions {

    AmazonPage amazonPageObject=new AmazonPage();
    @Given("user navigate to the amazon homepage")
    public void user_navigate_to_the_amazon_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon"));
    }

    @When("user writes different items to the search box one by one")
    public void user_writes_different_items_to_the_search_box_one_by_one() {
        amazonPageObject.searchItem("game chair");

    }

    @Then("user sorts the items by price from low to high")
    public void user_sorts_the_items_by_price_from_low_to_high() {
        amazonPageObject.sortItemsByPrice();

    }

    @Then("user adds the selected items to the cart one by one")
    public void user_adds_the_selected_items_to_the_cart_one_by_one() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user goes to the cart")
    public void user_goes_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user goes to the checkout page")
    public void user_goes_to_the_checkout_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user fills the related fields for payment")
    public void user_fills_the_related_fields_for_payment() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
