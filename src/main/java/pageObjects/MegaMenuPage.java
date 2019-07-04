package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class MegaMenuPage {

    @FindBy(how = How.ID, using = "center_column")
    public WebElement centerColumn;
    @FindBy(how = How.XPATH, using = "//*[@id=\"categories_block_left\"]/div/ul/li[3]/a")
    public WebElement summerDressesMenu;
    @FindBy(how = How.CLASS_NAME, using = "heading-counter")
    public WebElement summerDressesSelectionMenu;
    WebDriver driver;
    CommonMethods commonMethods = new CommonMethods();

    public MegaMenuPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public String getSummerDressesMenuPageTitle() {
        return commonMethods.getPageTitle(driver);
    }

    public String verifyMyAccountPageTitle() {
        return commonMethods.getPageTitle(driver);
    }

    public boolean verifySummerDressesMenuVisibility() {
        return commonMethods.waitForElementClickable(driver, summerDressesMenu, 20);
    }

    public void clickSummerDressesMenu() {
        commonMethods.clickButton(summerDressesMenu);
    }

    public String verifySummerDressesItemsAvailability() {
        return commonMethods.getText(summerDressesSelectionMenu);
    }

}

