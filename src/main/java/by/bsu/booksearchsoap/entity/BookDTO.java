package by.bsu.booksearchsoap.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by anyab on 27.09.2017.
 */
@XmlRootElement(name = "bookDTO")
@XmlType(propOrder = {
        "bookId",
        "title",
        "publishingYear",
        "description",
        "genre",
        "authorId"})
public class BookDTO {
    private long bookId;
    private String title;
    private int publishingYear;
    private String description;
    private String genre;
    private long authorId;

    public BookDTO() {
    }

    public BookDTO(long bookId, String title, int publishingYear, String description, String genre, long authorId) {
        this.bookId = bookId;
        this.title = title;
        this.publishingYear = publishingYear;
        this.description = description;
        this.genre = genre;
        this.authorId = authorId;
    }

    public long getBookId() {
        return bookId;
    }

    @XmlElement
    public void setBookId(long bookId) {
        this.bookId = bookId;
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


    public long getAuthorId() {
        return authorId;
    }

    @XmlElement
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", publishingYear=" + publishingYear +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
