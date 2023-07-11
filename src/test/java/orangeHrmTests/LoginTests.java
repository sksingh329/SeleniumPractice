package orangeHrmTests;

import app.orangeHrm.flows.LoginFlow;
import core.utils.ConfigReader;
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
        loginFlow.performLogin("Admin","admin123");
    }
    @Test
    public void testInvalidCredentials(){

    }
    @Test
    public void testBlankFields(){

    }
    @Test
    public void testLogout(){

    }
    @Test
    public void testRememberMe(){

    }
}
