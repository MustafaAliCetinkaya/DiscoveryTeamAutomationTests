package pages.cydeoPages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VyTrackLoginPage {
    public  VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
