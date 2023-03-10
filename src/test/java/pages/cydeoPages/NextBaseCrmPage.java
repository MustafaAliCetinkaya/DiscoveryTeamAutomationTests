package pages.cydeoPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NextBaseCrmPage {

    /*
    This method will log in with helpdesk1@cybertekschool.com
     user when it is called
     */

    public static void crm_login(){//Interface is By Default public
        //3. Enter valid username
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("username"));

        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser

        //4. Enter valid password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        //5. Click to Log In button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

     public void crm_login(WebDriver driver){//Interface is By Default public
        //3. Enter valid username
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser

        //4. Enter valid password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to Log In button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

     public void crm_login(WebDriver driver, String username, String password){
        //3. Enter valid username
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser

        //4. Enter valid password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        //5. Click to Log In button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

}