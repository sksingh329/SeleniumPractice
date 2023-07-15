package app.orangeHrm.pages;

import core.tools.WebElementHelper;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class DashboardPage {
    private final WebElementHelper webElementHelper;
    public DashboardPage(WebDriver driver, Properties envProperties){
        String pageObjectRepositoryName = "DashboardPage.json";
        webElementHelper = new WebElementHelper(driver,envProperties, pageObjectRepositoryName);
    }
    public String getDashboardHeader(){
        return webElementHelper.findElement("dashboardTitle").getText();
    }
}
