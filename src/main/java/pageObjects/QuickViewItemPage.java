package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class QuickViewItemPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
    public WebElement shoppingItem;
    @FindBy(how = How.XPATH, using = "//*[@id=\"add_to_cart\"]/button")
    public WebElement addToCartButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
    public WebElement productAddedToCartMessage;
    @FindBy(how = How.ID, using = "color_16")
    public WebElement selectedItemColor;
    @FindBy(how = How.ID, using = "quantity_wanted")
    public WebElement selectedItemQuantity;
    @FindBy(how = How.XPATH, using = "//*[@id=\"product\"]/div/div/div[2]/h1")
    public WebElement selectedShoppingItemName;
    @FindBy(how = How.XPATH, using = "//iframe[contains(@id, 'fancybox-frame')]")
    public WebElement iFrameXpath;
    @FindBy(how = How.XPATH, using = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    public WebElement proceedToCheckoutButton;
    WebDriver driver;
    CommonMethods commonMethods = new CommonMethods();

    public QuickViewItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifyQuickViewItemPageTitle() {
        return commonMethods.getPageTitle(driver);
    }

    public boolean verifyShoppingItemVisible() {
        return commonMethods.waitForElementToBePresent(driver, shoppingItem, 10);
    }

    public boolean verifyShoppingItemClickable() {
        return commonMethods.waitForElementClickable(driver, shoppingItem, 10);
    }

    public void clickShoppingItem() {
        commonMethods.clickButton(shoppingItem);
    }


    public void getShoppingItemName() {
        commonMethods.waitForElementToBePresent(driver, iFrameXpath, 10);
        WebDriver iframe = commonMethods.switchToIframe(driver, iFrameXpath);
        System.out.print("\nThe iframe is: " + iframe);
    }

    public String getSelectedShoppingItemName() {
        return commonMethods.getText(selectedShoppingItemName);
    }

    public String getSelectedItemQuantityValue() {
        return commonMethods.getElementAttribute(selectedItemQuantity, "value");
    }

    public String getSelectedItemColorName() {
        return commonMethods.getElementAttribute(selectedItemColor, "name");
    }

    public void clickAddToCartButton() {
        commonMethods.clickButton(addToCartButton);
    }

    public String getProductAddedToCartMessage() {
        return commonMethods.getText(productAddedToCartMessage);
    }

    public void verifyProceedToCheckoutButtonVisible() {
        commonMethods.waitForElementToBePresent(driver, proceedToCheckoutButton, 20);
    }

    public void clickProceedToCheckoutButton() {
        commonMethods.clickButtonInsideOverlay(driver, proceedToCheckoutButton);
    }

    public void verifyProceedToCheckoutButtonClickable() {
        commonMethods.waitForElementClickable(driver, addToCartButton, 20);
    }


}
