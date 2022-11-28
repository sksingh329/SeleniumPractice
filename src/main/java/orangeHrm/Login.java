package orangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    String applicationUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    By elemTextUsername = By.name("username");
    By elemTextPassword = By.name("password");
    By elemButtonLogin = By.xpath("//button[@type='submit' and text()=' Login ']");

    public String loginApplication(String userName, String password) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(applicationUrl);
        driver.manage().window().maximize();
        Thread.sleep(1000); // TODO - Add explicit wait
        driver.findElement(elemTextUsername).sendKeys(userName);
        driver.findElement(elemTextPassword).sendKeys(password);
        driver.findElement(elemButtonLogin).click();
        String pageTitle = driver.getTitle(); // TODO - Add validation for login
        driver.quit();
        return pageTitle;
    }
}
