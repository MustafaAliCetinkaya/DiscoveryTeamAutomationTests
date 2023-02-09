package stepDefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.AutomationPage;

public class UI_TC07_VerifyTestCasesPage {

    AutomationPage page = new AutomationPage();
    @And("Click on Test Cases button")
    public void clickOnTestCasesButton() {
        page.testCasesButton.click();
    }

    @And("Verify user is navigated to test cases page successfully")
    public void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
        Assert.assertTrue(page.testCasesTitle.isDisplayed());
    }
}
