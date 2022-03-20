package by.prohor.booklib.external.openlibrary.util;

import by.prohor.booklib.entity.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookFromOpenLibrary {
    public static Book findBook(String json , String isbn){
        Book bookEntity = new Book();
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
