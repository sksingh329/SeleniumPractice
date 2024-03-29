package core.tools;

import com.fasterxml.jackson.databind.JsonNode;
import core.utils.ReadJsonFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class WebElementHelper {
    private final WebDriver driver;
    private JsonNode elementNode;
    private final JsonNode rootNode;

    public WebElementHelper(WebDriver driver, Properties envProperties, String pageObjectRepositoryName){
        this.driver = driver;
        String objectRepositoryFilePath = envProperties.getProperty("objectRepositoryBasePath") + envProperties.getProperty("appObjectRepositoryDirName") + pageObjectRepositoryName;
        rootNode= ReadJsonFile.getRootJsonNode(objectRepositoryFilePath);
    }
    public By getLocator(String objectName){
        By locator = null;
        elementNode = rootNode.get(objectName);
        String locateBy = elementNode.get("locateBy").asText().toLowerCase(Locale.ROOT);
        String locatorValue = elementNode.get(locateBy).asText();

        switch (locateBy){
            case "id":
                locator = By.id(locatorValue);
                break;
            case "name":
                locator = By.name(locatorValue);
                break;
            case "xpath":
                locator = By.xpath(locatorValue);
                break;
            default:
                //TODO - Replace with exception handler
                System.out.println("Invalid Locator");
        }
        return locator;
    }
    public WebElement findElement(String objectName) {
        // Logic to retrieve WebElement based on objectName
        By locator = getLocator(objectName);

        if(elementNode.has("explicitWait") && elementNode.get("explicitWait").asBoolean()){
            int duration = elementNode.get("explicitWaitMaxDurationInSeconds").asInt();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));

            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        else{
            return driver.findElement(locator);
        }
    }
}
