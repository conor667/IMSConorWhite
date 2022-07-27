package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long id;
	private Long itemId;
	private Long customerId;
	private Long quantity; 
	private double totalCost;
	
	public Order(Long id, Long customerId, Long itemId, Long quantity, double totalCost) {
		this.id = id;
		this.itemId = itemId;
		this.customerId = customerId;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}
	public Order(Long itemId, Long customerId, Long quantity, double totalCost) {
		this.itemId = itemId;
		this.customerId = customerId;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}
;
	public Order(Long id, Long itemId) {
		this.id = id;
		this.itemId = itemId;
	}
	public Order(Long id, Long itemId, Long quantity) {
		this.id = id;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	public Order(Long customerId) {
		this.customerId = customerId;
	}
	public Order(Double totalCost) {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "Order [id= " + getId() + ", itemID= " + getItemId() + ", customerId= " + getCustomerId() + ", quantity=" + getQuantity()
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerId, id, itemId, quantity, totalCost);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(id, other.id)
				&& Objects.equals(itemId, other.itemId) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(totalCost, other.totalCost);
	}

}
