package com.papafranku.database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.papafranku.entities.User;

public class MongoQueryBuilder {
	
	private MongoDatabase db;
	
	public static final String USER_COLLECTION = "users";
	
	public MongoQueryBuilder() {
		
		MongoAdapter adapter = new MongoAdapter();
		db = adapter.connect();
		
	}
	
	public boolean insertData(String collection, Object data) {
		
		
		
		return true;
		
	}
	
	public List<User> getUsers() {
		
		FindIterable<Document> iterable = db.getCollection("users").find();
		List<User> users = new ArrayList<User>();
		
		iterable.forEach(new Block<Document>() {
		    
			@Override
		    public void apply(final Document document) {
				
//				Document userDoc = (Document) document.get("user");
				User newUser = new User();
				
				newUser.setFirstName(document.getString("firstName"));
				newUser.setLastName(document.getString("lastName"));
				newUser.setEmail(document.getString("email"));
				newUser.setUsername(document.getString("username"));
				newUser.setPassword(document.getString("password"));
				
				System.out.println(document);
				
				users.add(newUser);
		    }
		});
		
		System.out.println(users.size());
		
		return users;
	}
	
	public Document queryData(String collection, String key, String value) {
		
		FindIterable<Document> iterable = db.getCollection(collection).find(new Document(key, value));
		
		System.out.println(iterable.first());
		
		return iterable.first();
	}
	
	public Document getUser(String value) {
		
		FindIterable<Document> iterable = db.getCollection("users").find();
		
		
		
		return iterable.first();
		
	}
	


}
