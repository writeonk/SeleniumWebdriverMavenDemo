/*
@author Kunal Soni
*/

package com.sample.www;

import com.aventstack.extentreports.Status;
import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01MainPage extends TestBase {

    @Test
    public void tc01VerifyOpenURL() {

        test = extent.createTest("Verify URL", "Case 1: User needs to verify if Go Ibibo homepage works as expected.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");
        logger.info("Verify URL");

        openURL("https://www.goibibo.com");
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");

        String expectedTitle = "Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {

            test.log(Status.INFO, "Verification Successful - The correct title is displayed on the web page.");
            logger.info("Verification Successful - The correct title is displayed on the web page.");

        } else {
            test.log(Status.FAIL, "Verification Failed - An incorrect title is displayed on the web page.");
            logger.error("Verification Failed - An incorrect title is displayed on the web page.");
        }
    }

    @Test
    public void tc02VerifyOneWayFlights() {

        test = extent.createTest("Verify one-way flights", "Case 2: User should be able to search for one-way flights between Bangalore and Mumbai")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");
        logger.info("Verify one-way flights");

        webdriver.clickOnButton(MainPage.btnSearch);
        test.log(Status.INFO, "Click on search button with entering any details.");
        logger.info("Click on search button with entering any details.");

        String getSourceErrorText = webdriver.getText(ErrorMessages.errorPleaseEnterValidSource);
        Assert.assertEquals(getSourceErrorText, "Please enter a valid Source", "Validation failed");
        test.log(Status.INFO, "<span class='badge badge-danger'> Error </span> Please enter a valid Source");
        logger.info("Error: Please enter a valid Source");

        webdriver.enterText(MainPage.txtSource, "BLR");
        test.log(Status.INFO, "Enter a valid source");
        logger.info("Enter a valid source");

        webdriver.waitForElementVisible(MainPage.txtSource);
        WebElement element = driver.findElement(By.id("gosuggest_inputSrc"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.sendKeys(Keys.DOWN);
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();

        webdriver.clickOnButton(MainPage.btnSearch);
        test.log(Status.INFO, "Click on search button after adding valid source");
        logger.info("Click on search button after adding valid source");

        String getDestinationErrorText = webdriver.getText(ErrorMessages.errorPleaseEnterValidDestination);
        Assert.assertEquals(getDestinationErrorText, "Please enter a valid Destination", "Validation failed");
        test.log(Status.INFO, "<span class='badge badge-danger'> Error </span> Please enter a valid Destination");
        logger.info("Verify Error: Please enter a valid Destination");

        webdriver.enterText(MainPage.txtDestination, "BOM");
        test.log(Status.INFO, "Enter a valid destination");
        logger.info("Enter a valid destination");

        webdriver.waitForElementVisible(MainPage.txtDestination);
        WebElement element1 = driver.findElement(By.id("gosuggest_inputDest"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(element1);
        actions1.sendKeys(Keys.DOWN);
        actions1.sendKeys(Keys.ENTER);
        actions1.build().perform();

        webdriver.clickOnButton(MainPage.btnSearch);
        test.log(Status.INFO, "Click on search button after adding valid destination");
        logger.info("Click on search button after adding valid destination");

        String getDepartureDateErrorText = webdriver.getText(ErrorMessages.errorPleaseEnterValidDepartureDate);
        Assert.assertEquals(getDepartureDateErrorText, "Please enter a valid departure date", "Validation failed");
        test.log(Status.INFO, "<span class='badge badge-danger'> Error </span> Please enter a valid departure date");
        logger.info("Verify Error: Please enter a valid departure date");

        webdriver.clickOnButton(MainPage.txtDepartureCalendar);
        test.log(Status.INFO, "Click on departure calendar");
        logger.info("Click on departure calendar");

        webdriver.waitForElementLocated(MainPage.selectDate);
        webdriver.clickOnButton(MainPage.selectDate);
        test.log(Status.INFO, "select a valid date");
        logger.info("select a valid date");

        webdriver.clickOnButton(MainPage.btnSearch);
        test.log(Status.INFO, "Click on search button after adding select date");
        logger.info("Click on search button after adding select date");
    }

}
