package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;

public class RegisterSteps {

    WebDriver webDriver = null;
    By btn_register = By.xpath("//a[@href=\"#/register\"]");
    By username = By.xpath("//*[@id=\"app\"]/div/div/div/div/form/fieldset[1]/input");
    By email = By.xpath("//*[@id=\"app\"]/div/div/div/div/form/fieldset[2]/input");
    By password = By.xpath("//*[@id=\"app\"]/div/div/div/div/form/fieldset[3]/input");
    By btn_sign_on = By.xpath("//*[@id=\"app\"]/div/div/div/div/form/button");
    By Loggedon_username = By.xpath("//a[@href=\"#/@mthembuuu/\"]");

    @Before
    public void start() throws InterruptedException {

        System.setProperty("webdriver.firefox.driver", "/opt/homebrew/bin/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:8080/#/");
        Thread.sleep(5000);

    }

 @After
    public  void End (){

        webDriver.quit();

    }

    @Given("A new customer launches the Website")
    public void a_new_customer_launches_the_website() throws InterruptedException {

        webDriver.findElement(btn_register).click();
        Thread.sleep(5000);

    }

    @When("Customer registers with valid credentials on the website")
    public void customer_registers_with_valid_credentials_on_the_website() throws InterruptedException {

        webDriver.findElement(username).sendKeys("wohnQ");
        Thread.sleep(3000);
        //String Name = webDriver.findElement(username).getText();

        webDriver.findElement(email).sendKeys("wohnQ@gmail.com");
        Thread.sleep(3000);
        webDriver.findElement(password).sendKeys("65432");
        Thread.sleep(3000);
        webDriver.findElement(btn_sign_on).click();
        Thread.sleep(5000);
    }

    @Then("Customer must be able to register successfully")
    public void customer_must_be_able_to_register_successfully() throws InterruptedException {

      String Customer = webDriver.findElement(By.xpath("//*[@id=\"app\"]/nav/div/ul/li[4]/a")).getText();
      String expectedTitle = "wohnQ";

        assertEquals("Username does not match the expected value", Customer, expectedTitle);
        Thread.sleep(5000);


    }

    @When("Customer registers using existing email address")
    public void customer_registers_using_existing_email_address() throws InterruptedException {

        webDriver.findElement(username).sendKeys("romeom");
        Thread.sleep(3000);
        //String Name = webDriver.findElement(username).getText();

        webDriver.findElement(email).sendKeys("romeomthembu@gmail.com");
        Thread.sleep(3000);
        webDriver.findElement(password).sendKeys("65432");
        Thread.sleep(3000);
        webDriver.findElement(btn_sign_on).click();
        Thread.sleep(10000);

    }

    @Then("An invalid registration credentials error must be displayed")
    public void an_invalid_registration_credentials_error_must_be_displayed() throws InterruptedException {

        Thread.sleep(50000);
        String ErrorMessage = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/ul/li/text()")).getText();
        String expectedTitle = "body User already registered";

        System.out.println("This is..." + ErrorMessage);

        assertEquals("There is no Error message", ErrorMessage, expectedTitle);
        Thread.sleep(5000);


    }
}
