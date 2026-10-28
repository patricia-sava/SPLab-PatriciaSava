package ro.uvt;
import ro.uvt.models.*;
import ro.uvt.services.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);

        //fără aliniere
        System.out.println("Printing without Alignment");
        System.out.println();
        cap1.print();

        p1.setAlignStrategy(new AlignCenter());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignLeft());

        //cu aliniere
        System.out.println();
        System.out.println("Printing with Alignment");
        System.out.println();
        cap1.print();



        System.out.println();
        System.out.println("Printing Book Statistics (Visitor)");


        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));

        // Calculăm și afișăm statisticile
        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();
    }
}