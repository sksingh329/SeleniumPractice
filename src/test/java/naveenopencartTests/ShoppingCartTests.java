package naveenopencartTests;

import app.naveenopencart.flows.ShoppingCartFlow;
import app.orangehrm.flows.LoginFlow;
import core.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class ShoppingCartTests {
    Properties properties;
    String envFilePath = "src/test/resources/env_naveen_opencart.properties";
    ShoppingCartFlow shoppingCartFlow;
    @BeforeClass
    public void getEnv(){
        properties = ConfigReader.getProperties(envFilePath);
    }
    @BeforeMethod
    public void setup(){
        shoppingCartFlow = new ShoppingCartFlow(properties);
    }
    @AfterMethod
    public void tearDown(){
        shoppingCartFlow.getBrowserActions().quitBrowser();
    }

    @Test
    public void cartIsEmptyForGuestUserTest(){

    }
}
