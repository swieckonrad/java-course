package pl.javastart.library.io;

import pl.javastart.library.model.Book;
import pl.javastart.library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);

    public Book readAndCreateBook() {
        System.out.println("Podaj tytuł:");
        String title = sc.nextLine();
        System.out.println("Podaj autora:");
        String author = sc.nextLine();
        System.out.println("Podaj wydawnictwo:");
        String publisher = sc.nextLine();
        System.out.println("Podaj ISBN:");
        String isbn = sc.nextLine();
        System.out.println("Podaj rok wydania:");
        int year = getInt();
        System.out.println("Podaj ilość stron:");
        int pages = getInt();
        return new Book(title, author, year, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Podaj tytuł:");
        String title = sc.nextLine();
        System.out.println("Wydawnictwo:");
        String publisher = sc.nextLine();
        System.out.println("Podaj język:");
        String language = sc.nextLine();
        System.out.println("Podaj rok wydania:");
        int year = getInt();
        System.out.println("Podaj miesiac wydania:");
        int month = getInt();
        System.out.println("Podaj dzien wydania:");
        int day = getInt();
        return new Magazine(title, publisher, language, year, day, month);
    }

    public int getInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    public void close() {
        sc.close();
    }
}
