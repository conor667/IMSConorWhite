package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long Id = 2L; 
		final Long itemId = 1L;
		final Long customerId = 2L;
		final Long quantity = 2L;
		final double totalCost = 3.99; 
		final Order created = new Order(Id, itemId, customerId, quantity, totalCost);

		Mockito.when(utils.getLong()).thenReturn(Id);
		Mockito.when(utils.getLong()).thenReturn(itemId);
		Mockito.when(utils.getLong()).thenReturn(customerId);
		Mockito.when(utils.getLong()).thenReturn(quantity);
		Mockito.when(utils.getDouble()).thenReturn(totalCost);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(4)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> order = new ArrayList<>();
		order.add(new Order(1L, 1L , 2L, 2L ,3.99));

		Mockito.when(dao.readAll()).thenReturn(order);

		assertEquals(order, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Order updated = new Order(55L, 22L, 32L, 3L ,1.99);

		Mockito.when(this.utils.getLong()).thenReturn(55L);
		Mockito.when(this.utils.getLong()).thenReturn(22L);
		Mockito.when(this.utils.getLong()).thenReturn(32L);
		Mockito.when(this.utils.getLong()).thenReturn(3L);
		Mockito.when(this.utils.getDouble()).thenReturn(1.99);
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(4)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
