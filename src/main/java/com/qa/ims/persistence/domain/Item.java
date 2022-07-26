package com.qa.ims.persistence.domain;

public class Item {
	private Long id;
	private String Itemname;
	private float price;

	public Item(String firstName, String surname) {
		this.setItemname(Itemname);
		this.setPrice(price);
	}

	public Item(Long id, String Itemname, float price) {
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
