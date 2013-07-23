package org.mobileapi.server.api.service;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.mobileapi.helper.AMPQClient;
import org.mobileapi.helper.Redis;
import org.mobileapi.helper.Zoo;
import org.mobileapi.server.config.XMLConfigLoader;
import org.mobileapi.server.db.DBFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

@Named
@Startup
@Singleton
public class Factory {
	
	private Logger L = Logger.getLogger(Factory.class);
	
	private static Zoo _zoo = new Zoo();
	
	private static AMPQClient _aMPQClient = new AMPQClient();
	
	private static XMLConfigLoader _xmlConfigLoader;
	
	public static XMLConfigLoader xmlConfig()
	{
		return _xmlConfigLoader;
	}
	
	public static AMPQClient ampq()
	{
		return _aMPQClient;
	}
	
	public static Redis redis()
	{
		return new Redis();
	}
	
	public static Zoo zoo()
	{
		return _zoo;
	}
	
	private void printError(String error)
	{
		L.error("=======================================");
		L.error("=  FATAL      STARTUP         ERROR   =");
		L.error(error);
		L.error("=======================================");
	}
	
	@PostConstruct
	public void start()
	{
		// init Log4J
		try {
			if( System.getProperty("os.name").startsWith("Windows"))
			{
				DOMConfigurator.configure("C:\\mobileapiLog4j.xml");
				System.out.println("Configured Log4Jwith C:\\mobileapiLog4j.xml");
			}
			else
			{
				DOMConfigurator.configure("/etc/mobileapiLog4j.xml");
				System.out.println("Configured Log4Jwith /etc/mobileapiLog4j.xml");
			}
			
			String localhostname = java.net.InetAddress.getLocalHost().getHostName();
			
			L.debug("localhostname:" + localhostname);
			
			// Load config file
			_xmlConfigLoader = new XMLConfigLoader();
			boolean hasLoaded = _xmlConfigLoader.parse();
			if(!hasLoaded)
			{
				printError("mobileapi.conf not found, place in /etc/mobileapi.conf or c:\\mobileapi.conf");
				return;
			}
			
			System.out.println("=================");
			System.out.println("=   ZOOKEEPER   =");
			
			
			try
			{
				_zoo.startup();
				System.out.println(" Zookepper connected ");
			}
			catch(Exception err)
			{
				printError("Error: Zookepper not reachable ");
				return;
			}
			System.out.println(" Zookepper connected ");
			System.out.println("=================");
			
			System.out.println("=================");
			System.out.println("=     REDIS     =");
			Redis redis =  redis();
			redis.configure("localhost", 6379);
			redis.startup();
			redis.set("testkey", "testvalue");
			String test = redis.get("testkey");
		    
			System.out.println(" Redis  connected ");
			System.out.println("=================");
			
			System.out.println("=================");
			System.out.println("=    RABBITMQ   =");
			_aMPQClient.configure("localhost", 5672,  "/", "guest", "guest");
			_aMPQClient.startup();
			System.out.println(" AMPQClient connected ");
			System.out.println("================");
				
			System.out.println("=================");
			System.out.println("=   MONGODB     =");
			DBFactory.configure("localhost", 27017, "mobileapi");
			DBCollection coll = DBFactory.get().getCollection("user");
			BasicDBObject query = new BasicDBObject("email", "mathias.dietrich@gmail.com");
			DBCursor cursor = coll.find(query);
			
			boolean exists = cursor.count() > 0;
			cursor.close();
			System.out.println(" Mongodb connected ");
			System.out.println("================");
			
			// 
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	private void shutdown() {
		
		// TODO inform Zookeeper
		
		 _aMPQClient.close();
		 
		 DBFactory.shutdown();
		 
		 redis().shutdown();
		 
		_zoo.shutdown();
	}
}
