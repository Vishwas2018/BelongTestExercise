package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class HomePage {

    @FindBy(how = How.XPATH, using = "//a[contains(text(), \"Sign in\")]")
    public WebElement signInLink;
    CommonMethods commonMethods = new CommonMethods();
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifySignInLink() {
        signInLink.isDisplayed();
        boolean presenceOfElement = commonMethods.isPresent(driver, By.xpath("//a[contains(text(), \"Sign in\")]"));
        if (presenceOfElement) {
            System.out.println("The element is present");
        } else {
            System.out.println("The element is not present");
        }
    }

    public void clickSignInLink() {
        commonMethods.clickButton(signInLink);
    }

    public void navigateToHomePage() {
        driver.get("http://automationpractice.com/index.php");
    }

    public String verifyHomePageTitle() {
        String homePageTitle = commonMethods.getPageTitle(driver);
        return homePageTitle;
    }
}
