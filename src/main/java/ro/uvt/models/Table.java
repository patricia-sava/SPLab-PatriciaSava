package ro.uvt.models;

import jakarta.persistence.Entity;
import ro.uvt.services.Visitor;

@Entity
@jakarta.persistence.Table(name = "book_tables")
public class Table extends BaseElement {
    private String something;

    public Table() {
    }

    public Table(String something) {
        this.something = something;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("Table: " + something);
    }

    @Override public void add(Element element) {}
    @Override public void remove(Element element) {}
    @Override public Element get(int index) { return null; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }
}