package org.mobileapi.entity;

public class ErrorCode {

	public static final int OK = 100;
	public static final int GENERALERROR = 200;
	public static final int NOTAVALIDEMAIL = 201;
	public static final int USEREXISTS = 202;

	public static String ToString(int code)
	{
		switch(code)
		{
			case 100:
			return "OK";
			
			case 200:
				return "GENERALERROR";
				
			case 201:
				return "NOTAVALIDEMAIL";
				
			case 202:
				return "USEREXISTS";
		}
		return "";
	}
}
