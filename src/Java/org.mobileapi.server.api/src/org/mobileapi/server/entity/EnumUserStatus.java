
package org.mobileapi.server.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enumUserStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enumUserStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEW"/>
 *     &lt;enumeration value="INVITED"/>
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="BLOCKED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumUserStatus")
@XmlEnum
public enum EnumUserStatus {

    NEW,
    INVITED,
    ACTIVE,
    BLOCKED;

    public String value() {
        return name();
    }

    public static EnumUserStatus fromValue(String v) {
        return valueOf(v);
    }

}
