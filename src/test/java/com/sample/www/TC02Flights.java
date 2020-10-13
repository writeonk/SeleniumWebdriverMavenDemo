package com.sample.www;

import com.aventstack.extentreports.Status;
import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TC02Flights extends TestBase {

    @Test
    public void tc01VerifyPageResults() {

        test = extent.createTest("Verify Page Results", "Case 3: User should be able to verify if the page results are ordered in decreasing order of cost.")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");
        logger.info("Verify Page Results");

        validateTheCost();
    }

    @Test
    public void tc02VerifyApplyFilters() {

        test = extent.createTest("Verify Apply Filters", "Case 4: Apply filters in the left side still the page results are ordered in decreasing order of cost")
                .assignCategory("Functional_testcase")
                .assignAuthor("Kunal");
        logger.info("Verify Apply Filters");

        webdriver.clickOnButton(Flights.departureFilter);
        test.log(Status.INFO, "Apply departure filter");
        logger.info("Apply departure filter");

        webdriver.clickOnButton(Flights.stopsFilter);
        test.log(Status.INFO, "Apply stop filter");
        logger.info("Apply stop filter");

        webdriver.clickOnButton(Flights.airLinesFilterAirIndia);
        test.log(Status.INFO, "Apply airLines filter Air India");
        logger.info("Apply airLines filter Air India");

        validateTheCost();
    }

    public void validateTheCost() {

        List<WebElement> elementList = driver.findElements(By.xpath("//span[@data-cy='finalPrice']"));
        elementList.get(0).getText();

        List<String> originalList = new ArrayList();
        for (int i = 0; i < elementList.size(); i++) {
            originalList.add(elementList.get(i).getText());
            test.log(Status.INFO, "list " + elementList.get(i).getText());
            logger.info("list" + elementList.get(i).getText());
        }
        List<String> tempList = originalList;
        Collections.sort(tempList);

        boolean isValid = getResult(originalList, tempList);

        test.log(Status.INFO, isValid ? "Page results are in decreasing order" : "Page results are not ordered in decreasing order");
        logger.info(isValid ? "Page results are in decreasing order" : "Page results are not ordered in decreasing order");
        System.out.println(isValid ? "Page results are in decreasing order" : "Page results are not ordered in decreasing order");
    }

    private boolean getResult(List<String> originalList, List<String> tempList) {

        for (int i = 0; i < tempList.size(); i++) {
            if (!tempList.get(i).equalsIgnoreCase(originalList.get(i))) {
                System.out.println("Error");
                return false;
            }
        }
        return true;
    }

}
