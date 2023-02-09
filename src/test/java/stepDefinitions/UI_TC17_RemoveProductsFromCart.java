package stepDefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.AutomationPage;
import utilities.ReusableMethods;

public class UI_TC17_RemoveProductsFromCart {

    AutomationPage page = new AutomationPage();

    @And("Click X button corresponding to particular product")
    public void clickXButtonCorrespondingToParticularProduct() {
        page.deletesTheProduct.click();
    }

    @And("Verify that product is removed from the cart")
    public void verifyThatProductIsRemovedFromTheCart() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(page.cartEmpty.isDisplayed());
    }
}
