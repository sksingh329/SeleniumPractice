package app.nxtgenaiacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage {
    private WebDriver driver;
    private By errorClassName = By.xpath("//*[@class='vfb-error']");
    private By submit = By.name("vfb-submit");

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickSubmit(){
        driver.findElement(submit).click();
    }
    public int errorCountAfterSubmit(){
        List<WebElement> errorElements = driver.findElements(errorClassName);
        return errorElements.size();
    }
}
