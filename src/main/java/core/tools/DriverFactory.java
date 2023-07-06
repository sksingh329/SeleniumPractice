package core.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    // Responsible for creating and returning driver object

    public static WebDriver newDriver(String browserName){
        WebDriver driver = null;
        switch (browserName){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
