package core.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadJsonFile {

    public static JsonNode getRootJsonNode(String jsonFilePath){
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
