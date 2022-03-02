package pl.javastart.library.model;

public class Library {
    private static final int MAX_PUBLICATIONS = 200;
    private int publicationsNumber = 0;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        for (int i = 0; i < result.length; i++) {
            result[i] = publications[i];
        }
        return publications;
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    private void addPublication(Publication publication) {
        if (publicationsNumber >= MAX_PUBLICATIONS){
            throw new ArrayIndexOutOfBoundsException("Max publications exceeded");
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }
}
