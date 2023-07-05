package core.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonReaderExample {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "src/main/java/core/utils/data.json";
        try {
            // Read JSON from file
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Access the fields of "username"
            JsonNode usernameNode = rootNode.get("userName");
            String type = usernameNode.get("type").asText();
            String locateBy = usernameNode.get("locateBy").asText();
            String name = usernameNode.get("name").asText();

            // Use the values as needed
            System.out.println("Type: " + type);
            System.out.println("Locate By: " + locateBy);
            System.out.println("Name: " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
