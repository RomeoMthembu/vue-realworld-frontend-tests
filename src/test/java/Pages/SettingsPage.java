package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertEquals;

public class SettingsPage {

    WebDriver webDriver;

    By txt_username = By.xpath("//input[@type='text' and @placeholder='Your username']");
    By txt_email = By.xpath("//input[@type='text' and @placeholder='Email']");
    By txt_password = By.xpath("//input[@type='password' and @placeholder='Password']");
    By btn_update = By.xpath("//button[@class='btn btn-lg btn-primary pull-xs-right']");
    By btn_sign_on = By.xpath("//a[@href='#/register'] ");

    public SettingsPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public void LaunchSettingsPage() throws InterruptedException {
        webDriver.get("http://localhost:8080/#/settings");
        Thread.sleep(5000);

    }

    public void EnterDetailstoUpdate() throws InterruptedException {
        webDriver.findElement(txt_username).sendKeys("Wool");
        Thread.sleep(3000);
        webDriver.findElement(txt_email).sendKeys("wohnQ@gmail.com");
        Thread.sleep(3000);
        webDriver.findElement(txt_password).sendKeys("65432");
        Thread.sleep(3000);
        webDriver.findElement(btn_update).click();
        Thread.sleep(5000);
    }

    public void AssertNoUpdateWasMade() throws InterruptedException {
        Thread.sleep(5000);
        String Button_Text = webDriver.findElement(btn_sign_on).getText();
        String expectedText = "Sign up";


        assertEquals("There is no Error message", Button_Text, expectedText);
        Thread.sleep(5000);
    }
}
