package org.mobileapi.server.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.Arrays;

public class DBFactory {
	
	private static String _server = "localhost";
	private static int _port = 27017;
	private static String _collection = "mobileapi";
	
	public static synchronized void configure(String server, int port, String collection)
	{
		_server = server;
		_port = port;
		_collection = collection;
	}

	public synchronized static DB get()
	{
		MongoClient mongoClient;
		DB db = null;
		try {
			mongoClient = new MongoClient(_server , _port );
			db = mongoClient.getDB( _collection );
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return db;
	}
	
	public static void shutdown()
	{
		
	}
}
