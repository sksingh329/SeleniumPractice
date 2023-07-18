package app.naveenopencart.flows;

import core.tools.BrowserActions;
import core.tools.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ShoppingCartFlow {
    private final BrowserActions browserActions;

    public ShoppingCartFlow(Properties properties){
        WebDriver driver = DriverFactory.newDriver(properties.getProperty("browserName"));
        browserActions = new BrowserActions(driver);
        browserActions.launchUrl(properties.getProperty("appUrl"));
    }
    public BrowserActions getBrowserActions(){
        return browserActions;
    }
}
