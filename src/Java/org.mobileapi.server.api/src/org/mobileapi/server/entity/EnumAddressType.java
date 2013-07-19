
package org.mobileapi.server.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enumAddressType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enumAddressType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="XPATH"/>
 *     &lt;enumeration value="KEYPAIR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumAddressType")
@XmlEnum
public enum EnumAddressType {

    NONE,
    XPATH,
    KEYPAIR;

    public String value() {
        return name();
    }

    public static EnumAddressType fromValue(String v) {
        return valueOf(v);
    }

}
