
package org.mobileapi.server.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enumOpcode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enumOpcode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LOGON"/>
 *     &lt;enumeration value="ACK"/>
 *     &lt;enumeration value="NACK"/>
 *     &lt;enumeration value="MSG"/>
 *     &lt;enumeration value="GPS"/>
 *     &lt;enumeration value="PING"/>
 *     &lt;enumeration value="ECHO"/>
 *     &lt;enumeration value="LOG"/>
 *     &lt;enumeration value="UPDATETOKEN"/>
 *     &lt;enumeration value="CHANGEGATEWAY"/>
 *     &lt;enumeration value="LOGOFF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumOpcode")
@XmlEnum
public enum EnumOpcode {

    LOGON,
    ACK,
    NACK,
    MSG,
    GPS,
    PING,
    ECHO,
    LOG,
    UPDATETOKEN,
    CHANGEGATEWAY,
    LOGOFF;

    public String value() {
        return name();
    }

    public static EnumOpcode fromValue(String v) {
        return valueOf(v);
    }

}
