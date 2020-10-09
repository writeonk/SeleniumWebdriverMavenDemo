/*
@author Kunal Soni
*/

package com.sample.www;

import com.aventstack.extentreports.Status;
import common.TestBase;
import org.testng.annotations.Test;

public class MainPage extends TestBase {

    @Test
    public void tc01VerifyOpenURL() {

        test = extent.createTest("Verify URL", "Test go ibibo site ")
                .assignCategory("Functional")
                .assignCategory("Positive")
                .assignAuthor("Kunal");
        logger.info("Login: Verify URL");

        openURL("https://www.goibibo.com");
        test.log(Status.INFO, "Open URL");
        logger.info("Open URL");

    }

}
