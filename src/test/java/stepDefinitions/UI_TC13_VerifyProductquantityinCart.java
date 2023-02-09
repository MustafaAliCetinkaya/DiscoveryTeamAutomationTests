package stepDefinitions;

import io.cucumber.java.en.And;
import pages.AutomationPage;
import utilities.Driver;

import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.ReusableMethods.jsScrollClick;
import static utilities.ReusableMethods.random;

public class UI_TC13_VerifyProductquantityinCart {


    AutomationPage page = new AutomationPage();

    String quantity;

    @And("Click View Product for any product on home page")
    public void clickViewProductForAnyProductOnHomePage() {
        int index = random().nextInt(page.viewProductButtonList.size());
        jsScrollClick(page.viewProductButtonList.get(index));
        Driver.getDriver().navigate().refresh();
        jsScrollClick(page.viewProductButtonList.get(index));
    }

    @And("Verify product detail is opened")
    public void verifyProductDetailIsOpened() {
        assertTrue(page.productDetail.isDisplayed());
    }

    @And("Increase quantity to {int}")
    public void ıncreaseQuantityTo(int amount) {
        quantity = String.valueOf(amount);

        page.quantity.click();
        page.quantity.clear();
        page.quantity.sendKeys(quantity);
    }

    @And("Click Add to cart button")
    public void clickAddToCartButton() {
        jsScrollClick(page.addToCartButton);
    }

    @And("Verify that product is displayed in cart page with exact quantity")
    public void verifyThatProductIsDisplayedInCartPageWithExactQuantity() {
        //System.out.println("quantity = " + quantity);
        //System.out.println("page.quantityInCart.getText() = " + page.quantityInCart.getText());

        assertEquals(quantity, page.quantityInCart.getText());
    }
}
