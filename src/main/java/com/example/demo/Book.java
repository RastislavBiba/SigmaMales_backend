package com.example.demo;

public class Book {
    private Long id;
    private String name;
    private String isbn;
    private String authorFirstName;
    private String getAuthorSecondName;
    private int bookCount;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getGetAuthorSecondName() {
        return getAuthorSecondName;
    }

    public void setGetAuthorSecondName(String getAuthorSecondName) {
        this.getAuthorSecondName = getAuthorSecondName;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    //old
    private String Author;
    private String title;

}