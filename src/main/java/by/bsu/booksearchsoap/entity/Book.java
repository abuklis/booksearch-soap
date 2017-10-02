package by.bsu.booksearchsoap.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by anyab on 25.09.2017.
 */
@XmlRootElement(name = "book")
@XmlType(propOrder = {
        "bookId",
        "author",
        "title",
        "publishingYear",
        "description",
        "genre"})
public class Book {
    private long bookId;
    private Author author;
    private String title;
    private int publishingYear;
    private String description;
    private String genre;

    public Book() {
    }

    public Book(Author author, String title, int publishingYear, String description, String genre) {
        this.author = author;
        this.title = title;
        this.publishingYear = publishingYear;
        this.description = description;
        this.genre = genre;
    }

    public Book(long bookId, Author author, String title, int publishingYear, String description, String genre) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.publishingYear = publishingYear;
        this.description = description;
        this.genre = genre;
    }

    public Book(long bookId, String title, int publishingYear, String description, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.publishingYear = publishingYear;
        this.description = description;
        this.genre = genre;
    }

    public Book(long bookId, long authorId, int publishingYear, String description, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.publishingYear = publishingYear;
        this.description = description;
        this.genre = genre;
    }

    public long getBookId() {
        return bookId;
    }

    @XmlElement
    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Author getAuthor() {
        return author;
    }

    @XmlElement
    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    @XmlElement
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    @XmlElement
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", publishingYear=" + publishingYear +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
