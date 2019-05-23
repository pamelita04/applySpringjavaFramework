package com.trend.sys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Google {
    private WebDriver webDriver;
    String textFind;

    public Google(WebDriver driver, String url) {
        this.webDriver = driver;
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }

    public void writteSomething(String something) {
        textFind = something;
        WebElement element1 = webDriver.findElement(By.xpath("//*[@id=\"search_form_input_homepage\"]"));
        element1.sendKeys(something);
    }

    public void pushButton() {
        WebElement element1 = webDriver.findElement(By.xpath("//*[@id=\"search_button_homepage\"]"));
        element1.click();
    }

    public boolean checkIfThePageIsHomePage() {

        String title = textFind + " at DuckDuckGo";
        return webDriver.getTitle().equals(title);
    }


}
