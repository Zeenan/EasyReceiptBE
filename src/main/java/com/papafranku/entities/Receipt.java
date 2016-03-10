package com.papafranku.entities;

import java.util.List;

import com.papafranku.entities.ResponseStatus;

public class Receipt extends ResponseStatus {
	
	private String owner;
	private String issuer; // using strings for now and not ids becacse fuck
	
	private long id;
	private long vatRegTin;
	private long pn;
	private String serialNumber;
	
	private List<Item> items;
	private double amountPaid;
	private double total = 0;
	private double change = 0;
	private double vatCost = 0;
	private double vatSale = 0; // amount with no vat
	private double vatPercent = 0;
	
	public Receipt() {
		super();
	}
	
	public Receipt(String owner, String issuer, long id, long vatRegTin, long pn, String serialNumber) {
		super();
		
		this.owner = owner;
		this.issuer = issuer;
		
		this.id = id;
		this.vatRegTin = vatRegTin;
		this.pn = pn;
		this.serialNumber = serialNumber;
		
	}
	
	public Receipt(String owner, String issuer, long id, long vatRegTin, long pn, String serialNumber,
			List<Item> items, double amountPaid, double vatPercent) {
		super();
		
		this.owner = owner;
		this.issuer = issuer;
		
		this.id = id;
		this.vatRegTin = vatRegTin;
		this.pn = pn;
		this.serialNumber = serialNumber;
		this.items = items;
		this.amountPaid = amountPaid;
		this.vatPercent = vatPercent;
		
		calculateReceipt();
		
	}
	
	private void calculateReceipt() {
		
		for (Item i : this.items) {
			
			this.total += (i.getPrice() * i.getQuantity());
			
		}
		
		double check = this.amountPaid - this.total;
		this.change = (check > 0) ? change : 0;
		
		this.vatCost = this.total * this.vatPercent;
		this.vatSale = this.total - this.vatCost;
		
	}
	
	//BECAUSE I HAVE NO TIME TO MAKE FACTORIES

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVatRegTin() {
		return vatRegTin;
	}

	public void setVatRegTin(long vatRegTin) {
		this.vatRegTin = vatRegTin;
	}

	public long getPn() {
		return pn;
	}

	public void setPn(long pn) {
		this.pn = pn;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public double getVatCost() {
		return vatCost;
	}

	public void setVatCost(double vatCost) {
		this.vatCost = vatCost;
	}

	public double getVatSale() {
		return vatSale;
	}

	public void setVatSale(double vatSale) {
		this.vatSale = vatSale;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	

}
