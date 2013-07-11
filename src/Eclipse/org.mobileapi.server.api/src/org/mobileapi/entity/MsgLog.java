package org.mobileapi.entity;

import java.util.Date;

public class MsgLog {

	// public BsonObjectId _id;

    public java.util.UUID  ID;

    public java.util.UUID  MsgID;

    public EnumOpcode Opcode;

    public java.util.UUID  Sender;

    public java.util.UUID  Receiver;

    public EnumMsgStatus EnumMsgStatus;

    public byte[] Bin;

    public Date Update;

    public Date Create;
}
