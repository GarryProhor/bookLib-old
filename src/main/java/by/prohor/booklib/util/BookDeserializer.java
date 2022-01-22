package by.prohor.booklib.util;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;


public class BookDeserializer extends StdDeserializer<BookEntity> {
    protected BookDeserializer(Class<?> vc) {
        super(vc);
    }

    protected BookDeserializer(JavaType valueType) {
        super(valueType);
    }

    protected BookDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public BookEntity deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);

        String isbn = node.get("isbn").asText();
        String name = node.get("name").asText();
        String author = node.get("author").asText();
        int page = node.get("page").asInt();
        double weight = node.get("weight").asDouble();
        double price = node.get("price").asDouble();
        return new BookEntity(isbn, name, author, page, weight, price);
    }
}
