using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace org.mobileapi.server.windows.shared
{


    public enum  EnumOpcode
    {
        LOGON = 0,
    	 ACK = 1,
    	 NACK = 2,
    	 MSG = 3,
    	 GPS = 4,
    	 PING = 5,
    	 ECHO = 6,
    	 LOG = 7,
    	 UPDATETOKEN = 8,
         CHANGEGATEWAY = 9,
         LOGOFF = 10,
    }

     public enum EnumEncoding
     {
         NONE = 0,
         BINARY = 1,
         BSON = 2,
         EXI = 3,
         ASCII = 4,
         UTF8 = 5,
         UTF16 = 6
     }

     public enum EnumPriority
     {
         NORMAL = 0,
         LOW = 1,
         HIGH = 2
     }

     public enum EnumEncryption
     {
         NONE = 0,
         KEYS = 1,
         CERT = 2
     }

     public enum EnumMsgStatus
     {
        NEW = 0,
    	 QUEUED = 1,
    	 AIR = 2,
    	 NACKED = 3,
    	 ACKED = 4,
    	 REPORT_QUEUED = 5,
    	 REPORT_AIR = 6,
    	 REPORT_NACKED = 7,
    	 REPORT_ACKED = 8,
         LOGGED = 9
     }

     public enum EnumChannelOption
     {
         UNRELIABLE = 0,
         RELIABLE = 1,
         REPORTED = 2,
         P2P_UNRELIABLE = 3,
         P2P_RELIABLE = 4,
    	 P2P_REPORTED = 5
     }

     public enum EnumDeviceStatus
     {
         NEW = 0,
         ACTIVE = 1,
         BLOCKED = 2
     }

     public enum EnumUserStatus
     {
         NEW = 0,
         INVITED = 1,
         ACTIVE = 2,
         BLOCKED = 3
     }

     public enum EnumMapType
     {
         NONE = 0,
         XSLT = 1,
         KEYPAIR = 2
     }

     public enum EnumAddressType
     {
         NONE = 0,
         XPATH = 1,
         KEYPAIR = 2,  
     }

     public enum EnumAddressPermission
     {
         NONE = 0,
         ACK = 1,
         GATEWAY = 2,
         BACKEND = 4,
         P2PCHECK = 8,
         P2PALL = 16,
         GPS = 32
     }
}



