package stepDefinitions;


import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.AutomationPage;
import pages.cydeoPages.AutomationExercisePage;
import utilities.BrowserUtilities;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;


public class UI_TC12_AddProductsInCart {

    AutomationPage page = new AutomationPage();

    @And("Click Products button")
    public void clickProductsButton() {
        new AutomationExercisePage().safeClickByCheckingThePageTitle(page.products,"Automation Exercise");
    }

    @And("Hover over first product and click Add to cart")
    public void hoverOverFirstProductAndClickAddToCart() {
        ReusableMethods.jsScrollClick(page.addToChart);
    }

    @And("Click Continue Shopping button")
    public void clickContinueShoppingButton() {
        new AutomationExercisePage().continueShoppingButton.click();
    }

    @And("Hover over second product and click Add to cart")
    public void hoverOverSecondProductAndClickAddToCart() {
        ReusableMethods.jsScrollClick(page.addToChart2);
    }

    @And("Click View Cart button")
    public void clickViewCartButton() {
        BrowserUtils.clickWithJS(new AutomationExercisePage().viewCartButton);
    }

    @And("Verify both products are added to Cart")
    public void verifyBothProductsAreAddedToCart() {
        int productListSize = page.productsList.size();
        assertTrue(productListSize == 2);
    }

    @And("Verify their prices, quantity and total price")
    public void verifyTheirPricesQuantityAndTotalPrice() {
        //  System.out.println("first product price -> " + page.firstProductPrice.getText());
        //  System.out.println("second product total-> " + page.secondProductTotal.getText());

        Assert.assertTrue(page.firstProductPrice.isDisplayed()
                && page.secondProductPrice.isDisplayed()
                && page.firstProductQuantity.isDisplayed()
                && page.secondProductQuantity.isDisplayed()
                && page.firstProductTotal.isDisplayed()
                && page.secondProductTotal.isDisplayed());
    }
}
