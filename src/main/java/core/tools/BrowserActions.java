package core.tools;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions(WebDriver driver){
        this.driver = driver;
    }
    public void launchUrl(String url){
        driver.get(url);
    }
    public void quitBrowser(){
        driver.quit();
    }
}
