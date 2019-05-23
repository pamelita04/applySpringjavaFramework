package com.trend.sys.pages;

import org.openqa.selenium.WebDriver;


public class HomePageUAT {

    private WebDriver webDriver;

    public HomePageUAT(WebDriver driver) {
        this.webDriver = driver;
    }

    public boolean checkIfThePageIsHomePage() {
        return webDriver.getTitle().equals("Home Page");
    }

    public boolean checkIfHomePageTextAvailable() {

        return webDriver.getPageSource().contains("This is Home Page");
    }
}
