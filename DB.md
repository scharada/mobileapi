## MongoDB ##

| **User** |
|:---------|
| ID | guid |
| appIDS | guid |
| givenname | string |
| name |  string |
| email |  string |
| msisdn |  string |
| pwd |  string |
| addr0 |  string |
| addr1 |  string |
| city |  string |
| postcode |  string |
| county | string |
| country | string |
| lang |  string |
| status | number  | EnumUserStatus |
| token | guid |
| update | date |
| create | date |

| **App** |
|:--------|
| ID | guid |
| appID | guid |
| userIDS | guid |
| name |  string |
| desc |  string |
| update | date |
| create | date |

| **Device** |
|:-----------|
| ID | guid |
| deviceID | guid |
| appID | guid |
| user | string |
| pin | string |
| lat | double |
| long | double |
| fix | number |
| sat | number |
| gpstime |  date |
| status |  number | EnumDeviceStatus |
| token | guid |
| update | date |
| create | date |

| **Channel** |
|:------------|
| ID |  guid |
| appID |  guid |
| retries | number |
| ttl | number |
| priority | EnumPriority|
| mapOut | string |
| mapOutType | EnumMapType|
| mapIn | string |
| mapInType | EnumMapType|
| addressType | EnumAddressType |
| addressXPath | string |
| addressMap | string |
| addressPermission | EnumAddressPermission|
| callBackURL | string |
| callBackUser | string |
| callBackPwd | string |
| update | date |
| create | date |

| **Conf** |
|:---------|
| ID |  guid |
| appID |  guid |
| key |  string |
| value |  string |
| update |  date |
| create |  date |

| **MsgLog** |
|:-----------|
| ID |  guid |
| msgID |  guid |
| appID |  guid |
| opcode | number |
| sender |  guid |
| receiver | guid |
| status | number | EnumMsgStatus |
| content | bin |
| update | date |
| create | date |

| **Audit**  |
|:-----------|
| ID  | guid  |
| orgID  | guid  |
| Log | string|
| create | date |

## Redis ##
| deviceID\_PORT | IP:Port |
|:---------------|:--------|
| deviceID\_TOKEN | token |
| deviceID\_GATE | gateID |