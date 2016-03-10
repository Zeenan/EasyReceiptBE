package com.papafranku.database;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import static java.util.Arrays.asList;

import org.bson.Document;

import com.papafranku.entities.User;

public class MongoUtilities {
	
	public static Document convert(Object data) {
		
		Document d = null;
		
		Field[] fields = data.getClass().getDeclaredFields();

		d = new Document();
		try {
			for (Field field : fields) {
				
				field.setAccessible(true);
				
				//System.out.println(field.getType());
				
				if (Collection.class.isAssignableFrom(field.getType())){
					
					List innerList = (List) field.get(data);
					List<Document> list = new ArrayList();
					Document listDocument = null;
					
					
					for (Object member : innerList) {
						
						listDocument = new Document();
						
						Field[] innerFields = member.getClass().getDeclaredFields();
						
						for (Field innerField : innerFields) {
							
							innerField.setAccessible(true);
							
							System.out.println(innerField.getName() + " " + innerField.get(member));
							
							listDocument.append(innerField.getName(), innerField.get(member));
						}
						list.add(listDocument);
					}

					d.append(field.getName(), list);
					
				} else {
					d.append(field.getName(), field.get(data));
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	
	
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
