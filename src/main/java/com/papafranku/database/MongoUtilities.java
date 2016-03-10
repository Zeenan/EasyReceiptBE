package com.papafranku.database;

import org.bson.Document;

import com.papafranku.entities.User;

public class MongoUtilities {
	
	public static Document convertUser(User user) {
		
		Document d = new Document()
					.append("firstName", user.getFirstName())
					.append("lastName", user.getLastName())
					.append("username", user.getUsername())
					.append("password", user.getPassword())
					.append("email", user.getEmail());
		
		return d;
		
	}
	
	public static User getUser(Document document) {
		
		User user = null;
		user = new User();
		
		System.out.println(document.getString("firstName"));
		
		user.setFirstName(document.getString("firstName"));
		user.setLastName(document.getString("lastName"));
		user.setEmail(document.getString("email"));
		user.setUsername(document.getString("username"));
		user.setPassword(document.getString("password"));
		
		return user;
		
	}

}
