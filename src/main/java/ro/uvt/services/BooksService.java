package ro.uvt.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ro.uvt.models.Book;
import ro.uvt.persistence.CrudRepository;

import java.util.List;

@Service
public class BooksService {
    private final CrudRepository<Book, Long> booksRepository;

    public BooksService(CrudRepository<Book, Long> booksRepository) {
        this.booksRepository = booksRepository;
    }

    
    @PostConstruct
    public void initData() {
        if (booksRepository.findAll().isEmpty()) {
            booksRepository.save(new Book("Poezii"));
            booksRepository.save(new Book("Baltagul"));
            booksRepository.save(new Book("Ion"));
        }
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Book getBookById(String id) {
        Long bookId = Long.parseLong(id);
        return booksRepository.findById(bookId).orElse(null);
    }

    public Book createBook(Book book) {
        return booksRepository.save(book);
    }

    public Book updateBook(String id, Book book) {
        Long bookId = Long.parseLong(id);
        return booksRepository.findById(bookId)
                .map(existingBook -> {
                    existingBook.setTitle(book.getTitle());
                    existingBook.setAuthors(book.getAuthors());
                    existingBook.setElements(book.getElements());
                    return booksRepository.save(existingBook);
                })
                .orElseGet(() -> {
                    book.setId(bookId);
                    return booksRepository.save(book);
                });
    }

    public void deleteBook(String id) {
        Long bookId = Long.parseLong(id);
        if (booksRepository.existsById(bookId)) {
            booksRepository.deleteById(bookId);
        }
    }
}