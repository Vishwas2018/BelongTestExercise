package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;
import utilities.CommonSteps;

import java.util.concurrent.TimeUnit;

public class ShoppingFlow {

    public static WebDriver driver;

    HomePage homePage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    MegaMenuPage megaMenuPage;
    QuickViewItemPage quickViewItemPage;
    CommonSteps commonSteps;

    @Given("^User is logged in with his/her credentials$")
    public void user_is_logged_in_with_his_her_credentials() {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        System.out.println("\nNavigating to Automation Practice Website");
        homePage.navigateToHomePage();

    }

    @Given("^on 'My Account' Page with title \"([^\"]*)\"$")
    public void on_My_Account_Page_with_title(String arg1) {
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

    @When("^User clicks on \"([^\"]*)\" menu tab$")
    public void user_clicks_on_menu_tab(String arg1) {
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

    @When("^Selects \"SummerDresses' menu under Dresses section on left$")
    public void selects_SummerDresses_menu_under_Dresses_section_on_left() {
        // Write code here that turns the phrase above into concrete actions
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

    @Then("^User is able to see items for selection under \"([^\"]*)\" menu$")
    public void user_is_able_to_see_items_for_selection_under_menu(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        megaMenuPage = new MegaMenuPage(driver);
        String numberOfItems = megaMenuPage.verifySummerDressesItemsAvailability();
        System.out.print("\n" + numberOfItems);
    }

    @Given("^User is now on the \"([^\"]*)\" selection menu with title \"([^\"]*)\"$")
    public void user_is_now_on_the_selection_menu_with_title(String arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        megaMenuPage = new MegaMenuPage(driver);
        String summerMenuPageTitle = megaMenuPage.getSummerDressesMenuPageTitle();
        System.out.print("\nThe title of summer menu page is: " + summerMenuPageTitle);
        Assert.assertEquals("The title for summer menu page is correct", arg2, summerMenuPageTitle);
    }

    @When("^User clicks on \"([^\"]*)\" option on product with name \"([^\"]*)\"$")
    public void user_clicks_on_option_on_product_with_name(String arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
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
        quickViewItemPage.clickShoppingItem();
    }

    @Then("^User is able to see selected product details in an overlay$")
    public void user_is_able_to_see_selected_product_details_in_an_overlay() {
        // Write code here that turns the phrase above into concrete actions
        quickViewItemPage = new QuickViewItemPage(driver);
        quickViewItemPage.getShoppingItemName();
        String shoppingItemName = quickViewItemPage.getSelectedShoppingItemName();
        System.out.print("\nThe shopping item is: " + shoppingItemName);
        String shoppingItemQuantity = quickViewItemPage.getSelectedItemQuantityValue();
        System.out.print("\nThe shopping item quantity is: " + shoppingItemQuantity);
        String shoppingItemColor = quickViewItemPage.getSelectedItemColorName();
        System.out.print("\nThe shopping item color is: " + shoppingItemColor);
    }

    @Given("^User is on the selected product \"([^\"]*)\"  overlay$")
    public void user_is_on_the_selected_product_overlay(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        quickViewItemPage = new QuickViewItemPage(driver);
        quickViewItemPage.verifyProceedToCheckoutButtonClickable();
    }

    @When("^User clicks on \"([^\"]*)\" button to add the product in the cart$")
    public void user_clicks_on_button_to_add_the_product_in_the_cart(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        quickViewItemPage = new QuickViewItemPage(driver);
        quickViewItemPage.clickAddToCartButton();
    }

    @Then("^User is able to see a confirmation messages as \"([^\"]*)\"$")
    public void user_is_able_to_see_a_confirmation_messages_as(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        quickViewItemPage = new QuickViewItemPage(driver);
        String productAddedToCartMessage = quickViewItemPage.getProductAddedToCartMessage();
        System.out.print("\nConfirmation message: " + productAddedToCartMessage);
        Assert.assertEquals("Confirmation message", arg1, productAddedToCartMessage);
    }
}
