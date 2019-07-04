package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class MyAccountPage {

    @FindBy(how = How.ID, using = "center_column")
    public WebElement centerColumn;
    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    public WebElement dressesMenu;
    WebDriver driver;
    CommonMethods commonMethods = new CommonMethods();

    public MyAccountPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public String verifyMyAccountPageTitle() {
        return commonMethods.getPageTitle(driver);
    }

    public void centerColumnPresent() {
        commonMethods.isDisplayed(centerColumn);
    }

    public void verifyDressesMenuPresence() {
        commonMethods.isDisplayed(dressesMenu);
    }

    public void clickDressesMenu() {
        commonMethods.clickButton(dressesMenu);
    }

    public boolean verifyCenterColumnToBeVisible() {
        return commonMethods.waitForElementToBePresent(driver, centerColumn, 10);
    }

    public boolean verifyCenterColumnToBeClickable() {
        return commonMethods.waitForElementClickable(driver, centerColumn, 10);
    }
}
