package org.mobileapi.entity;

import java.util.Date;

public class Device {

	//  public BsonObjectId _id;

     public java.util.UUID  ID;

     public java.util.UUID  AppID;
     
     public String User;
     
     public String Pin;

     public double Lat;

     public double Long;

     public int Fix;

     public int Sat;

     public Date GPSTime;

     public EnumDeviceStatus Status;

     public java.util.UUID  Token;

     public Date Update;

     public Date Create;
}
