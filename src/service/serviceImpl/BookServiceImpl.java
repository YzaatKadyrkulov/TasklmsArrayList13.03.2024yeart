package service.serviceImpl;

import models.Book;
import models.Database;
import models.Library;
import service.BookService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> saveBook(Long libraryId, Book book) {
        Database.books.add(book);
        return Database.books;
    }


    @Override
    public List<Book> getAllBooks() {
        return Database.books;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                for (Book book : Database.books) {
                    if (book.getId() == bookId) {
                        return book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                for (Book book : Database.books) {
                    if (book.getId() == bookId) {
                        Database.books.remove(book);
                        return "A book was deleted.";
                    }
                }
            }
        }
        return null;
    }


    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        Iterator<Library> iterator = Database.libraries.iterator();
        while (iterator.hasNext()) {
            Library library = iterator.next();
            if (library.getId().equals(libraryId)) {
                iterator.remove();
                System.out.println("Successfully deleted");
            } else {
                System.out.println("Not removed.");
            }
        }
    }
}