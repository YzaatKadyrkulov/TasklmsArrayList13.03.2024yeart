
/**
 * Task of teacher
 * Deadline : 14.03.2024 / 11:00
 * ArrayList task.
 * Models
 * Library(id, name, address, List<Models.Book>books, List<Models.Reader>readers)
 * Models.Book(id, name, author, Genre genre)
 * Models.Reader(id, fullName, email, phoneNumber, Gender gender)
 * Database(List<Library>libraries, List<Models.Book>books,List<Models.Reader>readers)
 *
 *      2. Methods
 * LibraryService
 * List<Library>saveLibrary(List<Library>libraries);
 *
 * List<Library>getAllLibraries();
 *
 * Library getLibraryById(Long id);
 *
 * Library updateLibrary(Long id, Library library);
 *
 * String deleteLibrary(Long id);
 *
 * BookService
 * Models.Book saveBook(Long libraryId,Models.Book book);
 *
 * List<Models.Book>getAllBooks(Long libraryId);
 *
 * Models.Book getBookById(Long libraryId, Long bookId);
 *
 * String deleteBook(Long libraryId,Long bookId);
 *
 * void clearBooksByLibraryId(Long libraryId);
 *
 * ReaderService
 * void saveReader(Models.Reader reader);
 *
 * List<Models.Reader> getAllReaders();
 *
 * Models.Reader getReaderById(Long id);
 *
 * Models.Reader updateReader(Long id, Models.Reader reader);
 *
 * void assignReaderToLibrary(Long readerId,Long libraryId);
 *
 * Бардык методдор Main класска чакырылып, switch case аркылуу ирээттуу турдо консольго чыксын
 */

import enums.Gender;
import enums.Genre;
import models.Book;
import models.Library;
import models.Reader;
import service.LibraryService;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.LibraryServiceImpl;
import service.serviceImpl.ReaderServiceImpl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {


                Scanner scannerString = new Scanner(System.in);
                Scanner scannerLong = new Scanner(System.in);
                Scanner scannerDelete = new Scanner(System.in);

                ReaderServiceImpl readerService = new ReaderServiceImpl();
                BookServiceImpl bookService = new BookServiceImpl();
                LibraryService libraryService = new LibraryServiceImpl();

                Reader reader = new Reader();
                Book book = new Book();
                reader.setId(1L);
                reader.setFullname("Yzaat Kadyrkulov");
                reader.setEmail("yzaatkadyrkulov@7gmail.com");
                reader.setPhoneNumber(12343L);
                reader.setGender(Gender.MALE);

                while (true) {
                    System.out.println("""
                    1. Book
                    2. Library
                    3. Reader
                    """);
                    switch (scannerLong.nextInt()) {
                        case 1 -> {
                            System.out.println("""
                            1. saveBook
                            2. getAllBooks
                            3. getBookById
                            4. deleteBook
                            5. clearBooksByLibraryId
                            """);
                            String choice = scannerString.nextLine();
                            switch (choice) {
                                case "1", "saveBook" -> {
                                    System.out.println("Write book's name: ");
                                    book.setName(scannerString.nextLine());
                                    System.out.println("Write book's id: ");
                                    book.setId(scannerLong.nextLong());
                                    System.out.println("Write author's name: ");
                                    book.setAuthor(scannerString.nextLine());
                                    System.out.println("Write book's genre: " + Arrays.toString(Genre.values()));
                                    book.setGenre(Genre.valueOf(scannerString.nextLine()));
                                    bookService.saveBook(book.getId(), book);

                                }
                                case "2", "getAllBooks" -> {
                                    System.out.println(bookService.getAllBooks());
                                }
                                case "3", "getBookById" -> {
                                    System.out.println("1.Get book by library id and 2.by book id: ");
                                    System.out.println(bookService.getBookById(scannerLong.nextLong(), scannerLong.nextLong()));
                                }
                                case "4", "deleteBook" -> {
                                    System.out.println("1.Get book by library id and 2.by book id: ");
                                    System.out.println(bookService.deleteBook(scannerDelete.nextLong(), scannerDelete.nextLong()));
                                }
                                case "5", "clearBooksByLibraryId" -> {
                                    System.out.println("1.Get book by library id: ");
                                    bookService.clearBooksByLibraryId(scannerLong.nextLong());
                                }
                            }
                        }
                        case 2 -> {
                            while (true) {
                                System.out.println("""
                                1. saveLibrary
                                2. getAllLibraries
                                3. getLibraryById
                                4. updateLibrary
                                5. deleteLibrary
                                6. Exit
                                """);
                                int command = scannerLong.nextInt();
                                switch (command) {
                                    case 1 -> {

                                        Library library = new Library();
                                        System.out.println("Write library of id: ");
                                        library.setId(scannerLong.nextLong());
                                        System.out.println("Write library of name: ");
                                        library.setName(scannerString.nextLine());
                                        System.out.println("Write library of address: ");
                                        library.setAddress(scannerString.nextLine());
                                        System.out.println(libraryService.saveLibrary(library));
                                    }
                                    case 2 -> {
                                        System.out.println(libraryService.getAllLibraries());
                                    }
                                    case 3 -> {
                                        System.out.println("Enter a library by id: ");
                                        System.out.println(libraryService.getLibraryById(scannerLong.nextLong()));
                                    }
                                    case 4 -> {
                                        Library library = new Library();
                                        System.out.println("Write a library id to change on new: ");
                                        long libraryId = scannerLong.nextLong();
                                        System.out.println("Write a new library id: ");
                                        library.setId(scannerLong.nextLong());
                                        System.out.println("Write a library name: ");
                                        library.setName(scannerString.nextLine());
                                        System.out.println("Write a new address: ");
                                        library.setAddress(scannerString.nextLine());
                                        System.out.println(libraryService.updateLibrary(libraryId, library));
                                    }
                                    case 5 -> {
                                        System.out.println("Enter a library id to delete: ");
                                        System.out.println(libraryService.deleteLibrary(scannerLong.nextLong()));
                                    }
                                }
                                if (command == 6) {
                                    break;
                                }
                            }
                        }
                        case 3 -> {
                            while (true) {
                                System.out.println("""
                                1. saveReader
                                2. getAllReaders
                                3. getReaderById
                                4. updateReader
                                5. assignReaderToLibrary
                                6. Exit
                                """);
                                int choice = scannerLong.nextInt();
                                switch (choice) {
                                    case 1 -> {
                                        System.out.println("Write a reader of id: ");
                                        reader.setId(scannerLong.nextLong());
                                        System.out.println("Write a reader of name: ");
                                        reader.setFullname(scannerString.nextLine());
                                        System.out.println("Write a reader of email: ");
                                        reader.setEmail(scannerString.nextLine());
                                        System.out.println("Write a reader of phone number: ");
                                        reader.setPhoneNumber(scannerLong.nextLong());
                                        System.out.println("Write one Gender : MALE/FEMALE");
                                        if (scannerString.nextLine().equalsIgnoreCase("MALE")) {
                                            reader.setGender(Gender.MALE);
                                        } else if (scannerString.nextLine().equalsIgnoreCase("FEMALE")) {
                                            reader.setGender(Gender.FEMALE);
                                        }
                                        readerService.saveReader(reader);
                                    }
                                    case 2 -> {
                                        System.out.println(readerService.getAllReaders());
                                    }
                                    case 3 -> {
                                        System.out.println("Enter a reader by id: ");
                                        System.out.println(readerService.getReaderById(scannerLong.nextLong()));
                                    }
                                    case 4 -> {
                                        System.out.println("Write a reader id to change on new: ");
                                        long readerId = scannerLong.nextLong();
                                        System.out.println("Write a new reader of id : ");
                                        reader.setId(scannerLong.nextLong());
                                        System.out.println("Write a full name of reader: ");
                                        reader.setFullname(scannerString.nextLine());
                                        System.out.println("Write a new email of reader: ");
                                        reader.setEmail(scannerString.nextLine());
                                        System.out.println("Write a new phone of email ");
                                        reader.setPhoneNumber(scannerLong.nextLong());
                                        System.out.println("Write a new gender of gender to change: ");
                                        if (scannerString.nextLine().equalsIgnoreCase("MALE")) {
                                            reader.setGender(Gender.MALE);
                                        } else if (scannerString.nextLine().equalsIgnoreCase("FEMALE")) {
                                            reader.setGender(Gender.FEMALE);
                                        }
                                        System.out.println(readerService.updateReader(readerId, reader));
                                    }
                                    case 5 -> {
                                        System.out.println("1Enter a reader of id and 2a library of id");
                                        readerService.assignReaderToLibrary(scannerLong.nextLong(), scannerLong.nextLong());
                                    }
                                    default -> {
                                        System.out.println("Write correct...");
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

