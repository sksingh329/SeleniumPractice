package app.orangeHrm.pages;

import core.tools.WebElementHelper;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPage {
    private final String pageObjectRepositoryName = "LoginPage.json";
    private WebElementHelper webElementHelper;
    private Properties envProperties;
    private WebDriver driver;
    public LoginPage(WebDriver driver, Properties envProperties){
        this.driver = driver;
        this.envProperties = envProperties;
        webElementHelper = new WebElementHelper(driver,envProperties,pageObjectRepositoryName);
    }
    private void typeUserName(String userName){
        webElementHelper.findElement("userName").sendKeys(userName);
    }
    private void typePassword(String password){
        webElementHelper.findElement("password").sendKeys(password);
    }
    private void submitLogin(){
        webElementHelper.findElement("login").click();
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
    public DashboardPage loginAs(String userName, String password){
        typeUserName(userName);
        typePassword(password);
        submitLogin();
        return new DashboardPage(driver,envProperties);
    }
    public LoginPage loginWithInvalidCredentials(String userName, String password){
        typeUserName(userName);
        typePassword(password);
        submitLogin();
        return this;
    }
}
