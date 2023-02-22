package utilities;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class BrowserUtilities {

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle) {

        Set<String> allWindowsHandles = driver.getWindowHandles();
        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }


    public static void verifyPageTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "This is a failure message. Title is not matching!");
    }

    public static void verifyPageUrl(WebDriver driver, String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "This is a failure message. URL is not matching!");
    }

    public static String mockEmailAndPasswordFactory() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";

        String temp = "";
        Random random = new Random();

        while (temp.length() < 10) { // length of the random string.
            int index = random.nextInt(39);
            temp += allowedChars.charAt(index);
        }

        return temp;

    }

    public static Faker getFaker() {

        Faker faker;
        return faker = new Faker();
    }

    public static Actions getActions() {

        Actions actions;
        return actions = new Actions(Driver.getDriver());
    }

    //========Hover Over=====//
    public static void hoverOver(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).pause(1000).perform();
    }

    //====== JS Scroll Click ====//
    public static void jsScrollClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        try {
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            js.executeScript("arguments[0].click()", element);
            sleep(1);
        }
    }

    //====== JS Scroll ====//
    public static void jsScroll(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static Random random() { //

        Random random;
        return random = new Random();
    }


    //====== js ======//
    public static void jsClick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", webElement);
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            executor.executeScript("arguments[0].click();", webElement);
        }
    }

    public WebElement fluentWait(String xpathLocator) {
        // Waiting 30 seconds for an element to be present on the page, checking
// for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(driver -> {
            return driver.findElement(By.xpath(xpathLocator));
        });

        return foo;
    }

    public static void closeAdPage_afterHomePage(WebElement webElement){
        webElement.click();
        BrowserUtilities.sleep(2);
        if (Driver.getDriver().getTitle().equals("Automation Exercise")){
            Driver.getDriver().navigate().refresh();
            webElement.click();
        }
    }

}