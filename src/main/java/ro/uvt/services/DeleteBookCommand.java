package ro.uvt.services;

public class DeleteBookCommand implements Command<Void> {
    private final BooksService booksService;
    private final String id;

    public DeleteBookCommand(BooksService booksService, String id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Void execute() {
        booksService.deleteBook(id);
        return null;
    }
}