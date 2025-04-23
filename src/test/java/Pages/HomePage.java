package Pages;

import TestBase.BaseClass;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertEquals;

public class HomePage extends BaseClass {

    public HomePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public void LaunchWebsite()

    {
        webDriver.get("http://localhost:8080/#/");
    }

    public void WaitForPageToLoad() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void VerifyPageTitle() throws InterruptedException {
        String actualTitle = webDriver.getTitle();
        String expectedTitle = "Conduit";

        assertEquals("Title does not match the expected value", actualTitle, expectedTitle);
        Thread.sleep(5000);

    }
}
