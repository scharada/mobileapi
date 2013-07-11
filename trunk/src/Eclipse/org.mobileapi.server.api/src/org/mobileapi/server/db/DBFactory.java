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

	public DB get()
	{
		MongoClient mongoClient;
		DB db = null;
		try {
			mongoClient = new MongoClient("localhost" , 27017 );
			db = mongoClient.getDB( "mobileapi" );
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// or, to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
		/*
		MongoClient mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
		                                      new ServerAddress("localhost", 27018),
		                                      new ServerAddress("localhost", 27019)));
		 */
			
		return db;
	}
}
