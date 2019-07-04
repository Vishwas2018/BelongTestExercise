package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;
import utilities.GetTestEmailId;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;


public class Registration {

    public static WebDriver driver;
    HomePage homePage;
    AuthenticationPage authenticationPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;
    GetTestEmailId getTestEmailId = new GetTestEmailId();
    MegaMenuPage megaMenuPage;
    QuickViewItemPage quickViewItemPage;
    ShoppingCartSummaryPage shoppingCartSummaryPage;


    // UserRegistration Feature

    // Scenario 1
    @Given("^User is on the automation practice website home page with title \"([^\"]*)\"$")
    public void user_is_on_the_automation_practice_website_home_page_with_title(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        System.out.println("\nNavigating to Automation Practice Website");
        homePage.navigateToHomePage();
        homePage.verifySignInLink();
        String getTitle = homePage.verifyHomePageTitle();
        System.out.print("The title of Home Page is: " + getTitle);
        Assert.assertEquals("The title of the page is correct: ", arg1, getTitle);
    }

    @When("^User clicks on \"([^\"]*)\" link$")
    public void user_clicks_on_link(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.clickSignInLink();
    }

    @Then("^User is the navigated to the authentication page with title \"([^\"]*)\"$")
    public void user_is_the_navigated_to_the_authentication_page_with_title(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        authenticationPage = new AuthenticationPage(driver);
        String getTitleAuthentication = authenticationPage.verifyAuthenticationPageTitle();
        System.out.print("\nThe title of Authentication Page is: " + getTitleAuthentication);
        Assert.assertEquals("The title of authentication is correct", arg1, getTitleAuthentication);
    }

    // Scenario 2
    @Given("^User is on the authentication Page with title \"([^\"]*)\"$")
    public void user_is_on_the_authentication_Page_with_title(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        authenticationPage = new AuthenticationPage(driver);
        String getTitleAuthentication = authenticationPage.verifyAuthenticationPageTitle();
        System.out.print("\nThe title of Authentication Page is: " + getTitleAuthentication);
        Assert.assertEquals("The title of authentication is correct", arg1, getTitleAuthentication);
    }

    @When("^User enters a valid email address in the email address field$")
    public void user_enters_a_valid_email_address_in_the_email_address_field() throws FileNotFoundException {
        // Write code here that turns the phrase above into concrete actions
        authenticationPage.clearEmailTextField();
        authenticationPage.verifyEmailTextFieldPresence();
        authenticationPage.enterEmailAddress();
        String testEmail = getTestEmailId.sendTestEmail();
        System.out.print("The email address is: " + testEmail);
    }

    @When("^Clicks on \"([^\"]*)\" button$")
    public void clicks_on_button(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        authenticationPage.createAnAccountButtonPresence();
        authenticationPage.clickCreateAnAccountButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String verifyEmailId = authenticationPage.verifyEmailAddress();
//        System.out.print("\n" + verifyEmailId + "\n");
        if (verifyEmailId.equals("\nThe email is Valid")) {
            System.out.print("\nThe email address verification is successful. Email is valid");
        } else {
            System.out.print("\n" + verifyEmailId + "\n");
        }
    }

    @Then("^User is navigated to the \"([^\"]*)\" Form$")
    public void user_is_navigated_to_the_Form(String arg1) {
        try {
            // Write code here that turns the phrase above into concrete actions
            createAccountPage = new CreateAccountPage(driver);
            createAccountPage.accountCreationFormPresence();
            String getHeadingCreateAccountPage = createAccountPage.getPageHeading();
            System.out.print("\nThe page heading for create an account page is: " + getHeadingCreateAccountPage);
            Assert.assertEquals("The heading of create an account is correct", arg1, getHeadingCreateAccountPage);
        } catch (Exception exception) {
            System.out.print("\nPlease correct email address to proceed.");
            System.exit(0);
        }
    }

    // Scenario 3
    @Given("^User is on \"([^\"]*)\" Form with title \"([^\"]*)\"$")
    public void user_is_on_Form_with_title(String arg1, String arg2) {
        try {
            // Write code here that turns the phrase above into concrete actions
            createAccountPage = new CreateAccountPage(driver);
            createAccountPage.accountCreationFormPresence();
            String getTitleCreateAccountPage = createAccountPage.verifyCreateAccountPageTitle();
            System.out.print("\nThe title of Create An Account Page is: " + getTitleCreateAccountPage);
            Assert.assertEquals("The title of create an account is correct", arg2, getTitleCreateAccountPage);
            String getHeadingCreateAccountPage = createAccountPage.getPageHeading();
            System.out.print("\nThe page heading for create an account page is: " + getHeadingCreateAccountPage);
            Assert.assertEquals("The heading of create an account is correct", arg1, getHeadingCreateAccountPage);
        } catch (Exception exception) {
            System.out.print("\nThe email is cannot be used to proceed further");
        }
    }

    @When("^User fills up the form with all details$")
    public void user_fills_up_the_form_with_all_details() {
        try {
            // Write code here that turns the phrase above into concrete actions
            createAccountPage.selectRadioButtonTitleMr();
            createAccountPage.enterCustomerFirstname();
            createAccountPage.enterCustomerLastname();
            createAccountPage.enterPassword();
            createAccountPage.enterDay();
            createAccountPage.enterMonth();
            createAccountPage.enterYear();
            createAccountPage.enterAddressFirstname();
            createAccountPage.enterAddressLastname();
            createAccountPage.enterCompany();
            createAccountPage.enterAddressLineOne();
            createAccountPage.enterAddressLineTwo();
            createAccountPage.enterCity();
            createAccountPage.enterState();
            createAccountPage.enterPostcode();
            createAccountPage.enterCountry();
            createAccountPage.enterAdditionalInformation();
            createAccountPage.enterHomePhone();
            createAccountPage.enterMobilePhone();
            createAccountPage.enterAliasForAddress();
        } catch (Exception exception) {
        }
    }

    @When("^Clicks on \"([^\"]*)\" button on create an account form page$")
    public void clicks_on_button_on_create_an_account_form_page(String arg1) {
        try {
            // Write code here that turns the phrase above into concrete actions
            createAccountPage.registerButtonPresence();
            createAccountPage.clickRegisterButton();
        } catch (Exception exception) {

        }
    }


    @Then("^The registration is successful and user is able to see my account page with title \"([^\"]*)\" Page\\.$")
    public void the_registration_is_successful_and_user_is_able_to_see_my_account_page_with_title_Page(String
                                                                                                               arg1) {
        try {
            // Write code here that turns the phrase above into concrete actions
            myAccountPage = new MyAccountPage(driver);
            myAccountPage.verifyMyAccountPageTitle();
            String getTitleMyAccountPage = myAccountPage.verifyMyAccountPageTitle();
            System.out.print("\nThe title of My Account Page is: " + getTitleMyAccountPage);
            Assert.assertEquals("The title for my account page is correct", arg1, getTitleMyAccountPage);
        } catch (Exception exception) {
        }
    }
}
