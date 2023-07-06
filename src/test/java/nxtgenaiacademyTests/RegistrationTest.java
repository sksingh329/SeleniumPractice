package nxtgenaiacademyTests;

import app.nxtgenaiacademy.flows.RegistrationFlow;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    private String browserName = "chrome";
    private String appUrl = "https://nxtgenaiacademy.com/demo-site/";

    private RegistrationFlow registrationFlow;

    @BeforeMethod
    public void setup(){
        registrationFlow = new RegistrationFlow(browserName,appUrl);
    }
    @AfterMethod
    public void tearDown(){
        registrationFlow.quitBrowser();
    }
    @Test
    public void errorMessageCountTest(){
        System.out.println(registrationFlow.getTitle());
        Assert.assertEquals(registrationFlow.getErrorCountAfterSubmit(),5);
    }
}
