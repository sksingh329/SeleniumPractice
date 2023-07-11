package app.orangeHrm.pages;

import core.tools.WebElementHelper;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPage {
    private final String pageObjectRepositoryName = "LoginPage.json";
    private WebElementHelper webElementHelper;
    public LoginPage(WebDriver driver, Properties envProperties){
        webElementHelper = new WebElementHelper(driver,envProperties,pageObjectRepositoryName);
    }
    public void login(String userName, String password){
        webElementHelper.findElement("userName").sendKeys(userName);
        webElementHelper.findElement("password").sendKeys(password);
        webElementHelper.findElement("login").click();
    }
}
