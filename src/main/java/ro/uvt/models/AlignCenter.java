package ro.uvt.models;
import ro.uvt.services.Visitor;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(String text) {
        int MAX_LENGTH = 30;
        if (text.length() >= MAX_LENGTH) {
            System.out.println(text);
            return;
        }

        int totalPadding = MAX_LENGTH - text.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < leftPadding; i++) {
            sb.append(" ");
        }

        sb.append(text);

        for (int i = 0; i < rightPadding; i++) {
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}