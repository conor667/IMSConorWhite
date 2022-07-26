package com.qa.ims.persistence.domain;

public class Item {
	private Long id;
	private String Itemname;
	private double price;

	public Item(String itemname, double price) {
		this.setItemname(itemname);
		this.setPrice(price);
	}

	public Item(Long id, String Itemname, double price) {
		this.setId(id);
		this.setItemname(Itemname);
		this.setPrice(price);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemname() {
		return Itemname;
	}

	public void setItemname(String Itemname) {
		this.Itemname = Itemname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
