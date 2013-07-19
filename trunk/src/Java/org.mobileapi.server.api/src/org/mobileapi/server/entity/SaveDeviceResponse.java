
package org.mobileapi.server.entity;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="device" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="statusMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "device",
    "status",
    "statusMsg"
})
@XmlRootElement(name = "SaveDeviceResponse")
public class SaveDeviceResponse {

    @XmlElement(required = true)
    protected BigInteger device;
    @XmlElement(required = true)
    protected BigInteger status;
    protected String statusMsg;

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDevice(BigInteger value) {
        this.device = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStatus(BigInteger value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusMsg() {
        return statusMsg;
    }

    /**
     * Sets the value of the statusMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusMsg(String value) {
        this.statusMsg = value;
    }

}
