package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;
import utilities.GetTestEmailId;

public class CreateAccountPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"noSlide\"]/h1")
    public WebElement pageHeading;
    @FindBy(how = How.ID, using = "account-creation_form")
    public WebElement accountCreationForm;
    @FindBy(how = How.ID, using = "id_gender1")
    public WebElement radioButtonTitleMr;
    @FindBy(how = How.ID, using = "id_gender2")
    public WebElement radioButtonTitleMrs;
    @FindBy(how = How.ID, using = "customer_firstname")
    public WebElement firstNameTextField;
    @FindBy(how = How.ID, using = "customer_lastname")
    public WebElement lastNameTextField;
    @FindBy(how = How.ID, using = "email")
    public WebElement emailTextField;
    @FindBy(how = How.ID, using = "passwd")
    public WebElement passwordTextField;
    @FindBy(how = How.ID, using = "days")
    public WebElement daysDrowpdownField;
    @FindBy(how = How.ID, using = "months")
    public WebElement motnhsDropdownField;
    @FindBy(how = How.ID, using = "years")
    public WebElement yearsDropdownField;
    @FindBy(how = How.ID, using = "firstname")
    public WebElement addressSectionFirstNameTextField;
    @FindBy(how = How.ID, using = "lastname")
    public WebElement addressSectionLastNameTextField;
    @FindBy(how = How.ID, using = "company")
    public WebElement companyTextField;
    @FindBy(how = How.ID, using = "address1")
    public WebElement addressOneTextField;
    @FindBy(how = How.ID, using = "address2")
    public WebElement addressTwoTextField;
    @FindBy(how = How.ID, using = "city")
    public WebElement cityTextField;
    @FindBy(how = How.ID, using = "id_state")
    public WebElement stateDropdownField;
    @FindBy(how = How.ID, using = "postcode")
    public WebElement postcodeTextField;
    @FindBy(how = How.ID, using = "id_country")
    public WebElement countryDropdownField;
    @FindBy(how = How.ID, using = "other")
    public WebElement otherTestField;
    @FindBy(how = How.ID, using = "phone")
    public WebElement phoneTextField;
    @FindBy(how = How.ID, using = "phone_mobile")
    public WebElement phoneMobileTextField;
    @FindBy(how = How.ID, using = "alias")
    public WebElement aliasTextField;
    @FindBy(how = How.ID, using = "submitAccount")
    public WebElement submitAccountButton;
    WebDriver driver;
    CommonMethods commonMethods = new CommonMethods();
    GetTestEmailId getTestEmailId = new GetTestEmailId();

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifyCreateAccountPageTitle() {
        return commonMethods.getPageTitle(driver);
    }

    public String getPageHeading() {
        return commonMethods.getText(pageHeading);
    }

    public void accountCreationFormPresence() {
        commonMethods.isDisplayed(accountCreationForm);
    }

    public void selectRadioButtonTitleMr() {
        commonMethods.clickButton(radioButtonTitleMr);
    }

    public void selectRadioButtonTitleMrs() {
        commonMethods.clickButton(radioButtonTitleMrs);
    }

    public void enterCustomerFirstname() {
        commonMethods.enterText(firstNameTextField, "firstName");
    }

    public void enterCustomerLastname() {
        commonMethods.enterText(lastNameTextField, "lastName");
    }

    public void enterEmailID() {
        commonMethods.enterKey(emailTextField, "TAB");
    }

    public String getEmailIdText() {
        return commonMethods.getText(emailTextField);
    }

    public void enterPassword() {
        commonMethods.enterText(passwordTextField, "testing@123");
    }

    public void enterDay() {
        commonMethods.selectValueFromDropdown(daysDrowpdownField, "25");
    }

    public void enterMonth() {
        commonMethods.selectValueFromDropdown(motnhsDropdownField, "11");
    }

    public void enterYear() {
        commonMethods.selectValueFromDropdown(yearsDropdownField, "1983");
    }

    public void enterAddressFirstname() {
        commonMethods.enterText(addressSectionFirstNameTextField, "firstName");
    }

    public void enterAddressLastname() {
        commonMethods.enterText(addressSectionLastNameTextField, "lastName");
    }

    public void enterCompany() {
        commonMethods.enterText(companyTextField, "abcCorp");
    }

    public void enterAddressLineOne() {
        commonMethods.enterText(addressOneTextField, "35");
    }

    public void enterAddressLineTwo() {
        commonMethods.enterText(addressTwoTextField, "Creek Road");
    }

    public void enterCity() {
        commonMethods.enterText(cityTextField, "New Town");
    }

    public void enterState() {
        commonMethods.selectValueFromDropdown(stateDropdownField, "5");
    }

    public void enterPostcode() {
        commonMethods.enterText(postcodeTextField, "90001");
    }

    public void enterCountry() {
        commonMethods.selectValueFromDropdown(countryDropdownField, "21");
    }

    public void enterAdditionalInformation() {
        commonMethods.enterText(otherTestField, "This is my address");
    }

    public void enterHomePhone() {
        commonMethods.enterText(phoneTextField, "123123212");
    }

    public void enterMobilePhone() {
        commonMethods.enterText(phoneMobileTextField, "1231223123");
    }

    public void enterAliasForAddress() {
        commonMethods.enterText(aliasTextField, "My permanent address");
    }

    public void registerButtonPresence() {
        commonMethods.isDisplayed(submitAccountButton);
    }

    public void clickRegisterButton() {
        commonMethods.clickButton(submitAccountButton);
    }


//

}

