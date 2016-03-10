package com.papafranku.database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.papafranku.entities.User;

public class MongoAdapter {

	public static final String DB_NAME = "easyreceipt";
	
	private MongoClient mongoClient;
	private MongoDatabase db;
	
	
	public MongoAdapter() {
		
		mongoClient = new MongoClient();
		
	}
	
	public MongoDatabase connect() {
		
		db = mongoClient.getDatabase(DB_NAME);
		
		return db;
		
	}

	public void initializeUsers() {
		
		List users = new ArrayList<Document>();
		
		User user = new User();
		user.setFirstName("Ethan");
		user.setLastName("Sonze");
		user.setEmail("ethan@gmail.com");
		user.setUsername("ethanSonza");
		user.setPassword("test1234");
		
		users.add(MongoUtilities.convertUser(user));
		
		db.getCollection("users").insertMany(users);
		
	}
	

}
