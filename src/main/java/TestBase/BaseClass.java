package TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected static WebDriver webDriver;
    public void initializeDriver() {
        if (webDriver == null) {
            System.setProperty("webdriver.firefox.driver", "src/test/resources/Drivers/geckodriver.exe");
            webDriver = new FirefoxDriver();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
        }
    }
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

}
