
package org.mobileapi.server.entity;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Channel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Channel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="channelId" type="{http://mobileapi.org}guid"/>
 *         &lt;element name="appId" type="{http://mobileapi.org}guid"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="retries" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="ttl" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="priority" type="{http://mobileapi.org}enumPriority"/>
 *         &lt;element name="mapOut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mapOutType" type="{http://mobileapi.org}enumMapType"/>
 *         &lt;element name="mapIn" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="mapInType" type="{http://mobileapi.org}enumMapType"/>
 *         &lt;element name="addressType" type="{http://mobileapi.org}enumAddressType"/>
 *         &lt;element name="addressPath" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="addressMap" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="addressPermission" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="callBackUrl" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="callBackUser" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="callBackPwd" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="update" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="create" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Channel", propOrder = {
    "channelId",
    "appId",
    "name",
    "retries",
    "ttl",
    "priority",
    "mapOut",
    "mapOutType",
    "mapIn",
    "mapInType",
    "addressType",
    "addressPath",
    "addressMap",
    "addressPermission",
    "callBackUrl",
    "callBackUser",
    "callBackPwd",
    "update",
    "create"
})
public class Channel {

    @XmlElement(required = true)
    protected String channelId;
    @XmlElement(required = true)
    protected String appId;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected BigInteger retries;
    @XmlElement(required = true)
    protected BigInteger ttl;
    @XmlElement(required = true)
    protected EnumPriority priority;
    protected String mapOut;
    @XmlElement(required = true)
    protected EnumMapType mapOutType;
    protected BigInteger mapIn;
    @XmlElement(required = true)
    protected EnumMapType mapInType;
    @XmlElement(required = true)
    protected EnumAddressType addressType;
    protected BigInteger addressPath;
    protected BigInteger addressMap;
    protected BigInteger addressPermission;
    protected BigInteger callBackUrl;
    protected BigInteger callBackUser;
    protected BigInteger callBackPwd;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar update;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar create;

    /**
     * Gets the value of the channelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * Sets the value of the channelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelId(String value) {
        this.channelId = value;
    }

    /**
     * Gets the value of the appId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Sets the value of the appId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the retries property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRetries() {
        return retries;
    }

    /**
     * Sets the value of the retries property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRetries(BigInteger value) {
        this.retries = value;
    }

    /**
     * Gets the value of the ttl property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTtl() {
        return ttl;
    }

    /**
     * Sets the value of the ttl property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTtl(BigInteger value) {
        this.ttl = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link EnumPriority }
     *     
     */
    public EnumPriority getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumPriority }
     *     
     */
    public void setPriority(EnumPriority value) {
        this.priority = value;
    }

    /**
     * Gets the value of the mapOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapOut() {
        return mapOut;
    }

    /**
     * Sets the value of the mapOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapOut(String value) {
        this.mapOut = value;
    }

    /**
     * Gets the value of the mapOutType property.
     * 
     * @return
     *     possible object is
     *     {@link EnumMapType }
     *     
     */
    public EnumMapType getMapOutType() {
        return mapOutType;
    }

    /**
     * Sets the value of the mapOutType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumMapType }
     *     
     */
    public void setMapOutType(EnumMapType value) {
        this.mapOutType = value;
    }

    /**
     * Gets the value of the mapIn property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMapIn() {
        return mapIn;
    }

    /**
     * Sets the value of the mapIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMapIn(BigInteger value) {
        this.mapIn = value;
    }

    /**
     * Gets the value of the mapInType property.
     * 
     * @return
     *     possible object is
     *     {@link EnumMapType }
     *     
     */
    public EnumMapType getMapInType() {
        return mapInType;
    }

    /**
     * Sets the value of the mapInType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumMapType }
     *     
     */
    public void setMapInType(EnumMapType value) {
        this.mapInType = value;
    }

    /**
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link EnumAddressType }
     *     
     */
    public EnumAddressType getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumAddressType }
     *     
     */
    public void setAddressType(EnumAddressType value) {
        this.addressType = value;
    }

    /**
     * Gets the value of the addressPath property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAddressPath() {
        return addressPath;
    }

    /**
     * Sets the value of the addressPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAddressPath(BigInteger value) {
        this.addressPath = value;
    }

    /**
     * Gets the value of the addressMap property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAddressMap() {
        return addressMap;
    }

    /**
     * Sets the value of the addressMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAddressMap(BigInteger value) {
        this.addressMap = value;
    }

    /**
     * Gets the value of the addressPermission property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAddressPermission() {
        return addressPermission;
    }

    /**
     * Sets the value of the addressPermission property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAddressPermission(BigInteger value) {
        this.addressPermission = value;
    }

    /**
     * Gets the value of the callBackUrl property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCallBackUrl() {
        return callBackUrl;
    }

    /**
     * Sets the value of the callBackUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCallBackUrl(BigInteger value) {
        this.callBackUrl = value;
    }

    /**
     * Gets the value of the callBackUser property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCallBackUser() {
        return callBackUser;
    }

    /**
     * Sets the value of the callBackUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCallBackUser(BigInteger value) {
        this.callBackUser = value;
    }

    /**
     * Gets the value of the callBackPwd property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCallBackPwd() {
        return callBackPwd;
    }

    /**
     * Sets the value of the callBackPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCallBackPwd(BigInteger value) {
        this.callBackPwd = value;
    }

    /**
     * Gets the value of the update property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdate() {
        return update;
    }

    /**
     * Sets the value of the update property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdate(XMLGregorianCalendar value) {
        this.update = value;
    }

    /**
     * Gets the value of the create property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreate() {
        return create;
    }

    /**
     * Sets the value of the create property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreate(XMLGregorianCalendar value) {
        this.create = value;
    }

}
