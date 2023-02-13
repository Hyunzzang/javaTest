package com.zzang.test.design.currying;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Function;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Book {
    private final Genre genre;
    private final String author;
    private final String title;
    private final LocalDate publicationDate;

    public enum Genre {
        FANTASY,
        HORROR,
        SCIFI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(author, book.author)
               && Objects.equals(genre, book.genre)
               && Objects.equals(title, book.title)
               && Objects.equals(publicationDate, book.publicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, genre, title, publicationDate);
    }

    @Override
    public String toString() {
        return "Book{" + "genre=" + genre + ", author='" + author + '\''
               + ", title='" + title + '\'' + ", publicationDate=" + publicationDate + '}';
    }

    /**
     * Curried book builder/creator function.
     */
    static Function<Genre, Function<String, Function<String, Function<LocalDate, Book>>>> book_creator
            = bookGenre
            -> bookAuthor
            -> bookTitle
            -> bookPublicationDate
            -> new Book(bookGenre, bookAuthor, bookTitle, bookPublicationDate);

    /**
     * Implements the builder pattern using functional interfaces to create a more readable book
     * creator function. This function is equivalent to the BOOK_CREATOR function.
     */
    public static AddGenre builder() {
        return genre
                -> author
                -> title
                -> publicationDate
                -> new Book(genre, author, title, publicationDate);
    }

    /**
     * Functional interface which adds the genre to a book.
     */
    public interface AddGenre {
        Book.AddAuthor withGenre(Genre genre);
    }

    /**
     * Functional interface which adds the author to a book.
     */
    public interface AddAuthor {
        Book.AddTitle withAuthor(String author);
    }

    /**
     * Functional interface which adds the title to a book.
     */
    public interface AddTitle {
        Book.AddPublicationDate withTitle(String title);
    }

    /**
     * Functional interface which adds the publication date to a book.
     */
    public interface AddPublicationDate {
        Book withPublicationDate(LocalDate publicationDate);
    }
}
