package by.bsu.booksearchsoap.entity;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Class-bean representing author in the system<br/>
 * @author Anna Buklis
 */

@XmlRootElement(name = "author")
@XmlType(propOrder = {
        "authorId",
        "fullName",
        "birthYear",
        "birthCountry",
        "biography"})
public class Author {
    private long authorId;
    private String fullName;
    private int birthYear;
    private String birthCountry;
    private String biography;

    public Author() {
    }

    public Author(long authorId, String fullName, int birthYear, String birthCountry, String biography) {
        this.authorId = authorId;
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.birthCountry = birthCountry;
        this.biography = biography;
    }

    public long getAuthorId() {
        return authorId;
    }

    @XmlElement
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getBiography() {
        return biography;
    }

    @XmlElement
    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    @XmlElement
    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getFullName() {
        return fullName;
    }

    @XmlElement
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlElement
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", fullName='" + fullName + '\'' +
                ", birthYear=" + birthYear +
                ", birthCountry='" + birthCountry + '\'' +
                ", biography='" + biography + '}';
    }
}
