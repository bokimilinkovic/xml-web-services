//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.07 at 12:55:34 AM CEST 
//


package com.car_rent.agent_api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BundleDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BundleDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="booksDetails" type="{http://car-rent.com/agent-api}BookingDetails" maxOccurs="unbounded"/>
 *         &lt;element name="loaner" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BundleDetail", propOrder = {
    "booksDetails",
    "loaner",
    "id"
})
public class BundleDetail {

    @XmlElement(required = true)
    protected List<BookingDetails> booksDetails;
    @XmlElement(required = true)
    protected String loaner;
    protected long id;

    /**
     * Gets the value of the booksDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the booksDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBooksDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BookingDetails }
     * 
     * 
     */
    public List<BookingDetails> getBooksDetails() {
        if (booksDetails == null) {
            booksDetails = new ArrayList<BookingDetails>();
        }
        return this.booksDetails;
    }

    /**
     * Gets the value of the loaner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoaner() {
        return loaner;
    }

    /**
     * Sets the value of the loaner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoaner(String value) {
        this.loaner = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

}
