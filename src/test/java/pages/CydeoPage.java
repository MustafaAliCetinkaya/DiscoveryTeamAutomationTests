package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CydeoPage {
    public WebDriver driver = Driver.getDriver();

    public CydeoPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Programs")
    public  WebElement programs;

    @FindBy(xpath = "//a[.='Java SDET']")
    public  WebElement javaSDET;

    @FindBy(xpath = "//a[.='Cybersecurity Analyst']")
    public  WebElement cyberSecurity;

    @FindBy(xpath = "//a[.='Java Developer']")
    public  WebElement javaDeveloper;

    @FindBy(xpath = "//a[.='Salesforce Administrator/Developer']")
    public  WebElement salesForce;

    @FindBy(linkText = "About")
    public  WebElement about;

    @FindBy(linkText = "Careers")
    public  WebElement careers;

    @FindBy(linkText = "Partnerships")
    public  WebElement partnerShips;

    @FindBy(xpath = "//a[.='Shop']")
    public  WebElement shop;

    @FindBy(xpath = "//button[@name='add']")
    public  WebElement addToCart;

    @FindBy(xpath = "(//button[@class='quantity__button no-js-hidden'])[2]")
    public  WebElement increaseQuantity;

    @FindBy(xpath = "//a[@id='cart-icon-bubble']")
    public  WebElement goToCart;

    @FindBy(xpath = "(//a[@class='full-unstyled-link'])[2]")
    public  WebElement longSleeve;

    @FindBy(xpath = "(//a[@class='full-unstyled-link'])[6]")
    public  WebElement hoodies;

    @FindBy(xpath = "(//a[@class='full-unstyled-link'])[8]")
    public  WebElement youth;

    @FindBy(css = "button#checkout")
    public  WebElement checkout;

    @FindAll({@FindBy(xpath = "//div")})
    public  List<WebElement> allElements;

    public  void onlyIdAttributes() {
        System.out.println("AllIdentities.size() = " + allElements.size());
        int count = 1;
        for (WebElement each : allElements) {
            String eachId = each.getAttribute("id");
            System.out.println(!(eachId.isEmpty() || eachId.isBlank()) ?
                    count + ". id is: " + eachId : count + ". id is: NOT ASSIGNED. EMPTY!");
            count++;
        }
    }


    public  void navigateThePage() {
        programs.click();
        System.out.println("Page title is = " + driver.getTitle());

        javaSDET.click();
        System.out.println("Page title is = " + driver.getTitle());

        cyberSecurity.click();
        System.out.println("Page title is = " + driver.getTitle());

        javaDeveloper.click();
        System.out.println("Page title is = " + driver.getTitle());

        salesForce.click();
        System.out.println("Page title is = " + driver.getTitle());

        about.click();
        System.out.println("Page title is = " + driver.getTitle());

        careers.click();
        System.out.println("Page title is = " + driver.getTitle());

        partnerShips.click();
        System.out.println("Page title is = " + driver.getTitle());

        shop.click();
        System.out.println("Page title is = " + driver.getTitle());

    }

    public  void testAllLinksOnTheHomepage() {
        List<String> allPages = new ArrayList<>();
        for (int i = 1; i < 50; i++) {//Firstly, inspect your site, set the breakpoint of "i" based on the number of "href tags" on the page
            //This loop finds all href tags and store their values in allPages list
            String eachAddress = driver.findElement(By.xpath("(//a[@href])[" + i + "]")).getAttribute("href");
            allPages.add(eachAddress);
        }

        System.out.println("Number of the links on the page is: "+allPages.size());

        for (String each : allPages) {//This loop opens each link on a new tab
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open('" + each + "', '_blank');");
        }


        Set<String> AllHandles = driver.getWindowHandles();
        int count = 1;
        for (String eachHandle : AllHandles) {//Navigate each tab and get title/URL
            driver.switchTo().window(eachHandle);
            System.out.println(count + ". page title is : " + driver.getTitle() + "\n" +
                    count + ". link is: " + driver.getCurrentUrl());
            driver.switchTo().parentFrame();
            count++;
        }
    }

    public  void cydeoShopDropDownTest() {

        WebElement color = driver.findElement(By.xpath("//select[@name='options[Color]']"));
        Select colorDropDown = new Select(color);

        //Verify default selected option.
        String expectedOptionText = "Solid Black Triblend";
        String actualOptionText = colorDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText, expectedOptionText, "Default selected color option test is failed!");

        WebElement size = driver.findElement(By.xpath("//select[@name='options[Size]']"));
        Select sizeDropDown = new Select(size);

        //Verify default selected option.
        String expectedSizeOptionText = "XS";
        String actualSizeOptionText = sizeDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSizeOptionText, expectedSizeOptionText, "Default selected size option test is failed!");

    }

    public  void cydeoShopping() throws InterruptedException {

        WebElement color = driver.findElement(By.xpath("//select[@name='options[Color]']"));
        Select colorDropDown = new Select(color);

        WebElement size = driver.findElement(By.xpath("//select[@name='options[Size]']"));
        Select sizeDropDown = new Select(size);

        colorDropDown.selectByIndex(1);
        sizeDropDown.selectByIndex(1);
        addToCart.click();

        Thread.sleep(5000);

        colorDropDown.selectByValue("True Royal Triblend");
        sizeDropDown.selectByValue("2XL");
        addToCart.click();

        Thread.sleep(5000);

        colorDropDown.selectByIndex(2);
        sizeDropDown.selectByIndex(4);
        addToCart.click();

        Thread.sleep(5000);

        colorDropDown.selectByIndex(4);
        sizeDropDown.selectByIndex(5);
        addToCart.click();

        Thread.sleep(5000);

        longSleeve.click();
        System.out.println("Page title is = " + driver.getTitle());
        driver.findElement(By.xpath("(//a[contains(text(),'Unisex')])[2]")).click();
        addToCart.click();
        for (int i = 0; i < 2; i++) {
            driver.navigate().back();
        }

        Thread.sleep(5000);

        hoodies.click();
        System.out.println("Page title is = " + driver.getTitle());
        driver.findElement(By.xpath("(//a[contains(text(),'Zip')])[2]")).click();
        addToCart.click();
        for (int i = 0; i < 2; i++) {
            driver.navigate().back();
        }

        Thread.sleep(5000);

        youth.click();
        System.out.println("Page title is = " + driver.getTitle());
        driver.findElement(By.xpath("(//a[contains(text(),'long')])[2]")).click();
        addToCart.click();

        goToCart.click();
        System.out.println("Page title is = " + driver.getTitle());
        ReusableMethods.hover(driver, increaseQuantity);
        ReusableMethods.clickWithTimeOut(increaseQuantity, 3);

        Thread.sleep(5000);

        checkout.click();
        System.out.println("Page title is = " + driver.getTitle());

        driver.findElement(By.cssSelector("input#email")).sendKeys("Enough for practice!");
    }
}