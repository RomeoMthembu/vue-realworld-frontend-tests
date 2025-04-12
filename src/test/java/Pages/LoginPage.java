package Pages;

import TestBase.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertEquals;

public class LoginPage extends BaseClass {


    By username = By.xpath("//*[@id='app']/div/div/div/div/form/fieldset[1]/input");
    By password = By.xpath("//*[@id='app']/div/div/div/div/form/fieldset[2]/input");
    By tab_login = By.xpath("//a[@href='#/login']");
    By btn_login = By.xpath("//*[@id='app']/div/div/div/div/form/button");

    public LoginPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public void SignIn() throws InterruptedException {
        webDriver.get("http://localhost:8080/#/");
        webDriver.findElement(tab_login).click();
        Thread.sleep(5000);
    }

    public void EnterLoginDetails() throws InterruptedException {

        webDriver.findElement(username).sendKeys("JohnDoe");
        Thread.sleep(3000);
        webDriver.findElement(password).sendKeys("12345");
        Thread.sleep(3000);
        webDriver.findElement(btn_login).click();
        Thread.sleep(5000);
    }

    public void AssertLoginName() throws InterruptedException {

        String Customer = webDriver.findElement(By.xpath("//*[@id=\"app\"]/nav/div/ul/li[4]/a")).getText();
        String expectedTitle = "JohnDoe";

        assertEquals("Username does not match the expected value", Customer, expectedTitle);
        Thread.sleep(5000);

    }
}

