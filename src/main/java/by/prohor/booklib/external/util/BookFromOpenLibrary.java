package by.prohor.booklib.external.util;

import by.prohor.booklib.entity.BookEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookFromOpenLibrary {
    public static BookEntity findBook(String json , String isbn){
        BookEntity bookEntity = new BookEntity();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode isbnNode = jsonNode.path("ISBN:" + isbn);
            String title = isbnNode.path("title").asText();

            bookEntity.setName(title);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return bookEntity;
    }

}
