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
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter the customerId");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter the Itemid");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the quantity you would like to add");
		Long quantity = utils.getLong();
		Order order = orderDAO.create(new Order(customerId,itemId,quantity));
		LOGGER.info("Order created! \n");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the Order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please the Itemid");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter new quantity");
		Long Quantity = utils.getLong();
		Order order = orderDAO.update(new Order(id, itemId, Quantity));
		LOGGER.info("Order Updated \n");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Order you would like to delete");
		Long id = utils.getLong();
		LOGGER.info("Order has been deleted! \n");
		return orderDAO.delete(id);
	}

}
