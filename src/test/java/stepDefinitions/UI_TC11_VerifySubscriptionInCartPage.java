package stepDefinitions;

import io.cucumber.java.en.And;
import pages.AutomationPage;

public class UI_TC11_VerifySubscriptionInCartPage {
    AutomationPage page = new AutomationPage();
    @And("Click Cart button")
    public void clickCartButton() {
        page.cartButton.click();
    }
}
