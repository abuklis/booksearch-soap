/**
 * Author.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package by.bsu.booksearchsoap.client;

public class Author  implements java.io.Serializable {
    private long authorId;

    private java.lang.String fullName;

    private int birthYear;

    private java.lang.String birthCountry;

    private java.lang.String biography;

    public Author() {
    }

    public Author(
           long authorId,
           java.lang.String fullName,
           int birthYear,
           java.lang.String birthCountry,
           java.lang.String biography) {
           this.authorId = authorId;
           this.fullName = fullName;
           this.birthYear = birthYear;
           this.birthCountry = birthCountry;
           this.biography = biography;
    }


    /**
     * Gets the authorId value for this Author.
     * 
     * @return authorId
     */
    public long getAuthorId() {
        return authorId;
    }


    /**
     * Sets the authorId value for this Author.
     * 
     * @param authorId
     */
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }


    /**
     * Gets the fullName value for this Author.
     * 
     * @return fullName
     */
    public java.lang.String getFullName() {
        return fullName;
    }


    /**
     * Sets the fullName value for this Author.
     * 
     * @param fullName
     */
    public void setFullName(java.lang.String fullName) {
        this.fullName = fullName;
    }


    /**
     * Gets the birthYear value for this Author.
     * 
     * @return birthYear
     */
    public int getBirthYear() {
        return birthYear;
    }


    /**
     * Sets the birthYear value for this Author.
     * 
     * @param birthYear
     */
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }


    /**
     * Gets the birthCountry value for this Author.
     * 
     * @return birthCountry
     */
    public java.lang.String getBirthCountry() {
        return birthCountry;
    }


    /**
     * Sets the birthCountry value for this Author.
     * 
     * @param birthCountry
     */
    public void setBirthCountry(java.lang.String birthCountry) {
        this.birthCountry = birthCountry;
    }


    /**
     * Gets the biography value for this Author.
     * 
     * @return biography
     */
    public java.lang.String getBiography() {
        return biography;
    }


    /**
     * Sets the biography value for this Author.
     * 
     * @param biography
     */
    public void setBiography(java.lang.String biography) {
        this.biography = biography;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Author)) return false;
        Author other = (Author) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.authorId == other.getAuthorId() &&
            ((this.fullName==null && other.getFullName()==null) || 
             (this.fullName!=null &&
              this.fullName.equals(other.getFullName()))) &&
            this.birthYear == other.getBirthYear() &&
            ((this.birthCountry==null && other.getBirthCountry()==null) || 
             (this.birthCountry!=null &&
              this.birthCountry.equals(other.getBirthCountry()))) &&
            ((this.biography==null && other.getBiography()==null) || 
             (this.biography!=null &&
              this.biography.equals(other.getBiography())));
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
        _hashCode += new Long(getAuthorId()).hashCode();
        if (getFullName() != null) {
            _hashCode += getFullName().hashCode();
        }
        _hashCode += getBirthYear();
        if (getBirthCountry() != null) {
            _hashCode += getBirthCountry().hashCode();
        }
        if (getBiography() != null) {
            _hashCode += getBiography().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Author.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.booksearchsoap.bsu.by/", "author"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fullName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthYear");
        elemField.setXmlName(new javax.xml.namespace.QName("", "birthYear"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("", "birthCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("biography");
        elemField.setXmlName(new javax.xml.namespace.QName("", "biography"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
