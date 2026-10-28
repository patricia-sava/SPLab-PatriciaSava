package ro.uvt.models;
import ro.uvt.services.Visitor;

public class Table implements Element {
    private String something;

    public Table(String something) {
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