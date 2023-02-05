package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Random;

public class FacebookPage {

    public static void facebookLogin() {
        for (int i = 0; i < 100; i++) {
            ReusableMethods.waitFor(5);
            Driver.getDriver().findElement(By.cssSelector("input#email")).clear();
            Driver.getDriver().findElement(By.cssSelector("input#email")).sendKeys(mockEmailAndPasswordFactory()+"gmail.com");
            Driver.getDriver().findElement(By.cssSelector("input#pass")).sendKeys(mockEmailAndPasswordFactory());
            Driver.getDriver().findElement(By.xpath("//button[.=\"Giriş Yap\"]")).click();
        }
    }

    public void facebookLogin(String username, String password) {
        //3. Enter valid username
        WebElement inputUsername = Driver.getDriver().findElement(By.cssSelector("input#email"));
        System.out.println(inputUsername.getAttribute("placeholder"));
        inputUsername.sendKeys(username);

        //4. Enter valid password
        WebElement inputPassword = Driver.getDriver().findElement(By.cssSelector("input#pass"));
        System.out.println(inputPassword.getAttribute("placeholder"));
        inputPassword.sendKeys(password);

        //5. Click to Log In button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[.=\"Giriş Yap\"]"));
        loginButton.click();

        WebElement errorMessage = Driver.getDriver().findElement(By.cssSelector("div._9ay7"));
        System.out.println(errorMessage.getText());
    }

    public static String mockEmailAndPasswordFactory() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";

        String temp="";
        Random random = new Random();

        while (temp.length() < 10) { // length of the random string.
            int index = random.nextInt(39);
            temp+=allowedChars.charAt(index);
        }

        return temp;

    }
}