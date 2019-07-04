package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public void clickButton(WebElement buttonToBeClicked) {
        buttonToBeClicked.click();
    }

    public void enterText(WebElement element, String textToBeEntered) {
        element.sendKeys(textToBeEntered);
    }

    public String getText(WebElement textPresent) {
        return textPresent.getText();
    }

    public boolean isPresent(WebDriver driver, By locator) {
        driver.findElements(locator);
        return true;
    }

    public void enterKey(WebElement element, String keyValue) {
        element.sendKeys(keyValue);
    }

    public void clearTextField(WebElement element) {
        element.clear();
    }

    public void selectValueFromDropdown(WebElement element, String valueText) {
        System.out.print("\nThe text to be selected from dropdown is: " + valueText);
        Select dropdownValue = new Select(element);
        dropdownValue.selectByValue(valueText);
    }

    public void isDisplayed(WebElement element) {
        element.isDisplayed();
    }

    public boolean waitForElementToBePresent(WebDriver driver, WebElement element, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public boolean isDisplayedForElement(WebDriver driver, WebElement element) {
//        if (element.equals("//*[@id=\"create_account_error\"]/ol/li")){
//            System.out.print("\nVerifying if the email is already registered");
//        } else if (element.equals("//div[@class=\"form-group form-error\"]")) {
//            System.out.print("\nVerifying if the email is valid");
//        }
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            element.isDisplayed();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean waitForElementClickable(WebDriver driver, WebElement element, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return true;
    }

    public String getElementAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public WebDriver switchToIframe(WebDriver driver, WebElement element) {
        WebDriver iFrame = driver.switchTo().frame(element);
        return iFrame;
    }

    public void clickButtonInsideOverlay(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public Object getHiddenElementValue(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor.executeScript("arguments[0].value();", element);
    }

    public void sendKeysInput(WebElement element) {
        element.sendKeys("TAB");
    }

    public boolean pageSourceCode(WebDriver driver, String verifyText) {
        return driver.getPageSource().contains(verifyText);
    }
}

