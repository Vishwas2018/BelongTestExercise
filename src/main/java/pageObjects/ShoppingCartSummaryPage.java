package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class ShoppingCartSummaryPage {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Printed Summer Dress')]")
    public WebElement productName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"product_6_31_0_188329\"]/td[2]/small[2]/a")
    public WebElement productColor;
    @FindBy(how = How.CSS, using = ".cart_quantity_input.form-control.grey")
    public WebElement productQuantity;
    WebDriver driver;
    CommonMethods commonMethods = new CommonMethods();

    public ShoppingCartSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifyShoppigCarSummaryPageTitle() {
        return commonMethods.getPageTitle(driver);
    }

    public String getProductName() {
        return commonMethods.getElementAttribute(productName, "innerHTML");
    }

    public String getProductColor() {
        return commonMethods.getElementAttribute(productColor, "innerHTML");
    }

    public Object productQuantity() {
        return commonMethods.getElementAttribute(productQuantity, "innertHTML");
    }

}
