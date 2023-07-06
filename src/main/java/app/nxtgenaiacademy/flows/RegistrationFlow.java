package app.nxtgenaiacademy.flows;

import app.nxtgenaiacademy.pages.RegistrationPage;
import core.tools.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

public class RegistrationFlow {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    public RegistrationFlow(String browserName,String appUrl){
        driver = DriverFactory.newDriver(browserName);
        driver.get(appUrl);
    }
    private void setRegistrationPage(){
        registrationPage = new RegistrationPage(driver);
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public void quitBrowser(){
        driver.quit();
    }
    public int getErrorCountAfterSubmit(){
        setRegistrationPage();
        registrationPage.clickSubmit();
        return registrationPage.errorCountAfterSubmit();
    }
}
