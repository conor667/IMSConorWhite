package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
	private Long id;
	private String Itemname;
	private double price;
	private Long stock;

	public Item(String itemname, double price, Long stock) {
		this.setItemname(itemname);
		this.setPrice(price);
		this.setStock(stock);
	}

	public Item(Long id, String Itemname, double price, Long stock) {
		this.setId(id);
		this.setItemname(Itemname);
		this.setPrice(price);
		this.setStock(stock);
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

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", Itemname =" + Itemname + ", price =" + price + ", Stock = " + stock  + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Itemname, id, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;if (obj == null)
				return false;
			if(getClass() != obj.getClass())
				return false;Item other = (Item) obj;
				return Objects.equals(Itemname, other.Itemname) 
						&& Objects.equals(id, other.id)
						&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	public void setQuantity(long long1) {
		// TODO Auto-generated method stub
		
	}
	
}
