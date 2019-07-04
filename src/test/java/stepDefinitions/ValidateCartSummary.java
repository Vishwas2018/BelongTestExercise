package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;

import java.util.concurrent.TimeUnit;


public class ValidateCartSummary {

    public WebDriver driver;
    HomePage homePage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    MegaMenuPage megaMenuPage;
    QuickViewItemPage quickViewItemPage;
    ShoppingCartSummaryPage shoppingCartSummaryPage;
//    CommonSteps commonSteps;

    // ValidateShoppingCartSummary

    @Given("^User is logged in with his/her credentials into the automationpractice site$")
    public void user_is_logged_in_with_his_her_credentials_into_the_automationpractice_site() {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        System.out.println("\nNavigating to Automation Practice Website");
        homePage.navigateToHomePage();
    }

    @Given("^on 'My Account' Page$")
    public void on_My_Account_Page() {
        // Write code here that turns the phrase above into concrete actions
        homePage = new HomePage(driver);
        homePage.verifySignInLink();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.clickSignInLink();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.enterRegisteredEmail();
        authenticationPage.enterPasswordRegisteredEmail();
        authenticationPage.clickSignInButton();
        myAccountPage = new MyAccountPage(driver);
        String myAccountPageTitle = myAccountPage.verifyMyAccountPageTitle();
        System.out.print("The title :" + myAccountPageTitle);
    }

    @When("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.centerColumnPresent();
        myAccountPage.verifyDressesMenuPresence();
        myAccountPage.clickDressesMenu();
        boolean isPresent = myAccountPage.verifyCenterColumnToBeVisible();
        if (isPresent) {
            System.out.print("\nThe center column element is visible");
        } else {
            System.out.print("\nCenter column is not visible");
        }
        boolean isClickable = myAccountPage.verifyCenterColumnToBeClickable();
        if (isClickable) {
            System.out.print("\nThe center column element is clickable");
        } else {
            System.out.print("\nCenter column is not clickable");
        }
    }

    @When("^Navigates to \"([^\"]*)\" Menu$")
    public void navigates_to_Menu(String arg1) {
        // Write code here that turns the phrase above into concrete actions
//        megaMenuPage = new MegaMenuPage(driver);
        megaMenuPage = new MegaMenuPage(driver);
        String getTitleMegaMenuPage = megaMenuPage.verifyMyAccountPageTitle();
        System.out.print("\nThe title of Mega Manu Page is: " + getTitleMegaMenuPage);
        boolean isVisible = megaMenuPage.verifySummerDressesMenuVisibility();
        if (isVisible) {
            System.out.print("\nThe summer dresses element is visible");
        } else {
            System.out.print("\nsummer dresses is not visible");
        }
        megaMenuPage.clickSummerDressesMenu();
    }

    @When("^Click on 'Add to Cart\" button to add an item to his/her shopping cart$")
    public void click_on_Add_to_Cart_button_to_add_an_item_to_his_her_shopping_cart() {
        // Write code here that turns the phrase above into concrete actions
        megaMenuPage = new MegaMenuPage(driver);
        String numberOfItems = megaMenuPage.verifySummerDressesItemsAvailability();
        System.out.print("\n" + numberOfItems);
//        megaMenuPage = new MegaMenuPage(driver);
        String summerMenuPageTitle = megaMenuPage.getSummerDressesMenuPageTitle();
        System.out.print("\nThe title of summer menu page is: " + summerMenuPageTitle);
        quickViewItemPage = new QuickViewItemPage(driver);
        String getTitleQuickViewItemPage = quickViewItemPage.verifyQuickViewItemPageTitle();
        System.out.print("\nThe title of quick view item Page is: " + getTitleQuickViewItemPage);
        boolean isDisplayed = quickViewItemPage.verifyShoppingItemVisible();
        if (isDisplayed) {
            System.out.print("\nThe shopping item element is visible");
        } else {
            System.out.print("\nShopping item is not visible");
        }
        boolean isAvailableForClick = quickViewItemPage.verifyShoppingItemClickable();
        if (isAvailableForClick) {
            System.out.print("\nThe shopping item is clickable");
        } else {
            System.out.print("\nCenter shopping item is not clickable");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        quickViewItemPage.clickShoppingItem();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        quickViewItemPage.getShoppingItemName();
        String shoppingItemName = quickViewItemPage.getSelectedShoppingItemName();
        System.out.print("\nThe shopping item is: " + shoppingItemName);
        String shoppingItemQuantity = quickViewItemPage.getSelectedItemQuantityValue();
        System.out.print("\nThe shopping item quantity is: " + shoppingItemQuantity);
        String shoppingItemColor = quickViewItemPage.getSelectedItemColorName();
        System.out.print("\nThe shopping item color is: " + shoppingItemColor);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        quickViewItemPage.clickAddToCartButton();
    }

    @Then("^A confirmation messages as \"([^\"]*)\"$")
    public void a_confirmation_messages_as(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String productAddedToCartMessage = quickViewItemPage.getProductAddedToCartMessage();
        System.out.print("\nConfirmation message: " + productAddedToCartMessage);
        Assert.assertEquals("Confirmation message", arg1, productAddedToCartMessage);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        quickViewItemPage.clickProceedToCheckoutButton();
    }

    @Given("^User is on \"([^\"]*)\" Page with title \"([^\"]*)\"$")
    public void user_is_on_Page_with_title(String arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String getShoppingCartSummaryPage = shoppingCartSummaryPage.verifyShoppigCarSummaryPageTitle();
        System.out.print("\nThe title of shopping cart summary Page is: " + getShoppingCartSummaryPage);
    }

    @When("^User validates the product name as \"([^\"]*)\"$")
    public void user_validates_the_product_name_as(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        String productName = shoppingCartSummaryPage.getProductName();
        System.out.print("\nThe product name in cart summary page is: " + productName);
    }

    @When("^cart quantity as \"([^\"]*)\"$")
    public void cart_quantity_as(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        Object productQuantity = shoppingCartSummaryPage.productQuantity();
        System.out.print("\nThe product quantity is: " + productQuantity);
    }

    @When("^color as \"([^\"]*)\" of the product$")
    public void color_as_of_the_product(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        String productColor = shoppingCartSummaryPage.getProductColor();
        System.out.print("\nThe product color is: " + productColor);
    }

    @Then("^User is able to find the correct product details as selected\\.$")
    public void user_is_able_to_find_the_correct_product_details_as_selected() {
        // Write code here that turns the phrase above into concrete actions

    }

}
