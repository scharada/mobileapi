# Setup #

Check our [Links](Links.md) page for download links.

Installation for a single Server configuration:

  * OS - Tested on Ubuntu (Amazon EC2) and on Windows 8.

  * Mongodb

  * Redis

  * Java7

  * Zookeper

  * Glassfish 4

  * copy jars to Glassfish domain1 lib/ext

  * create config files for Linux: /etc/mobileapi.conf and /etc/mobileapi4J.xml or Windows: C:\mobileapi.conf and C:\mobileapi4J.xml

  * create queues (script TODO)

  * populate Zookeeper (script TODO)

  * Deploy mobileapi.ear on Glassfish

  * Start app.js (sudo node app.js)