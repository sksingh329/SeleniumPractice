package core.tools;

import com.fasterxml.jackson.databind.JsonNode;
import core.utils.ReadJsonFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementHelper {
    private WebDriver driver;

    public WebElementHelper(WebDriver driver){
        this.driver = driver;
    }
    public static void findElement(String oRName, String objectName) {
        // Logic to retrieve WebElement based on objectName
        JsonNode rootNode = ReadJsonFile.getRootJsonNode(oRName);
        JsonNode usernameNode = rootNode.get(objectName);
        String type = usernameNode.get("type").asText();
        System.out.println(type);
        //return driver.findElement(By.id(objectName));
    }

    public static void main(String[] args) {
        findElement("LoginPage.json","userName");
    }
}
