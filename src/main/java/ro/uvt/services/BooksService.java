package ro.uvt.services;

import org.springframework.stereotype.Service;
import ro.uvt.models.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {
    private final List<Book> books = new ArrayList<>();


    public BooksService() {
        books.add(new Book("Poezii"));
        books.add(new Book("Baltagul"));
        books.add(new Book("Ion"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(String id) {
        return books.stream().findFirst().orElse(null);
    }

    public Book createBook(Book book) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        books.add(book);
        return book;
    }

    public Book updateBook(String id, Book book) {
        return book;
    }

    public void deleteBook(String id) {
        // Logica de ștergere
    }
}