package de.example.library;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    private Member member(int memberId) {
        return this.members.stream()
                .filter(m -> m.getMemberId() == memberId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }

    private Book book(String bookTitle) {
        return this.books.stream()
                .filter(b -> b.getTitle().equals(bookTitle))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    // Ein Buch an ein Mitglied ausleihen.
    public void borrowBook(int memberId, String bookTitle) {
        Member member = member(memberId);
        Book book = book(bookTitle);
        member.borrowBook(book);
    }

    public List<String> listOfAllAuthorsWithoutDuplicates() {
        return this.books.stream()
                .map(Book::getAuthor)
                .distinct()
                .toList();
    }

    public double averageYearofPublicationOfTheBooks() {
        return this.books.stream()
                .mapToInt(Book::getPublicationYear)
                .average()
                .getAsDouble();
    }

    public void ListOfAllBorrowedBooks() {
        this.members.stream()
                .flatMap(member -> member.getBorrowedBooks().stream())
                .forEach(System.out::println);
    }

    public void allBooksOfSpecificGenre(Genre genre) {
        this.books.stream()
                .filter(book -> book.getGenre() == genre)
                .forEachOrdered(System.out::println);
    }

    public void borrowedBooksFromMember(int memberId) {
        Member member = member(memberId);
        member.getBorrowedBooks()
                .forEach(System.out::println);
    }

    public void borrowedBookBack(int memberId, String bookTitle) {
        Member member = member(memberId);
        Book book = book(bookTitle);
        member.borrowBookBack(book);
    }

    public void topFiveBorrowedBooks() {
        members.stream()
                .flatMap(member -> member.getBorrowedBooks().stream())
                .collect(Collectors.toMap(b -> b, e -> 1, Integer::sum))
                .entrySet().stream()
                .sorted(Map.Entry.<Book, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(System.out::println);
    }

    public void categoryTheBooks() {
        books.stream()
                .collect(Collectors.groupingBy(Book::getGenre))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }
}
