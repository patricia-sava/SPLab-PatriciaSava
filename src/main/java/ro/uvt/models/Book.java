package ro.uvt.models;

import java.util.ArrayList;
import java.util.List;
import ro.uvt.services.Visitor;

public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        elements.add(element);
    }

    public void print() {
        System.out.println("Book Title: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println("\nContent:");
        for (Element element : elements) {
            element.print();
        }
    }

    public void accept(Visitor visitor) {
        visitor.visitBook(this);
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}