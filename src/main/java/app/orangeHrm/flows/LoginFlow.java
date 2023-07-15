package app.orangeHrm.flows;

import app.orangeHrm.pages.DashboardPage;
import app.orangeHrm.pages.LoginPage;
import core.tools.BrowserActions;
import core.tools.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginFlow {
    private final BrowserActions browserActions;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    public LoginFlow(Properties properties){
        WebDriver driver = DriverFactory.newDriver(properties.getProperty("browserName"));
        browserActions = new BrowserActions(driver);
        browserActions.launchUrl(properties.getProperty("appUrl"));
        loginPage = new LoginPage(driver, properties);
    }
    public BrowserActions getBrowserActions(){
        return browserActions;
    }
    public void performValidLogin(String userName, String password){
        loginPage.typeUserName(userName);
        loginPage.typePassword(password);
        dashboardPage = loginPage.submitLogin();
    }
    public void performInValidLogin(String userName, String password){
        loginPage.typeUserName(userName);
        loginPage.typePassword(password);
        this.loginPage = loginPage.submitLoginWhenLoginFailed();
    }
    public String getDashboardHeader(){
        return dashboardPage.getDashboardHeader();
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
