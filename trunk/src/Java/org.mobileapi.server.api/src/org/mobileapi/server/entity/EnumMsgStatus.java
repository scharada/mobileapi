
package org.mobileapi.server.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enumMsgStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enumMsgStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEW"/>
 *     &lt;enumeration value="QUEUED"/>
 *     &lt;enumeration value="AIR"/>
 *     &lt;enumeration value="NACKED"/>
 *     &lt;enumeration value="ACKED"/>
 *     &lt;enumeration value="REPORT_QUEUED"/>
 *     &lt;enumeration value="REPORT_AIR"/>
 *     &lt;enumeration value="REPORT_NACKED"/>
 *     &lt;enumeration value="REPORT_ACKED"/>
 *     &lt;enumeration value="LOGGED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumMsgStatus")
@XmlEnum
public enum EnumMsgStatus {

    NEW,
    QUEUED,
    AIR,
    NACKED,
    ACKED,
    REPORT_QUEUED,
    REPORT_AIR,
    REPORT_NACKED,
    REPORT_ACKED,
    LOGGED;

    public String value() {
        return name();
    }

    public static EnumMsgStatus fromValue(String v) {
        return valueOf(v);
    }

}
