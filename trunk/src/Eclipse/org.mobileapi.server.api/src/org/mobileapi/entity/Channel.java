package org.mobileapi.entity;

import java.util.Date;

public class Channel {

	 public String Name;

     // public BsonObjectId _id;
	 
     public java.util.UUID  ID;

     public java.util.UUID  AppID;

     public int Retries;

     public int TTL;

     public EnumPriority Priority;

     public String MapOut;

     public EnumMapType MapOutType;

     public String MapIn;
      
     public EnumMapType MapInType;

     public EnumAddressType AddressType;

     public String AddressPath;

     public String AddressMap;

     public int AddressPermission;

     public String CallBackURL;

     public String CallBackUser;

     public String CallBackPwd;

     public Date Update;

     public Date Create;
}
