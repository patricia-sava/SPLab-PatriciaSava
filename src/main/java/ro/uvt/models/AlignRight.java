package ro.uvt.models;
import ro.uvt.services.Visitor;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(String text) {
        int MAX_LENGTH = 30;
        if (text.length() >= MAX_LENGTH) {
            System.out.println(text);
            return;
        }

        int padding = MAX_LENGTH - text.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < padding; i++) {
            sb.append(" ");
        }

        sb.append(text);

        System.out.println(sb.toString());
    }
}