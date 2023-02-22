package stepDefinitions.cydeoStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cydeoPages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AmazonSearchStepDefinitions {

    AmazonPage amazonPageObject = new AmazonPage();

    @Given("user navigate to the amazon homepage")
    public void user_navigate_to_the_amazon_homepage() {
        Driver.getDriver().get("https://www.amazon.com/");
    }

    @When("user writes different items to the search box one by one")
    public void user_writes_different_items_to_the_search_box_one_by_one() {
        amazonPageObject.searchItem("game chair");
    }

    @And("user sorts the items by price from low to high")
    public void user_sorts_the_items_by_price_from_low_to_high() {
        amazonPageObject.sortItemsByPrice();

    }

    @And("user adds the selected items to the cart one by one")
    public void user_adds_the_selected_items_to_the_cart_one_by_one() {
        amazonPageObject.addItem(amazonPageObject.gameChair);
    }

    @And("user goes to the cart")
    public void user_goes_to_the_cart() {
        amazonPageObject.goCart();
    }

    @Then("user goes to the checkout page")
    public void user_goes_to_the_checkout_page() {
        amazonPageObject.goCheckoutPage();
    }

}
