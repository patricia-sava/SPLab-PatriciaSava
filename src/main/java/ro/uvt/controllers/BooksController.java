package ro.uvt.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.models.Book;
import ro.uvt.services.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final CommandExecutor syncExecutor;
    private final CommandExecutor asyncExecutor;

    public BooksController(BooksService booksService,
                           @Qualifier("syncExecutor") CommandExecutor syncExecutor,
                           @Qualifier("asyncExecutor") CommandExecutor asyncExecutor) {
        this.booksService = booksService;
        this.syncExecutor = syncExecutor;
        this.asyncExecutor = asyncExecutor;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return syncExecutor.executeCommand(new GetAllBooksCommand(booksService));
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return syncExecutor.executeCommand(new GetBookByIdCommand(booksService, id));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = syncExecutor.executeCommand(new CreateBookCommand(booksService, book));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return syncExecutor.executeCommand(new UpdateBookCommand(booksService, id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        syncExecutor.executeCommand(new DeleteBookCommand(booksService, id));
        return ResponseEntity.noContent().build();
    }
}