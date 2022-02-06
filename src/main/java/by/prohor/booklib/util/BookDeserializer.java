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


public class BookDeserializer extends StdDeserializer<Book> {
    protected BookDeserializer() {
        this (null);
    }

    protected BookDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Book deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);

        String isbn = node.get("isbn").asText();
        String name = node.get("title").asText();
        String author = node.get("author").asText();
        int page = node.get("page").asInt();
        double weight = node.get("weight").asDouble();
        double price = node.get("price").asDouble();
        return new Book(isbn, name, author, page, weight, price);
    }
}
