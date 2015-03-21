Client libraries for rapid application development
  * Android
  * iOS
  * Windows Mobile
  * Notifications
  * UDP sockets
  * Message queues
  * Automatic Network selection
  * Location based service GPS.
  * binary Transport over <a href='http://www.w3.org/XML/EXI/‎'>EXI</a> and <a href='http://bsonspec.org/'>BSON</a>.

High performance push messaging gateway with guaranteed message delivery
  * UDP
  * TTL, ACK, NACK, message split,retries, priority configurable per channel
  * Rules engine based routing

Web based configuration portal
  * <a href='oauth.net/‎'>oAuth</a>, multi customer, multi admin, multi application
  * Message transformations XSLT
  * Graphical message mapping
  * Routing Rules(JavaScript?)


## Standards and Protocols ##
UDP, XML, XSLT, EXI, BSON,  NoSQL, OAuth, HTTPS, JQuery

## Server ##
Linux, Windows

## Clients ##
Android, iOS, Windows Mobile

## Implementation Languages ##
Java, C#, C++, C, JavaScript

## Platforms ##
Nginx.org, Redis.org, MongoDB.org, Qpid.org


## Design Priniciples ##
Open, Secure, Reliable and Scalable

According to Einstein: Everything Should Be Made as Simple as Possible, But Not Simpler

## Details ##
Incubation :5.6.2013
More coming soon...

## Links of Interest ##
http://www.w3.org/XML/EXI/
http://exificient.sourceforge.net/

https://npmjs.org/package/nools

## FAQ ##
Why UDP? TCP/IP provides retries at the protocol level, but timings configured originated in the fixed line networks, which does not perform well over the air. By taking control of ACK/NACK and retries on a higher level better performance can be achieved. The sporadic disconnected nature (ups, we are in a tunnel) of mobile networks like (GPRS, 3G, 4G) need strong support for message queues, which standard web server using HTTP/REST do not provide.

Push? If you want to talk to a device there are two options. The device keeps polling the server, which does not scale well. Second option is to keep a connection to the device open, which is technically more difficult, as the gateway has to keep state of the connection. This is exactly what MobileAPI.org provides.

API? As a developer, how do you talk to your mobile application? How do you connect your companies back-end to your mobile app?

- use the mobile web browser and serve mobile web pages. For many applications this is sufficient. The user can press refresh if the connection fails.

- build a mobile App and use REST to pull down data. Do retries pro grammatically.

- If you need to push data, if you need notification to talk to your application even if not running, if you need guaranteed messaging or if you have to upload constant streams of data (GPS Locations while moving for example) use a framework like MobileAPI.org.

Use case examples?
Work force, field worker, job scheduling, cloud based productivity tools, taxis and private hire, news reader prepares headlines over night, social apps, chat, on-line games, applications with high data volume