package com.sample.www;

import org.openqa.selenium.By;

public class ErrorMessages {

    public static By errorPleaseEnterValidSource = By.xpath("//span[contains(text(), 'Please enter a valid Source')]");
    public static By errorPleaseEnterValidDestination = By.xpath("//span[contains(text(), 'Please enter a valid Destination')]");
    public static By errorPleaseEnterValidDepartureDate = By.xpath("//span[contains(text(), 'Please enter a valid departure date')]");
}
