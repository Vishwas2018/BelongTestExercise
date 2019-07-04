package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;
import utilities.GetTestEmailId;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class AuthenticationPage {

    public WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@class=\"form-group form-error\"]")
    public WebElement emailAddressError;
    @FindBy(how = How.XPATH, using = "//div[@class=\"form-group form-ok\"]")
    public WebElement emailValid;
    @FindBy(how = How.XPATH, using = ("//*[@id=\"create_account_error\"]/ol/li"))
    public WebElement emailAlreadyRegistered;
    @FindBy(how = How.ID, using = "email_create")
    public WebElement emailAddressTextField;
    @FindBy(how = How.ID, using = "SubmitCreate")
    public WebElement createAnAccountButton;
    @FindBy(how = How.ID, using = "email")
    public WebElement alreadyRegisteredEmail;
    @FindBy(how = How.ID, using = "passwd")
    public WebElement enterPasswordTextField;
    @FindBy(how = How.ID, using = "SubmitLogin")
    public WebElement singInButton;

    CommonMethods commonMethods = new CommonMethods();
    GetTestEmailId getTestEmailId = new GetTestEmailId();

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifyEmailAddress() {
        boolean isDisplayed = commonMethods.isDisplayedForElement(driver, emailAlreadyRegistered);
        if (isDisplayed) {
            return "\n\nThe email address is already registered";
        } else if (commonMethods.isDisplayedForElement(driver, emailAddressError)) {
            return "\n\nThe email is invalid";
        } else {
            return "\n\nThe email is Valid";
        }
    }

    public String verifyAuthenticationPageTitle() {
        return commonMethods.getPageTitle(driver);
    }

    public void enterEmailAddress() throws FileNotFoundException {
        System.out.println("\nIn authentication page");
        String testEmail = getTestEmailId.sendTestEmail();
        System.out.println("\nThe email id is: " + testEmail);
        commonMethods.enterText(emailAddressTextField, testEmail);
    }

    public void verifyEmailTextFieldPresence() {
        commonMethods.isDisplayed(emailAddressTextField);
    }

    public void createAnAccountButtonPresence() {
        commonMethods.isDisplayed(createAnAccountButton);
    }

    public void clickCreateAnAccountButton() {
        commonMethods.clickButton(createAnAccountButton);
    }

    public void clearEmailTextField() {
        commonMethods.clearTextField(emailAddressTextField);
    }

    public void enterRegisteredEmail () {
        commonMethods.clearTextField(alreadyRegisteredEmail);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String registeredEmail = "jvishu21@gmail.com";
        commonMethods.enterText(alreadyRegisteredEmail, registeredEmail);
    }

    public void enterPasswordRegisteredEmail() {
        commonMethods.enterText(enterPasswordTextField, "Practice@123");
    }

    public void clickSignInButton() {
        commonMethods.waitForElementToBePresent(driver, singInButton, 10);
        commonMethods.clickButton(singInButton);
    }

}

