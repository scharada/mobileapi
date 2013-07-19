
package org.mobileapi.server.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enumMapType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enumMapType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="XSLT"/>
 *     &lt;enumeration value="KEYPAIR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumMapType")
@XmlEnum
public enum EnumMapType {

    NONE,
    XSLT,
    KEYPAIR;

    public String value() {
        return name();
    }

    public static EnumMapType fromValue(String v) {
        return valueOf(v);
    }

}
