package core.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadJsonFile {
    private static String basePath = "src/main/resources/OR/orangeHrm/"; //TODO - Build this path from config.properties
    private ObjectMapper objectMapper;

    public static JsonNode getRootJsonNode(String jsonFileName){
        String jsonFilePath = basePath+jsonFileName;
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
             rootNode = objectMapper.readTree(new File(jsonFilePath));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return rootNode;
    }
}
