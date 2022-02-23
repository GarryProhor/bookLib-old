package by.prohor.booklib.external.openlibrary.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class IsbnFromOpenLibrary {

    public static List<String> findIsbn (String json) {
        List<String> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode docs = jsonNode.path("docs");
            for(JsonNode docsNode : docs){
                JsonNode isbns = docsNode.path("isbn");
                for(JsonNode isbnNode : isbns){
                    list.add(isbnNode.textValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
