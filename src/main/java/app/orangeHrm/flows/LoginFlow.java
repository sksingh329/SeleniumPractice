package app.orangeHrm.flows;

import app.orangeHrm.pages.DashboardPage;
import app.orangeHrm.pages.LoginPage;
import core.tools.BrowserActions;
import core.tools.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginFlow {
    private WebDriver driver;
    private Properties envProperties;
    private BrowserActions browserActions;
    private LoginPage loginPage;
    public LoginFlow(Properties properties){
        envProperties = properties;
        this.driver = DriverFactory.newDriver(envProperties.getProperty("browserName"));
        browserActions = new BrowserActions(driver);
        browserActions.launchUrl(envProperties.getProperty("appUrl"));
        loginPage = new LoginPage(driver,envProperties);
    }
    public BrowserActions getBrowserActions(){
        return browserActions;
    }
    public String performValidLogin(String userName, String password){
        DashboardPage dashboardPage = loginPage.loginAs(userName,password);
        return dashboardPage.getDashboardTitle();
    }
    public void performInValidLogin(String userName, String password){
        loginPage.loginWithInvalidCredentials(userName,password);
    }
    public String getInvalidCredentialText(){
        return loginPage.getInvalidCredentialsText();
    }
    public String getUserNameFieldRequiredText(){
        return loginPage.getUserNameRequiredText();
    }
    public String getPasswordFieldRequiredText(){
        return loginPage.getPasswordRequiredText();
    }
}
