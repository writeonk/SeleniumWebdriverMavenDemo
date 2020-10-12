package com.sample.www;

import org.openqa.selenium.By;

public class Flights {

    public static By textPrice = By.xpath("//span[@data-cy='finalPrice']");
    public static By departureFilter = By.xpath("//span[text()='4am - 11am']");
    public static By stopsFilter = By.xpath("//span[text()='1 ']");
    public static By getTextFareMin = By.id("fareMin");
    public static By getTextFareMax = By.id("fareMax");
    public static By airLinesFilterAirIndia = By.xpath("//span[@data-cy='airlinesFilterAir India']");
}
