
package service;

import models.Book;
import models.Database;

import java.util.List;

public interface BookService {
    List<Book> saveBook(Long libraryId, Book book);

    List<Book> getAllBooks();

    Book getBookById(Long libraryId, Long bookId);

    String deleteBook(Long libraryId,Long bookId);

    void clearBooksByLibraryId(Long libraryId);
}
