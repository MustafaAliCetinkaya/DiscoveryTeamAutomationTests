package pages.cydeoPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VyTrackDashboardPage {
    public VyTrackDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "li[id='user-menu'] a[data-toggle='dropdown']")
    public WebElement usernameDropdown;
    
    
}
