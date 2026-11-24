package ro.uvt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import ro.uvt.services.Visitor;

@Entity
public class Paragraph extends BaseElement {
    private String text;

    @Transient
    private AlignStrategy alignStrategy;

    public Paragraph() {
    }

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(text);
        } else {
            System.out.println(text);
        }
    }

    @Override
    public void add(Element element) {
        // Un paragraf nu poate contine alte elemente
    }

    @Override
    public void remove(Element element) {
    }

    @Override
    public Element get(int index) {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }
}