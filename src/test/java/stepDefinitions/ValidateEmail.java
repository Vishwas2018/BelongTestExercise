package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AuthenticationPage;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
import utilities.GetTestEmailId;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;


public class ValidateEmail {

    public static WebDriver driver;
    HomePage homePage;
    AuthenticationPage authenticationPage;
    CreateAccountPage createAccountPage;
    GetTestEmailId getTestEmailId = new GetTestEmailId();

    @Given("^User is on \"([^\"]*)\" form with valid email address$")
    public void user_is_on_form_with_valid_email_address(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        System.out.println("\nNavigating to Automation Practice Website");
        homePage.navigateToHomePage();
        homePage.verifySignInLink();
        String getTitle = homePage.verifyHomePageTitle();
        System.out.print("The title of Home Page is: " + getTitle);
        Assert.assertEquals("The title of the page is correct: ", arg1, getTitle);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.clickSignInLink();
        authenticationPage = new AuthenticationPage(driver);
        String getTitleAuthentication = authenticationPage.verifyAuthenticationPageTitle();
        System.out.print("\nThe title of Authentication Page is: " + getTitleAuthentication);
        Assert.assertEquals("The title of authentication is correct", arg1, getTitleAuthentication);

    }

    @When("^User enters a valid email address in the email field$")
    public void user_enters_a_valid_email_address_in_the_email_field() throws FileNotFoundException {
        // Write code here that turns the phrase above into concrete actions
        authenticationPage.clearEmailTextField();
        authenticationPage.verifyEmailTextFieldPresence();
        authenticationPage.enterEmailAddress();
        String testEmail = getTestEmailId.sendTestEmail();
        System.out.print("The email address is: " + testEmail);
    }

    @When("^Clicks on \"([^\"]*)\" button for registration with valid email address$")
    public void clicks_on_button_for_registration_with_valid_email_address(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        authenticationPage.createAnAccountButtonPresence();
        authenticationPage.clickCreateAnAccountButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String verifyEmailId = authenticationPage.verifyEmailAddress();
        if (verifyEmailId.equals("\nThe email is Valid")) {
            System.out.print("\nThe email address verification is successful. Email is valid");
        } else {
            System.out.print("\n" + verifyEmailId + "\n");
        }
    }

    @Then("^User is navigated to the \"([^\"]*)\" form with title \"([^\"]*)\"$")
    public void user_is_navigated_to_the_form_with_title(String arg1, String arg2) {
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

    @Given("^User is on \"([^\"]*)\" form with invalid email address$")
    public void user_is_on_form_with_invalid_email_address(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        System.out.println("\nNavigating to Automation Practice Website");
        homePage.navigateToHomePage();
        homePage.verifySignInLink();
        String getTitle = homePage.verifyHomePageTitle();
        System.out.print("The title of Home Page is: " + getTitle);
        Assert.assertEquals("The title of the page is correct: ", arg1, getTitle);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.clickSignInLink();
        authenticationPage = new AuthenticationPage(driver);
        String getTitleAuthentication = authenticationPage.verifyAuthenticationPageTitle();
        System.out.print("\nThe title of Authentication Page is: " + getTitleAuthentication);
        Assert.assertEquals("The title of authentication is correct", arg1, getTitleAuthentication);

    }

    @When("^User enters an invalid email address in the email field$")
    public void user_enters_an_invalid_email_address_in_the_email_field() throws FileNotFoundException {
        // Write code here that turns the phrase above into concrete actions
        authenticationPage.clearEmailTextField();
        authenticationPage.verifyEmailTextFieldPresence();
        authenticationPage.enterEmailAddress();
        String testEmail = getTestEmailId.sendTestEmail();
        System.out.print("The email address is: " + testEmail);
    }

    @When("^Clicks on \"([^\"]*)\" button for registration with invalid email address$")
    public void clicks_on_button_for_registration_with_invalid_email_address(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        authenticationPage.createAnAccountButtonPresence();
        authenticationPage.clickCreateAnAccountButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String verifyEmailId = authenticationPage.verifyEmailAddress();
        if (verifyEmailId.equals("\nThe email is Valid")) {
            System.out.print("\nThe email address verification is successful. Email is valid");
        } else {
            System.out.print("\n" + verifyEmailId + "\n");
        }
    }

    @Given("^User is on \"([^\"]*)\" form with already registered email address$")
    public void user_is_on_form_with_already_registered_email_address(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        System.out.println("\nNavigating to Automation Practice Website");
        homePage.navigateToHomePage();
        homePage.verifySignInLink();
        String getTitle = homePage.verifyHomePageTitle();
        System.out.print("The title of Home Page is: " + getTitle);
        Assert.assertEquals("The title of the page is correct: ", arg1, getTitle);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.clickSignInLink();
        authenticationPage = new AuthenticationPage(driver);
        String getTitleAuthentication = authenticationPage.verifyAuthenticationPageTitle();
        System.out.print("\nThe title of Authentication Page is: " + getTitleAuthentication);
        Assert.assertEquals("The title of authentication is correct", arg1, getTitleAuthentication);

    }

    @When("^User enters an already registered email address in the email field$")
    public void user_enters_an_already_registered_email_address_in_the_email_field() throws FileNotFoundException {
        // Write code here that turns the phrase above into concrete actions
        authenticationPage.clearEmailTextField();
        authenticationPage.verifyEmailTextFieldPresence();
        authenticationPage.enterEmailAddress();
        String testEmail = getTestEmailId.sendTestEmail();
        System.out.print("The email address is: " + testEmail);
    }

    @When("^Clicks on \"([^\"]*)\" button for registration with already registered email address$")
    public void clicks_on_button_for_registration_with_already_registered_email_address(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        authenticationPage.createAnAccountButtonPresence();
        authenticationPage.clickCreateAnAccountButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String verifyEmailId = authenticationPage.verifyEmailAddress();
        if (verifyEmailId.equals("\nThe email is Valid")) {
            System.out.print("\nThe email address verification is successful. Email is valid");
        } else {
            System.out.print("\n" + verifyEmailId + "\n");
        }
    }

    @Then("^User is displayed with an error message as \"([^\"]*)\"$")
    public void user_is_displayed_with_an_error_message_as(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        // Write code here that turns the phrase above into concrete actions
        authenticationPage.createAnAccountButtonPresence();
        authenticationPage.clickCreateAnAccountButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String verifyEmailId = authenticationPage.verifyEmailAddress();
        if (verifyEmailId.equals("\nThe email is Valid")) {
            System.out.print("\nThe email address verification is successful. Email is valid");
        } else {
            System.out.print("\n" + verifyEmailId + "\n");
        }
    }
}



