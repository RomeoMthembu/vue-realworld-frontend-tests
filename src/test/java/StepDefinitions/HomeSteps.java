package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;


public class HomeSteps {

    WebDriver webDriver = null;


   @Before
    public void start() throws InterruptedException {

        System.setProperty("webdriver.firefox.driver", "/opt/homebrew/bin/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();



    }

    @After
    public  void End (){

        webDriver.quit();

    }

    @Given("A user launches Conduit website")
    public void a_user_launches_conduit_website() throws InterruptedException {

        webDriver.get("http://localhost:8080/#/");


    }

    @When("The page has fully loaded")
    public void the_page_has_fully_loaded() throws InterruptedException {
        Thread.sleep(5000);

    }

    @Then("Verify the page title is correctly displayed")
    public void verify_the_page_title_is_correctly_displayed() throws InterruptedException {

        String actualTitle = webDriver.getTitle();
        String expectedTitle = "Conduit";

        assertEquals("Title does not match the expected value", actualTitle, expectedTitle);
        Thread.sleep(5000);

    }
}
