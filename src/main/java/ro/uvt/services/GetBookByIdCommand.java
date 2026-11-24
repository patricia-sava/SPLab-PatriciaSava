package ro.uvt.services;

import ro.uvt.models.Book;

public class GetBookByIdCommand implements Command<Book> {
    private final BooksService booksService;
    private final String id;

    public GetBookByIdCommand(BooksService booksService, String id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Book execute() {
        return booksService.getBookById(id);
    }
}