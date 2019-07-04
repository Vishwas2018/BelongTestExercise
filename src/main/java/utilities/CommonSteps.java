package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AuthenticationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

import java.util.concurrent.TimeUnit;

public class CommonSteps {

    public static WebDriver driver;
    HomePage homePage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;

    public CommonSteps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void NavigateToTheHomePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        System.out.println("\nNavigating to Automation Practice Website");
        homePage.navigateToHomePage();
    }

    public void NavigateToMyAccount() {
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
}
