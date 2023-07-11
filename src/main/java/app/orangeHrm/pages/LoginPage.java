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
    public LoginPage typeUserName(String userName){
        webElementHelper.findElement("userName").sendKeys(userName);
        return this;
    }
    public LoginPage typePassword(String password){
        webElementHelper.findElement("password").sendKeys(password);
        return this;
    }
    public DashboardPage submitLogin(){
        webElementHelper.findElement("login").click();
        return new DashboardPage(driver,envProperties);
    }
    public String getInvalidCredentialsText(){
        return webElementHelper.findElement("invalidCredential").getText();
    }
    public DashboardPage loginAs(String userName, String password){
        typeUserName(userName);
        typePassword(password);
        return submitLogin();
    }
    public LoginPage loginExpectedFailure(String userName, String password){
        typeUserName(userName);
        typePassword(password);
        webElementHelper.findElement("login").click();
        return this;
    }
}
