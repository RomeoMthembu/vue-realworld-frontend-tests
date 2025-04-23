package Pages;

import TestBase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.security.SecureRandom;
import static junit.framework.Assert.assertEquals;

public class RegistrationPage extends BaseClass {

    WebDriver webDriver;

    By btn_register = By.xpath("//a[@href='#/register']");
    By username = By.xpath("//*[@id='app']/div/div/div/div/form/fieldset[1]/input");
    By email = By.xpath("//*[@id='app']/div/div/div/div/form/fieldset[2]/input");
    By password = By.xpath("//*[@id='app']/div/div/div/div/form/fieldset[3]/input");
    By btn_sign_on = By.xpath("//*[@id='app']/div/div/div/div/form/button");
    String randomStr = generateRandomString(5); // generates a 5-character string

    public RegistrationPage(WebDriver webDriver) throws InterruptedException {
        this.webDriver = webDriver;
    }

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }

    public void launchRegistrationPage() throws InterruptedException {
        webDriver.get("http://localhost:8080/#/");

        webDriver.findElement(btn_register).click();
        Thread.sleep(5000);

    }

    public void EnterInRegistrationCredentials() throws InterruptedException {
        webDriver.findElement(username).sendKeys(randomStr);
        Thread.sleep(3000);

        webDriver.findElement(email).sendKeys(randomStr + "@gmail.com");
        Thread.sleep(3000);
        webDriver.findElement(password).sendKeys("65432");
        Thread.sleep(3000);
        webDriver.findElement(btn_sign_on).click();
        Thread.sleep(5000);
    }

    public void AssertCustomerName() throws InterruptedException {
        String Customer = webDriver.findElement(By.xpath("//*[@id='app']/nav/div/ul/li[4]/a")).getText();

        assertEquals("Username does not match the expected value", Customer, randomStr);
        Thread.sleep(5000);
    }

    public void EnterInExistingEmail() throws InterruptedException {

        webDriver.findElement(username).sendKeys("TimJ");
        Thread.sleep(3000);

        webDriver.findElement(email).sendKeys("TimJ@gmail.com");
        Thread.sleep(3000);
        webDriver.findElement(password).sendKeys("65432");
        Thread.sleep(3000);
        webDriver.findElement(btn_sign_on).click();
        Thread.sleep(10000);
    }

    public void ValidateExistingEmailErrorMessage () throws InterruptedException {
        Thread.sleep(5000);
        String ErrorMessage = webDriver.findElement(By.xpath("//*[@id='app']//ul/li[contains(.,'body User already registered')]")).getText();
        String expectedTitle = "body User already registered";


        assertEquals("There is no Error message", ErrorMessage, expectedTitle);
        Thread.sleep(5000);

    }

    public void RegisterWithInvalidEmail() throws InterruptedException {
        webDriver.findElement(username).sendKeys("johndoe");
        Thread.sleep(3000);

        webDriver.findElement(email).sendKeys("johndoe%gmail.com");
        Thread.sleep(3000);
        webDriver.findElement(password).sendKeys("65432");
        Thread.sleep(3000);
        webDriver.findElement(btn_sign_on).click();
        Thread.sleep(10000);
    }

    public void AssertInvalidEmailError() throws InterruptedException {

        Thread.sleep(5000);
        String ErrorMessage = webDriver.findElement(btn_register).getText();
        String expectedTitle = "Sign up";


        assertEquals("There is no Error message", ErrorMessage, expectedTitle);
        Thread.sleep(5000);
    }


}
