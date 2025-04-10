package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class HomeSteps {

    WebDriver webDriver = null;

    @Given("A user launches Conduit website")
    public void a_user_launches_conduit_website() throws InterruptedException {
        System.setProperty("webdriver.firefox.driver", "/opt/homebrew/bin/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:8080/#/");
        Thread.sleep(5000);
    }

    @When("The page has fully loaded")
    public void the_page_has_fully_loaded() {

    }

    @Then("Verify the page title is correctly displayed")
    public void verify_the_page_title_is_correctly_displayed() {

        webDriver.quit();

    }
}
