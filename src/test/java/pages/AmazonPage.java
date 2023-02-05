package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class AmazonPage {

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input#twotabsearchtextbox")//FindBy is an annotation. It is a shortcut for FindElement (By.)
    public WebElement searchBox;//Bu ikili yapı standarttır. İstediğimiz kadar oluşturabiliriz. Farklı farklı locator da kullanabiliriz.

    @FindBy(xpath = "//a[@href='/gp/cart/view.html?ref_=nav_cart']")
    public WebElement cart;

    //@FindBy(xpath = "(//span[.='Add to Cart']//span)[1]")
    //@FindBy(css = "#add-to-cart-button")
    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    public WebElement addToCart;

    //@FindBy(css = "#a-autoid-0-announce")
    @FindBy(xpath = "//*[@id=\"a-autoid-0-announce\"]")
    public WebElement sort;

    //@FindBy(xpath = "//a[contains(text(),'Price: Low to High')]")
    @FindBy(css = "a#s-result-sort-select_1")
    public WebElement sortByPriceLowToHigh;

    //@FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[5]")
    @FindBy(css = ".widgetId\\=search-results_9 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > a:nth-child(1) > div:nth-child(1) > img:nth-child(1)")
    public WebElement gameChair;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")
    public WebElement iphone;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")
    public WebElement bag;

    @FindBy(css = "input#sc-buy-box-gift-checkbox")
    public WebElement giftCheckBox;

    //@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    @FindBy(css = "#sc-buy-box-ptc-button > span:nth-child(1) > input:nth-child(1)")
    public WebElement checkoutButton;

    @FindBy(css = "input#ap_email")
    public WebElement emailBox;


    public void searchItem(String item) {
        searchBox.sendKeys(item + Keys.ENTER);
        ReusableMethods.waitForPageToLoad(Driver.getDriver(),10000);
    }


    public void goCart() {
        cart.click();
    }

    public void goCheckoutPage() {
        //giftCheckBox.click();
        checkoutButton.click();
        emailBox.sendKeys("We are done!");
    }


    public void sortItemsByPrice() {
        sort.click();
        sortByPriceLowToHigh.click();
        ReusableMethods.waitFor(2);
    }


    public void addItem(WebElement element) {
        element.click();
        ReusableMethods.waitFor(3);
        addToCart.click();
    }
}