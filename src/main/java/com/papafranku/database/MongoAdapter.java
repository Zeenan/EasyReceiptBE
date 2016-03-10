package com.papafranku.database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.papafranku.entities.Item;
import com.papafranku.entities.Receipt;
import com.papafranku.entities.User;
import com.papafranku.utilities.WebUtilities;

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
	
	public void seedReceipts() throws Exception  {
		
		List<Document> receipts = new ArrayList();
		Receipt receipt = null;
		
		List<Item> items = new ArrayList<Item>();
		
		Item item = new Item();
		item.setItemCode("NESCAFE3IN1BROWNNCRE");
		item.setQuantity(1);
		item.setPrice(180.00);
		
		items.add(item);
		
		item = new Item();
		item.setItemCode("NESCAFE CLASSIC STIC");
		item.setQuantity(1);
		item.setPrice(93.75);
		
		items.add(item);
		
		item = new Item();
		item.setItemCode("JNJOHMSTYBBQ40G");
		item.setQuantity(1);
		item.setPrice(16.00);
		
		items.add(item);
		
		
		receipt = new Receipt("ethanSonza", "JOLLIBEE-SM-AYALA", 112330923L, 219294991376L, 0L,
				"CSH016238", items, 1000, 0.05);
		
		Document d = MongoUtilities.convert(receipt);
		receipts.add(d);
		
		items = new ArrayList<Item>();
		
		item = new Item();
		item.setItemCode("Minecraft-account");
		item.setQuantity(1);
		item.setPrice(2350.00);
		
		items.add(item);
		
		receipt = new Receipt("ethanSonza", "MINECRAFT", 23563099L, 7723594L, 0L,
				"PURC-9238UBD", items, 2500, 0.05);
		
		d = MongoUtilities.convert(receipt);
		receipts.add(d);
		
		try {
		
		db.getCollection("receipts").insertMany(receipts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
