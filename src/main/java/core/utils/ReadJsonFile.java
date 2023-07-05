package core.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadJsonFile {
    private String jsonFilePath;
    private String basePath = "src/main/resources/OR/orangeHrm/"; //TODO - Build this path from config.properties
    private ObjectMapper objectMapper;

    public ReadJsonFile(String jsonFileName){
        this.jsonFilePath = basePath+jsonFileName;
        objectMapper = new ObjectMapper();
    }
    public JsonNode getRootJsonNode(){
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
