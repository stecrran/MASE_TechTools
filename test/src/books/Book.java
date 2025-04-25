package books;

public class Book implements Comparable<Book> {
    public String title;
    public String author;
    public int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Book book){
        return this.publicationYear - book.publicationYear;
    }

    @Override
    public String toString() {
        return publicationYear + "\t" + title + "\t" + author;
    }
}
