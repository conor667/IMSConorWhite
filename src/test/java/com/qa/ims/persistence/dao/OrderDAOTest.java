package com.qa.ims.persistence.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();
 
	@BeforeEach  
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	} 
	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, 1L, 2L);
		assertEquals(updated, DAO.update(updated));
	} 
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	@Test
	public void testDeleteItem() {
		assertEquals(1, DAO.deleteItem(1));
	}
	@Test
	public void testCreate() {
		final Order order = new Order(1L,1L);
		assertEquals(order, DAO.create(order));
	}
	
	@Test 
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}
}

