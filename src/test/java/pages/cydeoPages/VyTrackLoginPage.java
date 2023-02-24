package pages.cydeoPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VyTrackLoginPage {
    public VyTrackLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameBox;

    @FindBy(css = "input[id='prependedInput2']")
    public WebElement passwordBox;

    @FindBy(css = "button[id='_submit']")
    public WebElement buttonSubmit;

    public void login(String username,String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        buttonSubmit.click();
    }
    
    
}
