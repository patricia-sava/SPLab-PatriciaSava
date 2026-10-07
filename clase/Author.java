public class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, String surname) {
        this.name = name + " " + surname;
    }

    public void print() {
        System.out.println("Author: " + name);
    }
}