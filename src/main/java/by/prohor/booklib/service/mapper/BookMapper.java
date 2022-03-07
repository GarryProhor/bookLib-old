package by.prohor.booklib.service.mapper;

import by.prohor.booklib.external.openlibrary.model.BookOpenLibrary;
import by.prohor.booklib.service.dto.BookDTO;
import by.prohor.booklib.entity.Book;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromDTO (BookDTO bookDTO, @MappingTarget Book book);

    BookDTO bookToBookDTO (Book book);

    Book bookDTOtoBook (BookDTO bookDTO);

    BookOpenLibrary bookToBookOpenLibrary (Book book);

}
