package org.mobileapi.helper;

import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class HelperTime {
	
	public static javax.xml.datatype.XMLGregorianCalendar now()
	{
		 GregorianCalendar gregorianCalendar = new GregorianCalendar();
	        DatatypeFactory datatypeFactory;
			try {
				datatypeFactory = DatatypeFactory.newInstance();
		        XMLGregorianCalendar now = 
			            datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
			        return now;
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return null;
	}
}
