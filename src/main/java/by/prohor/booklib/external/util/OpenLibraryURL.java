package by.prohor.booklib.external.util;

public abstract class OpenLibraryURL {

    protected static String URL_BASE = "http://openlibrary.org";
    protected static String URL_AUTHORNAME = "/search.json?author={authorName}";
    protected static String URL_ISBN = "/api/books?bibkeys=ISBN:{isbn}&jscmd=data&format=json";

    //длина isbn
    protected static int lengthIsbn = 13;
}
