package orangeHrmTests;

import app.orangeHrm.flows.LoginFlow;
import core.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginTests {
    Properties properties;
    String envFilePath = "src/test/resources/env_orange_hrm.properties";
    LoginFlow loginFlow;
    @BeforeClass
    public void getEnv(){
        properties = ConfigReader.getProperties(envFilePath);
    }
    @BeforeMethod
    public void setup(){
        loginFlow = new LoginFlow(properties);
    }
    @AfterMethod
    public void tearDown(){
        loginFlow.getBrowserActions().quitBrowser();
    }
    @Test
    public void testSuccessfulLogin() {
        String expectedDashboardTitle = "Dashboard";
        String actualDashboardTitle = loginFlow.performValidLogin("Admin","admin123");
        Assert.assertEquals(actualDashboardTitle,expectedDashboardTitle);
    }
    @Test
    public void testFailedLoginWithInvalidCredentials(){
        String expectedInvalidCredentialText = "Invalid credentials";
        loginFlow.performInValidLogin("Admin","admin");
        String actualInvalidCredentialText = loginFlow.getInvalidCredentialText();
        Assert.assertEquals(actualInvalidCredentialText,expectedInvalidCredentialText);
    }
    @Test
    public void testFailedLoginWithBlankFields(){
        String expectedRequiredText = "Required";
        loginFlow.performInValidLogin("","");
        String actualUserNameFieldRequiredText = loginFlow.getUserNameFieldRequiredText();
        Assert.assertEquals(actualUserNameFieldRequiredText,expectedRequiredText);
        String actualPasswordFieldRequiredText = loginFlow.getPasswordFieldRequiredText();
        Assert.assertEquals(actualPasswordFieldRequiredText,expectedRequiredText);
    }
}
