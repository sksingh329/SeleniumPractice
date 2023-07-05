package core.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementHelper {
    private WebDriver driver;

    public WebElementHelper(WebDriver driver){
        this.driver = driver;
    }
    public WebElement findElement(String objectName) {
        // Logic to retrieve WebElement based on objectName


        return driver.findElement(By.id(objectName));
    }
}
