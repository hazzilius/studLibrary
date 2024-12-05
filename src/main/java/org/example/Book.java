package org.example;

public class Book {
    private String author;
    private String title;
    private String publisher;
    private int year;
    private String section;

    public Book() {
    }

    public Book(String author, String title, String publisher, int year, String section) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.section = section;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String toString() {
        return "Автор: " + author + "\n" +
                "Название: " + title + "\n" +
                "Издательство: " + publisher + "\n" +
                "Год издания: " + year + "\n" +
                "Раздел библиотеки: " + section + "\n";
    }
}
