package com.papafranku.entities;

import com.papafranku.entities.ResponseStatus;

public class Item extends ResponseStatus {
	
	private String itemCode;
	private int quantity;
	private double price;
	
	public Item() {
		super();
	}
	
	public Item(String itemCode, int quantity, double price) {
		super();
		
		this.itemCode = itemCode;
		this.price = price;
		this.quantity = quantity;
		
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
