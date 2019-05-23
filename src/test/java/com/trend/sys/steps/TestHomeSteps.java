package com.trend.sys.steps;

import com.trend.sys.UATBase;
import com.trend.sys.pages.Google;
import com.trend.sys.pages.HomePageUAT;
import com.trend.sys.pages.IndexPageUAT;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestHomeSteps extends UATBase {

    IndexPageUAT indexPageUAT;
    HomePageUAT homePageUAT;
    Google pageGoogle;

    @Before
    public void setupForTest() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
    }

    @After
    public void shutDown(Scenario scenario) {

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");

        driver.quit();
    }

    @Given("^I am on the search engine home page \"([^\"]*)\"$")
    public void iAmOnTheSearchEngineHomePage(String url) throws Throwable {
        pageGoogle = new Google(driver, url);
//        pageGoogle.getUrl(url);
    }

    @And("^I enter a string \"([^\"]*)\"$")
    public void iEnterAString(String something) throws Throwable {
        pageGoogle.writteSomething(something);
    }

    @When("^I press the search button$")
    public void iPressTheSearchButton() {
        pageGoogle.pushButton();
    }

    @Then("^I should see some results$")
    public void iShouldSeeSomeResults() {
        assertThat(pageGoogle.checkIfThePageIsHomePage()).isTrue();
    }
}
