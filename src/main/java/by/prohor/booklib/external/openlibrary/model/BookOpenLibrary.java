package by.prohor.booklib.external.openlibrary.model;



public class BookOpenLibrary {

    private String isbn;
    private String name;
    private String author;
    private int page;



    public BookOpenLibrary() {
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



}