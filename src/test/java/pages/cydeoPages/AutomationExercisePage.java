package pages.cydeoPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutomationExercisePage {

    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // MAIN PAGE LOCATORS
    @FindBy(css = "i.fa.fa-lock")//FindBy is an annotation. It is a shortcut for FindElement (By.)
    public WebElement signupLoginButton;//Bu ikili yapı standarttır. İstediğimiz kadar oluşturabiliriz. Farklı farklı locator da kullanabiliriz.


    @FindBy(css = "i.fa.fa-home")
    public WebElement homeButton;


    @FindBy(css = "i.fa.fa-shopping-cart")
    public WebElement cartButton;


    @FindBy(css = "i.material-icons.card_travel")
    public WebElement productButton;


    //@FindBy(xpath = "(//a[@href=\"/test_cases\"])[1]")
    //@FindBy(css = "li:nth-child(5) a i")
    //@FindBy(css = ".navbar-nav li:nth-child(5) a")
    @FindBy(css = "div.item.active div.col-sm-6 a.test_cases_list")
    public WebElement testCasesButton;


    //@FindBy(xpath = "//a[.=' API Testing']")
    //@FindBy(css = "li:nth-child(6) a i")
    //@FindBy(css = ".navbar-nav li:nth-child(6) a")
    @FindBy(css = "div.item.active div.col-sm-6 a.apis_list")
    public WebElement apiTestingButton;


    @FindBy(css = "i.fa.fa-youtube-play")
    public WebElement videoTutorialsButton;


    @FindBy(css = "i.fa.fa-envelope")
    public WebElement contactUsButton;


    // Test Case 8: Product Details
    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    public WebElement viewProductBlueTop;

    @FindBy(xpath = "//h2[.='Blue Top']")
    public WebElement productNameBlueTop;

    @FindBy(xpath = "//p[.='Category: Women > Tops']")
    public WebElement categoryBlueTop;

    @FindBy(xpath = "//span[.='Rs. 500']")
    public WebElement priceBlueTop;

    @FindBy(xpath = "//b[.='Availability:']")
    public WebElement availabilityBlueTop;

    @FindBy(xpath = "//b[.='Condition:']")
    public WebElement conditionBlueTop;

    @FindBy(xpath = "//b[.='Brand:']")
    public WebElement brandBlueTop;

    public void verifySelectedProductDetailsVisibility() {
        List<WebElement> allDetails = new ArrayList<>();
        allDetails.addAll(Arrays.asList(brandBlueTop, conditionBlueTop, availabilityBlueTop, priceBlueTop, productNameBlueTop, categoryBlueTop));

        for (WebElement eachDetail : allDetails) {
            Assert.assertTrue(eachDetail.getText()+" is not visible",eachDetail.isDisplayed());
            System.out.println(eachDetail.getText() + " is displayed");
        }


    }

    @FindBy(css = "iframe#aswift_4")
    public WebElement adWindowIframe4;

    @FindBy(css = "iframe#aswift_1")
    public WebElement adWindowIframe1;

    @FindBy(css = "iframe#aswift_5")
    public WebElement adWindowIframe5;

    @FindBy(css = "iframe#aswift_2")
    public WebElement adWindowIframe2;

    @FindBy(css = "iframe#aswift_3")
    public WebElement adWindowIframe3;

    public void closeAdWindowByCheckingFrames( String pageTitle) {
        if (Driver.getDriver().getTitle().equals(pageTitle)){
            if (adWindowIframe1.isDisplayed()) {
                Driver.getDriver().navigate().refresh();
            } else if (adWindowIframe2.isDisplayed()) {
                Driver.getDriver().navigate().refresh();
            } else if (adWindowIframe3.isDisplayed()) {
                Driver.getDriver().navigate().refresh();
            } else if (adWindowIframe4.isDisplayed()) {
                Driver.getDriver().navigate().refresh();
            } else if (adWindowIframe5.isDisplayed()) {
                Driver.getDriver().navigate().refresh();
            }
        }
        Driver.getDriver().switchTo().parentFrame();
    }

    public void closeAdWindowByClickingXButton() {
        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().findElement(By.cssSelector("div#ad_position_box div#dismiss-button path")).click();
        Driver.getDriver().switchTo().parentFrame();
    }

    public void closeAdWindowByCheckingPageTitle(String pageTitle) {
        if (!Driver.getDriver().getTitle().equals(pageTitle)) {
            Driver.getDriver().navigate().refresh();
        }
    }


    // Test Case 9: Search Product
    @FindBy(css = "input#search_product")
    public WebElement searchProductBox;

    @FindBy(css = "div.productinfo.text-center p")
    public List<WebElement> allProducts;

    public void selectRandomItemFromAllProductsAndSearchForIt() {
        int randomItemIndexFromAllProductsList = BrowserUtilities.random().nextInt(allProducts.size());
        searchProductBox.sendKeys(allProducts.get(randomItemIndexFromAllProductsList).getText());
        searchButton.click();
    }

    public void forceToClickIfAdDisplayed(WebElement element) {
        BrowserUtilities.jsScrollClick(element);
        Driver.getDriver().navigate().refresh();
        BrowserUtilities.jsScrollClick(element);
    }

    @FindBy(css = "button#submit_search")
    public WebElement searchButton;

    @FindBy(xpath = "(//h2)[3]")
    public WebElement searchProductsHeader;

    @FindBy(css = "div.brands_products")
    public WebElement brandsInfoColumn;

    @FindAll(@FindBy(css = "div.productinfo.text-center"))
    public List<WebElement> allSearchResults;

    // Test Case 10

    @FindBy(css = "div.col-sm-3.col-sm-offset-1 div h2")
    public WebElement subscriptionText;

    @FindBy(css = "input#susbscribe_email")
    public WebElement subscriptionMailBox;

    @FindBy(css = "div.form-row div#success-subscribe div.alert-success.alert")
    public WebElement successfullySubscribedText;

    //Test Case 12

    @FindBy(css = "div.overlay-content a[data-product-id='1'] i.fa.fa-shopping-cart")
    public WebElement hoveredAddCartButton1;

    @FindBy(css = "div.overlay-content a[data-product-id='2'] i.fa.fa-shopping-cart")
    public WebElement hoveredAddCartButton2;

    @FindBy(css = "img[src='/get_product_picture/1']")
    public WebElement firstProductBlueTop;

    @FindBy(css = "img[src='/get_product_picture/2']")
    public WebElement secondProductMenTShirt;


    @FindBy(xpath = "//*[contains(text(),'Continue Shopping')]")
    public WebElement continueShoppingButton;

    @FindBy(css = "p.text-center a[href=\"/view_cart\"]")
    public WebElement viewCartButton;

    @FindBy(xpath = "//tbody/tr[1]/td[2]/h4/a")
    public WebElement firstAddedCartItem;

    @FindBy(xpath = "//tbody/tr[2]/td[2]/h4/a")
    public WebElement secondAddedCartItem;

    //Test Case 13

    //@FindBy(xpath = "//i[@class='fa fa-plus-square']")
    @FindBy(xpath = "//a[.='View Product']")
    public List<WebElement> allViewProductButtonsOnTheHomePage;

    public void selectAnyViewProductButtonOnTheHomePage() {
        int anyViewProductButtonIndexOnTheHomePage = BrowserUtilities.random().nextInt(allViewProductButtonsOnTheHomePage.size());
        BrowserUtilities.jsScrollClick(allViewProductButtonsOnTheHomePage.get(anyViewProductButtonIndexOnTheHomePage));
        if (Driver.getDriver().getTitle().equals("Automation Exercise")) {
            Driver.getDriver().navigate().refresh();
            BrowserUtilities.jsScrollClick(allViewProductButtonsOnTheHomePage.get(anyViewProductButtonIndexOnTheHomePage));
        }
    }


    @FindBy(css = "div.product-information h2")
    public WebElement productName;


    @FindBy(css = "div.product-information p")
    public WebElement productCategory;


    @FindBy(css = "div.product-information span span")
    public WebElement productPrice;


    @FindBy(css = "div.product-information span label")
    public WebElement productQuantity;


    @FindBy(xpath = "//*[.='Availability:']")
    public WebElement productAvailability;


    @FindBy(xpath = "//*[.='Condition:']")
    public WebElement productCondition;


    @FindBy(xpath = "//*[.='Brand:']")
    public WebElement productBrand;

    public void verifyAllProductDetailsVisibility() {
        if(!Driver.getDriver().getTitle().equals("Automation Exercise - Product Details")){
            Driver.getDriver().navigate().refresh();
        }

        List<WebElement> allDetails = new ArrayList<>();
        allDetails.addAll(Arrays.asList(productCondition, productCategory, productAvailability, productPrice, productBrand, productName, productQuantity));

        for (WebElement eachDetail : allDetails) {
            Assert.assertTrue(eachDetail.getText() + " is not visible",eachDetail.isDisplayed());
            System.out.println(eachDetail.getText() + " is displayed");
        }
    }

    @FindBy(css = "input#quantity")
    public WebElement quantityBox;

    public void increaseItemQuantityInCart(int quantity) {
        BrowserUtilities.getActions().click(quantityBox)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.DELETE)
                .sendKeys(quantity + "")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }

    @FindBy(xpath = "//tbody/tr[1]/td[4]/button")
    public WebElement productQuantityBoxInCart;

    //Test Case 14
    @FindBy(css = "button.btn.btn-default.cart i.fa.fa-shopping-cart")
    public WebElement addToCartButton;

    public void addItemWithGivenQuantity(int quantity) {
        for (int i = 0; i < quantity; i++) {
            selectAnyViewProductButtonOnTheHomePage();
            closeAdWindowByCheckingPageTitle("Automation Exercise - Product Details");
            BrowserUtilities.jsScrollClick(addToCartButton);
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().refresh();
        }
    }

    @FindBy(css = "ol.breadcrumb li.active")
    public WebElement shoppingCartText;

    public void verifyThatCartPageIsDisplayed() {
        Assert.assertEquals(shoppingCartText.getText(), "Shopping Cart", "Verify that cart page is not displayed");
    }

    @FindBy(css = "div.col-sm-6 a.btn.btn-default.check_out")
    public WebElement proceedToCheckout;

    @FindBy(css = "div.modal-body a[href=\"/login\"]")
    public WebElement registerLoginButton;

    @FindBy(css = "div.signup-form input[data-qa=\"signup-name\"]")
    public WebElement newUserSignupNameBox;

    @FindBy(css = "div.signup-form input[data-qa=\"signup-email\"]")
    public WebElement newUserSignupEmailBox;

    @FindBy(css = "input#id_gender1")
    public WebElement genderRadioButton;


    @FindBy(xpath = "(//h2)[1]")
    public WebElement enterAccountInfoText;


    public void createNewUserAccount() {
        BrowserUtilities.getActions().click(newUserSignupNameBox)
                .sendKeys(BrowserUtilities.getFaker().name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        Assert.assertTrue(enterAccountInfoText.isDisplayed());

        BrowserUtilities.getActions().click(genderRadioButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().internet().password()).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys("" + BrowserUtilities.getFaker().number().numberBetween(1, 31)).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys("May").pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys("" + BrowserUtilities.getFaker().number().numberBetween(1900, 2021)).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().name().firstName()).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().name().lastName()).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().company().name()).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().address().fullAddress()).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Canada")
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().address().state()).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().address().city()).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().address().zipCode()).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().phoneNumber().cellPhone()).pause(1000)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

    }

    @FindBy(xpath = "(//h2)[1]")
    public WebElement accountCreationText;

    public void verifyAccountCreation() {
        Assert.assertEquals(accountCreationText.getText(), "ACCOUNT CREATED!", "ACCOUNT CREATED! is not visible");
        safeClickByCheckingThePageTitle(continueButton,"Automation Exercise - Account Created");
    }

    public void safeClickByCheckingThePageTitle(WebElement webElement, String currentTitle){
        webElement.click();
        BrowserUtilities.sleep(2);
        if (Driver.getDriver().getTitle().equals(currentTitle)){
            Driver.getDriver().navigate().refresh();
            webElement.click();
        }
    }

    @FindBy(css = "i.fa.fa-user")
    public WebElement loggedInAsUsernameText;


    public void verifyDeliveryAddress() {
        for (int i = 1; i < 5; i++) {
            WebElement addressDetails = Driver.getDriver().findElement(By.cssSelector("div.col-xs-12.col-sm-6 ul#address_delivery li:nth-child(" + i + ")"));
            Assert.assertTrue(addressDetails.isDisplayed());
        }
        for (int i = 6; i < 9; i++) {
            WebElement addressDetails = Driver.getDriver().findElement(By.cssSelector("div.col-xs-12.col-sm-6 ul#address_delivery li:nth-child(" + i + ")"));
            Assert.assertTrue(addressDetails.isDisplayed());
        }
    }

    public void verifyBillingAddress() {
        for (int i = 1; i < 5; i++) {
            WebElement billingAddressDetails = Driver.getDriver().findElement(By.cssSelector("div.col-xs-12.col-sm-6 ul#address_invoice li:nth-child(" + i + ")"));
            Assert.assertTrue(billingAddressDetails.isDisplayed());
        }
        for (int i = 6; i < 9; i++) {
            WebElement billingAddressDetails = Driver.getDriver().findElement(By.cssSelector("div.col-xs-12.col-sm-6 ul#address_invoice li:nth-child(" + i + ")"));
            Assert.assertTrue(billingAddressDetails.isDisplayed());
        }
    }

    @FindBy(css = "textarea.form-control")
    public WebElement textArea;


    @FindBy(css = "a.btn.btn-default.check_out")
    public WebElement addCommentPlaceOrder;

    public void addCommentAboutOrder() {
        for (int i = 0; i < 5; i++) {
            textArea.sendKeys(BrowserUtilities.getFaker().chuckNorris().fact());

        }
        addCommentPlaceOrder.click();
    }

    @FindBy(css = "input[name=\"name_on_card\"]")
    public WebElement paymentNameOnCard;


    @FindBy(css = "button#submit")
    public WebElement payAndConfirmOrder;


    public void enterPaymentDetails() {
        BrowserUtilities.getActions().click(paymentNameOnCard)
                .sendKeys(BrowserUtilities.getFaker().name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().business().creditCardNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().number().numberBetween(100, 999) + "")
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().number().numberBetween(1, 31) + "")
                .sendKeys(Keys.TAB)
                .sendKeys(BrowserUtilities.getFaker().number().numberBetween(2019, 2029) + "")
                .perform();

    }

    @FindBy(css = "div.col-sm-9.col-sm-offset-1 p")
    public WebElement orderSuccessfullyPlacedMessage;


    @FindBy(css = "a[href=\"/delete_account\"]")
    public WebElement deleteAccountButton;


    @FindBy(css = "h2.title.text-center")
    public WebElement accountDeletedText;

    @FindBy(css = "a[data-qa=\"continue-button\"]")
    public WebElement continueButton;

    public void verifyAccountDeletedTextAndClickContButton() {
        Assert.assertTrue("ACCOUNT DELETED! is not visible",accountDeletedText.isDisplayed());
        continueButton.click();
    }

    //Test Case 16

    @FindBy(css = ".login-form form input:nth-child(2)")
    public WebElement loginEmailAddressBox;

    @FindBy(css = ".login-form form input:nth-child(3)")
    public WebElement loginPasswordBox;

    @FindBy(css = "[type~=submit]:nth-child(4)")
    public WebElement loginButton;

    /**
     * No parameters.
     * When we call this method, it will directly login using
     *
     * Username: cydeo06@gmail.com
     * Password: 12345
     */
    public void loginWithExistingAccountInfo(){
        this.loginEmailAddressBox.sendKeys("cydeo06@gmail.com");
        this.loginPasswordBox.sendKeys("12345");
        this.loginButton.click();
    }



}
