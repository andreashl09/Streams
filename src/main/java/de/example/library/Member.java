package de.example.library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks;

    // Konstruktoren, Getter und Setter

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void borrowBook(Book book){
        this.borrowedBooks.add(book);

    }  public void borrowBookBack(Book book){
        this.borrowedBooks.remove(book);
    }
}