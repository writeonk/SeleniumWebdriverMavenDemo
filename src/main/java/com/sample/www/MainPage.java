package com.sample.www;

import org.openqa.selenium.By;

public class MainPage {

    public static By btnSearch = By.id("gi_search_btn");
    public static By txtSource = By.id("gosuggest_inputSrc");
    public static By txtDestination = By.id("gosuggest_inputDest");
    public static By txtDepartureCalendar = By.id("departureCalendar");
    public static By selectDate = By.xpath("(//div[@class='DayPicker-Day'])[18]");
}
