package com.zzang.test.design.currying;

import java.time.LocalDate;

import com.zzang.test.design.currying.Book.Genre;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        log.info("Librarian begins their work.");

        // Defining genre book functions
        Book.AddAuthor fantasyBookFunc = Book.builder().withGenre(Genre.FANTASY);
        Book.AddAuthor horrorBookFunc = Book.builder().withGenre(Genre.HORROR);
        Book.AddAuthor scifiBookFunc = Book.builder().withGenre(Genre.SCIFI);

        // Defining author book functions
        Book.AddTitle kingFantasyBooksFunc = fantasyBookFunc.withAuthor("Stephen King");
        Book.AddTitle kingHorrorBooksFunc = horrorBookFunc.withAuthor("Stephen King");
        Book.AddTitle rowlingFantasyBooksFunc = fantasyBookFunc.withAuthor("J.K. Rowling");

        // Creates books by Stephen King (horror and fantasy genres)
        Book shining = kingHorrorBooksFunc.withTitle("The Shining")
                .withPublicationDate(LocalDate.of(1977, 1, 28));
        Book darkTower = kingFantasyBooksFunc.withTitle("The Dark Tower: Gunslinger")
                .withPublicationDate(LocalDate.of(1982, 6, 10));

        // Creates fantasy books by J.K. Rowling
        Book chamberOfSecrets = rowlingFantasyBooksFunc.withTitle("Harry Potter and the Chamber of Secrets")
                .withPublicationDate(LocalDate.of(1998, 7, 2));

        // Create sci-fi books
        Book dune = scifiBookFunc.withAuthor("Frank Herbert")
                .withTitle("Dune")
                .withPublicationDate(LocalDate.of(1965, 8, 1));
        Book foundation = scifiBookFunc.withAuthor("Isaac Asimov")
                .withTitle("Foundation")
                .withPublicationDate(LocalDate.of(1942, 5, 1));

        log.info("Stephen King Books:");
        log.info(shining.toString());
        log.info(darkTower.toString());

        log.info("J.K. Rowling Books:");
        log.info(chamberOfSecrets.toString());

        log.info("Sci-fi Books:");
        log.info(dune.toString());
        log.info(foundation.toString());
    }
}
