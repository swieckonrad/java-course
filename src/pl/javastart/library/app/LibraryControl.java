package pl.javastart.library.app;

import pl.javastart.library.exception.NoSuchOptionException;
import pl.javastart.library.io.ConsolePrinter;
import pl.javastart.library.io.DataReader;
import pl.javastart.library.model.Book;
import pl.javastart.library.model.Library;
import pl.javastart.library.model.Magazine;
import pl.javastart.library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library = new Library();

    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("Wybierz opcję od 0 do 2!");
            }
        } while (option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzono wartość, która nie jest liczbą. Podaj liczbę");
            }
        }
        return option;
    }

    private void exit() {
        printer.printLine("Koniec programu, papa!");
        dataReader.close();
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printMagazines(publications);
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nie utworzono książki. Dane niepoprawne");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Nie dodano ksiązki. Osiągnięto limit pojemności");
        }
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Nie utworzono magazynu. Dane niepoprawne");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Nie dodano magazynu. Osiągnięto limit pojemności");
        }

    }

    private void printOptions() {
        printer.printLine("Wybierz opcję:");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private enum Option {
        EXIT(0,  "Wyjście z programu"),
        ADD_BOOK(1,  "Dodanie nowej książki"),
        ADD_MAGAZINE(2,  "Dodanie nowego magazynu"),
        PRINT_BOOKS(3,  "Wyświetl dostępne książki"),
        PRINT_MAGAZINES(4,  "Wyświetl dostępne magazyny");

        private final int value;
        private final String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id: " + option);
            }
        }
    }
}
