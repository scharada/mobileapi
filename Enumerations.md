| **EnumOpcode** |
|:---------------|
| 0 | LOGON |
| 1| ACK |
| 2| NACK |
| 3 | STARTSEQ |
| 4 | ENDSEQ |
| 5 | TERMINATESEQ |
| 6 | MSG |
| 7 | GPS |
| 8 | PING |
| 9 | PONG |
| 10 | ECHO |
| 11 | LOGDEBUG |
| 12 | LOGERROR |
| 13 | UPDATETOKEN |
| 14 | CHANGEGATEWAY |
| 15 | LOGOFF |

|  **EnumEncoding** |
|:------------------|
| 0 | NONE |
| 1 | BINARY |
| 2 | BSON |
| 3 | EXI |
| 4 | ASCII |
| 5 | UTF-8 |
| 6 | UTF-16 |

|  **EnumPriority** |
|:------------------|
| 0 | NORMAL |
| 1 | LOW |
| 2 | HIGH |

|  **EnumEncryption** |
|:--------------------|
| 0 | NONE |
| 1 | KEYS |
| 2 | CERT |

|  **EnumMsgStatus** |
|:-------------------|
| 0 | NEW  |
| 1 | QUEUED  |
| 2 | AIR  |
| 3 | NACKED  |
| 4 | ACKED  |
| 5 | REPORT\_QUEUED  |
| 6 | REPORT\_AIR  |
| 7 | REPORT\_NACKED  |
| 8 | REPORT\_ACKED  |
| 9 | LOGGED  |

|  **EnumChannelOption** |
|:-----------------------|
| 0 | UNRELIABLE |
| 1 | RELIABLE |
| 2 | REPORTED |
| 3 | P2P\_UNRELIABLE |
| 4 | P2P\_RELIABLE |
| 5 | P2P\_REPORTED |

|  **EnumDeviceStatus** |
|:----------------------|
| 0 | NEW |
| 1 | ACTIVE |
| 2 | BLOCKED |

|  **EnumUserStatus** |
|:--------------------|
| 0 | NEW |
| 1 | ACTIVE |
| 2 | BLOCKED |

| **EnumMapType** |
|:----------------|
| 0 | NONE |
| 1 | XSLT |
| 2 | KEYPAIR |

| **EnumAddressType** |
|:--------------------|
| 0 | NONE |
| 1 | XPATH |
| 2 | KEYPAIR |
| 4 | TBD |

| **EnumAddressPermission** |
|:--------------------------|
| 0 | NONE |
| 1 | ACK |
| 2 | GATEWAY |
| 4 | BACKEND |
| 8 | P2PCHECK |
| 16 | P2PALL |
| 32 | GPS |