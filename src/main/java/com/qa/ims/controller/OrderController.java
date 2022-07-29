package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO; 
	private Utils utils; 
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();

		return orders;
	}
	@Override
	public Order create() {
		LOGGER.info("Please enter the customerId");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Order created! \n");
		return order;
	}
	@Override
	public Order update() {
			LOGGER.info("Please enter the id of the Order you would like to add an item to");
			Long id = utils.getLong();
			LOGGER.info("Please enter the Itemid you would like to add to your order");
			Long itemId = utils.getLong();
			LOGGER.info("Please enter the quantity you would like");
			Long Quantity = utils.getLong();
			Order order = orderDAO.update(new Order(id, itemId, Quantity));
			LOGGER.info("Item added \n");
			return order;
	}

	@Override
	public int delete() {
		boolean running = true;
		while (running) {
		LOGGER.info("Would you like to delete an Order or an Item?");
		String choice = utils.getString().toLowerCase();
			switch (choice) {
			case "item":
				LOGGER.info("Please enter item ID you would like to delete");
				Long Itemid = utils.getLong();
				LOGGER.info("Item deleted \n");
				running = false;
				return orderDAO.deleteItem(Itemid);
			case "order":
				LOGGER.info("Please enter the id of the Order you would like to delete from your Order");
				Long id = utils.getLong();
				LOGGER.info("Order has been deleted! \n");
				running = false;
				return orderDAO.delete(id);
			default:
				System.out.println("please enter `order` or `item` \n");
				break;
			}
		}
		return 1;
	}

}
