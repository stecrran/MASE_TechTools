package books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookSortingExercise {

    public static void main(String[] args) {
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("1984", "George Orwell", 1949);
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", 1813);
        Book book5 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);

        List<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        System.out.println("Compare Publication Year:");
        Collections.sort(books);

        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("Compare Title:");
        Collections.sort(books, new TitleComparator());

        for (Book book : books) {
            System.out.println(book);

        }

        System.out.println("Compare Author:");
        Collections.sort(books, new AuthorComparator());

        for (Book book : books) {
            System.out.println(book);

        }
    }
}
