
package org.mobileapi.server.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enumEncryption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enumEncryption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="KEYS"/>
 *     &lt;enumeration value="CERT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumEncryption")
@XmlEnum
public enum EnumEncryption {

    NONE,
    KEYS,
    CERT;

    public String value() {
        return name();
    }

    public static EnumEncryption fromValue(String v) {
        return valueOf(v);
    }

}
