package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AutomationPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class UI_TC09_SearchProduct {
    AutomationPage page = new AutomationPage();

    @And("Enter product name in search input and click search button")
    public void enterProductNameInSearchInputAndClickSearchButton() {
        ReusableMethods.waitFor(3);
        Driver.getDriver().navigate().refresh();
        page.productsButton.click();
     //   ReusableMethods.getActions().click(page.searchProduct).sendKeys("Madame Top For Women").click(page.searchButton).perform();



        int productListSize = ReusableMethods.random().nextInt(page.allProduct.size());
        ReusableMethods.getActions()
                .click(page.searchProduct)
                .sendKeys(page.allProduct.get(productListSize).getText())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @Then("Verify SEARCHED PRODUCTS is visible")
    public void verifySEARCHEDPRODUCTSIsVisible() {
        assertTrue(page.searchedProducts.isDisplayed());
    }

    @Then("Verify all the products related to search are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible() throws IOException {
        for (WebElement each : page.searchedProductNames) {
            System.out.println(each.getText());
            assertTrue(each.isDisplayed());
        }
        ReusableMethods.jsScroll(page.wantedProduct);
        //ReusableMethods.getScreenshotWebElement("Wanted Product",page.wantedProduct);
    }
}
