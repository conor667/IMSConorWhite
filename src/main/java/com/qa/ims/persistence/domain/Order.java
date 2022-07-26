package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long id;
	private Long itemID;
	private Long customerId;
	private Long quantity; 
	private Long totalCost;
	
	public Order(Long id, Long itemID, Long customerId, Long quantity, Long totalCost) {
		super();
		this.id = id;
		this.itemID = itemID;
		this.customerId = customerId;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}
	public Order(Long itemID, Long customerId, Long quantity, Long totalCost) {
		super();
		this.itemID = itemID;
		this.customerId = customerId;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getItemID() {
		return itemID;
	}
	public void setItemID(Long itemID) {
		this.itemID = itemID;
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
	public Long getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", itemID=" + itemID + ", customerId=" + customerId + ", quantity=" + quantity
				+ ", totalCost=" + totalCost + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerId, id, itemID, quantity, totalCost);
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
				&& Objects.equals(itemID, other.itemID) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(totalCost, other.totalCost);
	}

}
