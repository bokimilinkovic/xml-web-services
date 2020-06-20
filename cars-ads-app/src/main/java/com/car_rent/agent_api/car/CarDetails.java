
package com.car_rent.agent_api.car;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CarDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CarDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="carClass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalMileage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="allowedMileage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="childrenSeats" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="colDamProtection" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fuel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transmission" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="images" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CarDetails", namespace = "http://car-rent.com/agent-api", propOrder = {
    "id",
    "brand",
    "model",
    "carClass",
    "totalMileage",
    "allowedMileage",
    "childrenSeats",
    "description",
    "colDamProtection",
    "fuel",
    "transmission",
    "owner",
    "images"
})
public class CarDetails {

    @XmlElement(namespace = "http://car-rent.com/agent-api")
    protected long id;
    @XmlElement(namespace = "http://car-rent.com/agent-api", required = true)
    protected String brand;
    @XmlElement(namespace = "http://car-rent.com/agent-api", required = true)
    protected String model;
    @XmlElement(namespace = "http://car-rent.com/agent-api", required = true)
    protected String carClass;
    @XmlElement(namespace = "http://car-rent.com/agent-api")
    protected double totalMileage;
    @XmlElement(namespace = "http://car-rent.com/agent-api")
    protected double allowedMileage;
    @XmlElement(namespace = "http://car-rent.com/agent-api")
    protected int childrenSeats;
    @XmlElement(namespace = "http://car-rent.com/agent-api", required = true)
    protected String description;
    @XmlElement(namespace = "http://car-rent.com/agent-api")
    protected boolean colDamProtection;
    @XmlElement(namespace = "http://car-rent.com/agent-api", required = true)
    protected String fuel;
    @XmlElement(namespace = "http://car-rent.com/agent-api", required = true)
    protected String transmission;
    @XmlElement(namespace = "http://car-rent.com/agent-api", required = true)
    protected String owner;
    @XmlElement(namespace = "http://car-rent.com/agent-api", required = true)
    protected List<String> images;

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

    /**
     * Gets the value of the brand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrand(String value) {
        this.brand = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the carClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarClass() {
        return carClass;
    }

    /**
     * Sets the value of the carClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarClass(String value) {
        this.carClass = value;
    }

    /**
     * Gets the value of the totalMileage property.
     * 
     */
    public double getTotalMileage() {
        return totalMileage;
    }

    /**
     * Sets the value of the totalMileage property.
     * 
     */
    public void setTotalMileage(double value) {
        this.totalMileage = value;
    }

    /**
     * Gets the value of the allowedMileage property.
     * 
     */
    public double getAllowedMileage() {
        return allowedMileage;
    }

    /**
     * Sets the value of the allowedMileage property.
     * 
     */
    public void setAllowedMileage(double value) {
        this.allowedMileage = value;
    }

    /**
     * Gets the value of the childrenSeats property.
     * 
     */
    public int getChildrenSeats() {
        return childrenSeats;
    }

    /**
     * Sets the value of the childrenSeats property.
     * 
     */
    public void setChildrenSeats(int value) {
        this.childrenSeats = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the colDamProtection property.
     * 
     */
    public boolean isColDamProtection() {
        return colDamProtection;
    }

    /**
     * Sets the value of the colDamProtection property.
     * 
     */
    public void setColDamProtection(boolean value) {
        this.colDamProtection = value;
    }

    /**
     * Gets the value of the fuel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuel() {
        return fuel;
    }

    /**
     * Sets the value of the fuel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuel(String value) {
        this.fuel = value;
    }

    /**
     * Gets the value of the transmission property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * Sets the value of the transmission property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransmission(String value) {
        this.transmission = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the images property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getImages() {
        if (images == null) {
            images = new ArrayList<String>();
        }
        return this.images;
    }

}
