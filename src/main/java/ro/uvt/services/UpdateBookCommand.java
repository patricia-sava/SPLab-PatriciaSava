package ro.uvt.services;

import ro.uvt.models.Book;

public class UpdateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final String id;
    private final Book book;

    public UpdateBookCommand(BooksService booksService, String id, Book book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.updateBook(id, book);
    }
}