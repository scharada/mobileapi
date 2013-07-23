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

import org.mobileapi.server.entity.*;
import org.mobileapi.entity.Key;

public class UserService {
	
	public boolean exists(String email)
	{
		DBCollection coll = DBFactory.get().getCollection("user");
		BasicDBObject query = new BasicDBObject("email", email);
		DBCursor cursor = coll.find(query);
		boolean exists = cursor.count() > 0;
		cursor.close();
		return exists;
	}
	
	public void insert(User user)
	{
		DBCollection coll = DBFactory.get().getCollection("user");
		BasicDBObject doc = new BasicDBObject("email", user.getEmail()).
				append(Key.USERID, user.getUserId()).
				append("givenName", user.getGivenName()).
				append("name", user.getName()).
				append("msisdn", user.getMsisdn()).
				append("language", user.getLanguage()).
				append("city", user.getCity()).
				append("county", user.getCounty()).
				append("country", user.getCountry()).
				append("postcode", user.getPostcode()).
				append("pwd", user.getPwd()).
				append("status", user.getStatus().toString()).
				append("addr0", user.getAddr0()).
				append("addr1", user.getAddr1()).
                append("token", user.getToken()).
                append("update", user.getUpdate().toGregorianCalendar().getTime().getTime()).
                append("create",user.getCreate().toGregorianCalendar().getTime().getTime());

		coll.insert(doc);
	}
}
