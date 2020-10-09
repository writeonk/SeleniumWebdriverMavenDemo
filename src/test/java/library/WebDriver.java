/*
@author Kunal Soni
*/

package library;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebDriver extends TestBase {

    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public void clearText(By locator) {

        WebElement element = driver.findElement(locator);
        element.clear();
    }

    public void clickOnButton(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public String getText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public String getPlaceholder(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute("placeholder");
    }

    public void selectValueOnDropDown(By locator, String Text) {

        Select selectValue = new Select(driver.findElement(locator));
        selectValue.selectByVisibleText(Text);
    }

    public void selectValueOnCheckBox(By chkBoxCollection, By labelText, By getInput, String Text) {

        List<WebElement> chkBoxCollections = driver.findElements(chkBoxCollection);
        for (WebElement webElement : chkBoxCollections) {
            WebElement getLabel = webElement.findElement(labelText);
            WebElement getInput1 = webElement.findElement(getInput);

            if (getLabel.getText().equals(Text)) {
                if (!getInput1.isSelected()) {
                    getLabel.click();
                    break;
                }
            }
        }

    }

    public void switchTabs() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String parent_window = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String child_window = i1.next();
            if (!parent_window.equalsIgnoreCase(child_window)) {
                driver.switchTo().window(child_window);
                driver.close();
            }
        }

        driver.switchTo().window(parent_window);
    }

    public void waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickByJS(By locator) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", locator);
        } catch (NoSuchElementException e) {
            logger.error("Element not found: " + locator);
        }
    }
}