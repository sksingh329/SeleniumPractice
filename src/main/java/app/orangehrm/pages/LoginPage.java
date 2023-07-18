package app.orangehrm.pages;

import core.tools.WebElementHelper;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPage {
    private final WebElementHelper webElementHelper;
    private final Properties envProperties;
    private final WebDriver driver;
    private final String pageObjectRepositoryName = "LoginPage.json";
    public LoginPage(WebDriver driver, Properties envProperties){
        this.driver = driver;
        this.envProperties = envProperties;
        webElementHelper = new WebElementHelper(driver,envProperties, pageObjectRepositoryName);
    }
    public void typeUserName(String userName){
        webElementHelper.findElement("userName").sendKeys(userName);
    }
    public void typePassword(String password){
        webElementHelper.findElement("password").sendKeys(password);
    }
    public DashboardPage submitLogin(){
        webElementHelper.findElement("login").click();
        return new DashboardPage(driver,envProperties);
    }
    public LoginPage submitLoginWhenLoginFailed(){
        webElementHelper.findElement("login").click();
        return new LoginPage(driver,envProperties);
    }
    public String getInvalidCredentialsText(){
        return webElementHelper.findElement("invalidCredential").getText();
    }
    public String getUserNameRequiredText(){
        return webElementHelper.findElement("userNameFieldRequired").getText();
    }
    public String getPasswordRequiredText(){
        return webElementHelper.findElement("passwordFieldRequired").getText();
    }

}
