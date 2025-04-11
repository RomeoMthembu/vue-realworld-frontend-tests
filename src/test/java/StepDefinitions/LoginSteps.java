package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

public class LoginSteps {


    WebDriver webDriver = null;
    By username = By.xpath("//*[@id=\"app\"]/div/div/div/div/form/fieldset[1]/input");
    By password = By.xpath("//*[@id=\"app\"]/div/div/div/div/form/fieldset[2]/input");
    By tab_login = By.xpath("//a[@href=\"#/login\"]");
    By btn_login = By.xpath("//*[@id=\"app\"]/div/div/div/div/form/button");

   // @Before
    public void start() throws InterruptedException {

        System.setProperty("webdriver.firefox.driver", "/opt/homebrew/bin/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:8080/#/");
        Thread.sleep(10000);

    }

  //  @After
    public  void End (){

        webDriver.quit();

    }

    @Given("An existing customer")
    public void an_existing_customer() throws InterruptedException {

        webDriver.findElement(tab_login).click();
        Thread.sleep(5000);

    }

    @When("Customer logs in with valid username and password")
    public void customer_logs_in_with_valid_username_and_password() throws InterruptedException {

        webDriver.findElement(username).sendKeys("JohnDoe");
        Thread.sleep(3000);
        webDriver.findElement(password).sendKeys("12345");
        Thread.sleep(3000);
        webDriver.findElement(btn_login).click();
        Thread.sleep(5000);

    }

    @Then("The customer must be successfully logged in")
    public void the_customer_must_be_successfully_logged_in() throws InterruptedException {

        String Customer = webDriver.findElement(By.xpath("//*[@id=\"app\"]/nav/div/ul/li[4]/a")).getText();
        String expectedTitle = "JohnDoe";

        assertEquals("Username does not match the expected value", Customer, expectedTitle);
        Thread.sleep(5000);

    }
}
