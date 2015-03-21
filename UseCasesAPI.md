|
| **Register** | Registration of a new Admin |
|:-------------|:----------------------------|
| `void register(string name, enumLanguage lang, string email);` |
| TBD: email template?  |

| **Email Confirm** | Admin confirms his email by clicking link in email |
|:------------------|:---------------------------------------------------|
| `void confirm(email, token, appID);` | appID can be null, used by invite |

| **Set Passwort** | Admin sets Passwort |
|:-----------------|:--------------------|
| `void setPwd(email, pwd, pwd2);` |

| **Logon** | Admin logs on to Portal, session key stored JavaScript |
|:----------|:-------------------------------------------------------|
| ` void logon(email, pwd);` |

| **Edit Profile** |
|:-----------------|
| `void edit(email, name,  optional: city, county, country, addr1, addr2, postcode, lang, country, MSISN);` |

| **Update Passwort** |
|:--------------------|
| `void updatePwd(email, oldPwd, newPwd);` |

| **List Applications**  |
|:-----------------------|
| `App listApps(userId) ;` |

| **Create Application**  |
|:------------------------|
| `void createApp(userId, name, desc, autoRegistration);` |

| **Delete Application**  |
|:------------------------|
| `void deleteApp(appID );`|

| **Edit Application**  |
|:----------------------|
| `void editApp(appid, name, desc, autoRegistration);` |

| **Invite Admin**  |
|:------------------|
| `void inviteUser(appId, email );` |

| **List Channels** |
|:------------------|
| `void listChannels(appid); ` |

| **Add Channel** |
|:----------------|
| `void addChannel(appID, name, transportConfig, mappingConfig, addrResConfig); `|

| **Edit Channel**  |
|:------------------|
| `void editChannel(channelID,  transportConfig, mappingConfig, addrResConfig); `|

| **Remove Channel**  |
|:--------------------|
| `void removeChannel(channelID); ` |

| **List Devices**  |
|:------------------|
| `List listDevices(appID);` |

| **Register Device** |
|:--------------------|
| `void registerDevice(appID, deviceID, user, secret); ` |

| **Enable Device** |
|:------------------|
| `void enableDevice(appID, user, pin); ` |

| **Block Device**  |
|:------------------|
| `void blockDevice(deviceID);` |