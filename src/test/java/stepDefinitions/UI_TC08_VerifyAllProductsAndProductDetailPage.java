package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import pages.AutomationPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class UI_TC08_VerifyAllProductsAndProductDetailPage {

    AutomationPage page = new AutomationPage();
    @And("Click on Products button")
    public void clickOnProductsButton() {
        page.productsButton.click();
    }

    @And("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyUserIsNavigatedToALLPRODUCTSPageSuccessfully() {
        assertTrue(page.allProductPage.isDisplayed());
    }

    @And("The products list is visible")
    public void theProductsListIsVisible() {
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);
        // int number = 1;
        // for (WebElement each : page.allProductsList) {
        //     System.out.println(number + " => " + each.getText());
        //     number++;
        // }

        int number = 1;
        for (WebElement each:page.allProduct) {
            System.out.println(number + " => " + each.getText());
            assertTrue(each.isDisplayed());
        }
    }

    @And("Click on View Product of first product")
    public void clickOnViewProductOfFirstProduct() {
        ReusableMethods.jsScrollClick(page.viewProductList.get(0));
    }

    @And("User is landed to product detail page")
    public void userIsLandedToProductDetailPage() {
        assertTrue(page.productInformation.isDisplayed());
    }

    @And("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verifyThatDetailDetailIsVisibleProductNameCategoryPriceAvailabilityConditionBrand() throws IOException {
        ReusableMethods.getScreenshotWebElement("Product Information",page.productInformationScreenshot);

        assertTrue(page.productName.isDisplayed());
        assertTrue(page.productCategory.isDisplayed());
        assertTrue(page.productPrice.isDisplayed());
        assertTrue(page.productAvailability.isDisplayed());
        assertTrue(page.productCondition.isDisplayed());
        assertTrue(page.productBrand.isDisplayed());
    }

}
