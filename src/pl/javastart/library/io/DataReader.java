package pl.javastart.library.io;

import pl.javastart.library.model.Book;
import pl.javastart.library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public Book readAndCreateBook() {
        printer.printLine("Podaj tytuł:");
        String title = sc.nextLine();
        printer.printLine("Podaj autora:");
        String author = sc.nextLine();
        printer.printLine("Podaj wydawnictwo:");
        String publisher = sc.nextLine();
        printer.printLine("Podaj ISBN:");
        String isbn = sc.nextLine();
        printer.printLine("Podaj rok wydania:");
        int year = getInt();
        System.out.println("Podaj ilość stron:");
        int pages = getInt();
        return new Book(title, author, year, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        printer.printLine("Podaj tytuł:");
        String title = sc.nextLine();
        printer.printLine("Wydawnictwo:");
        String publisher = sc.nextLine();
        printer.printLine("Podaj język:");
        String language = sc.nextLine();
        printer.printLine("Podaj rok wydania:");
        int year = getInt();
        printer.printLine("Podaj miesiac wydania:");
        int month = getInt();
        printer.printLine("Podaj dzien wydania:");
        int day = getInt();
        return new Magazine(title, publisher, language, year, day, month);
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    public void close() {
        sc.close();
    }
}
