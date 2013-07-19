
package org.mobileapi.server.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enumEncoding.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enumEncoding">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="BINARY"/>
 *     &lt;enumeration value="BSON"/>
 *     &lt;enumeration value="EXI"/>
 *     &lt;enumeration value="ASCII"/>
 *     &lt;enumeration value="UTF8"/>
 *     &lt;enumeration value="UTF16"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumEncoding")
@XmlEnum
public enum EnumEncoding {

    NONE("NONE"),
    BINARY("BINARY"),
    BSON("BSON"),
    EXI("EXI"),
    ASCII("ASCII"),
    @XmlEnumValue("UTF8")
    UTF_8("UTF8"),
    @XmlEnumValue("UTF16")
    UTF_16("UTF16");
    private final String value;

    EnumEncoding(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EnumEncoding fromValue(String v) {
        for (EnumEncoding c: EnumEncoding.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
