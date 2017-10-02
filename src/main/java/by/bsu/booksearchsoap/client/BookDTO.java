/**
 * BookDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package by.bsu.booksearchsoap.client;

public class BookDTO  implements java.io.Serializable {
    private long bookId;

    private java.lang.String title;

    private int publishingYear;

    private java.lang.String description;

    private java.lang.String genre;

    private long authorId;

    public BookDTO() {
    }

    public BookDTO(
           long bookId,
           java.lang.String title,
           int publishingYear,
           java.lang.String description,
           java.lang.String genre,
           long authorId) {
           this.bookId = bookId;
           this.title = title;
           this.publishingYear = publishingYear;
           this.description = description;
           this.genre = genre;
           this.authorId = authorId;
    }


    /**
     * Gets the bookId value for this BookDTO.
     * 
     * @return bookId
     */
    public long getBookId() {
        return bookId;
    }


    /**
     * Sets the bookId value for this BookDTO.
     * 
     * @param bookId
     */
    public void setBookId(long bookId) {
        this.bookId = bookId;
    }


    /**
     * Gets the title value for this BookDTO.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this BookDTO.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the publishingYear value for this BookDTO.
     * 
     * @return publishingYear
     */
    public int getPublishingYear() {
        return publishingYear;
    }


    /**
     * Sets the publishingYear value for this BookDTO.
     * 
     * @param publishingYear
     */
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }


    /**
     * Gets the description value for this BookDTO.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this BookDTO.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the genre value for this BookDTO.
     * 
     * @return genre
     */
    public java.lang.String getGenre() {
        return genre;
    }


    /**
     * Sets the genre value for this BookDTO.
     * 
     * @param genre
     */
    public void setGenre(java.lang.String genre) {
        this.genre = genre;
    }


    /**
     * Gets the authorId value for this BookDTO.
     * 
     * @return authorId
     */
    public long getAuthorId() {
        return authorId;
    }


    /**
     * Sets the authorId value for this BookDTO.
     * 
     * @param authorId
     */
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BookDTO)) return false;
        BookDTO other = (BookDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.bookId == other.getBookId() &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            this.publishingYear == other.getPublishingYear() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.genre==null && other.getGenre()==null) || 
             (this.genre!=null &&
              this.genre.equals(other.getGenre()))) &&
            this.authorId == other.getAuthorId();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += new Long(getBookId()).hashCode();
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        _hashCode += getPublishingYear();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getGenre() != null) {
            _hashCode += getGenre().hashCode();
        }
        _hashCode += new Long(getAuthorId()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BookDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.booksearchsoap.bsu.by/", "bookDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bookId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishingYear");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publishingYear"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("genre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "genre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
