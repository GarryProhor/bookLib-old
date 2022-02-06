package by.prohor.booklib.mappers.book;

import by.prohor.booklib.entity.Book;
import by.prohor.booklib.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    //BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book bookEntityToBook(BookEntity bookEntity);

    BookEntity bookToBookEntity(Book book);


}
