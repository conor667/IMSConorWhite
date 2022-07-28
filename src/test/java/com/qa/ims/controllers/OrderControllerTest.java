package com.qa.ims.controllers;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest { 

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long customerId = 1L;
		final Order order = new Order(customerId);
;
		Mockito.when(utils.getLong()).thenReturn(customerId);
		Mockito.when(dao.create(order)).thenReturn(order);
		
		Assertions.assertEquals(order, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(order);
	}
	@Test
	public void testReadAll() {
		List<Order> order = new ArrayList<>();
		order.add(new Order(1L, 1L));

		Mockito.when(dao.readAll()).thenReturn(order);

		assertEquals(order, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	@Test
	public void testUpdate() {
		Order order = new Order(1L, 1L, 1L);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.dao.update(order)).thenReturn(order);

		assertEquals(order, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(3)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(order);
	}
	@Test
	public void testDelete() {
		final long Id = 1L;

		Mockito.when(utils.getLong()).thenReturn(Id);
		Mockito.when(dao.delete(Id)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(Id);
	}
}
