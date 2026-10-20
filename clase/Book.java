package clase;

import java.util.ArrayList;
import java.util.List;


public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<clase.Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(clase.Element element) {
        elements.add(element);
    }

    public void print() {
        System.out.println("Book Title: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println("\nContent:");
        for (clase.Element element : elements) {
            element.print();
        }
    }
}