
package org.mobileapi.server.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enumChannelOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enumChannelOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNRELIABLE"/>
 *     &lt;enumeration value="RELIABLE"/>
 *     &lt;enumeration value="REPORTED"/>
 *     &lt;enumeration value="P2P_UNRELIABLE"/>
 *     &lt;enumeration value="P2P_RELIABLE"/>
 *     &lt;enumeration value="P2P_REPORTED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumChannelOption")
@XmlEnum
public enum EnumChannelOption {

    UNRELIABLE("UNRELIABLE"),
    RELIABLE("RELIABLE"),
    REPORTED("REPORTED"),
    @XmlEnumValue("P2P_UNRELIABLE")
    P_2_P_UNRELIABLE("P2P_UNRELIABLE"),
    @XmlEnumValue("P2P_RELIABLE")
    P_2_P_RELIABLE("P2P_RELIABLE"),
    @XmlEnumValue("P2P_REPORTED")
    P_2_P_REPORTED("P2P_REPORTED");
    private final String value;

    EnumChannelOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EnumChannelOption fromValue(String v) {
        for (EnumChannelOption c: EnumChannelOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
