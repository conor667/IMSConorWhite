package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("OrderId");
		Long customerId = resultSet.getLong("customerId");
		return new Order(id, customerId);   
	}
	@Override
	public Order modelFromResultSet2(ResultSet resultSet) throws SQLException {
		Double totalCost = resultSet.getDouble("TotalCost");
		return new Order(totalCost);
	}
	@Override
	public List<Order> readAll() { 
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `order` o JOIN OrderedItems oi ON o.OrderId=oi.fk_OrderId JOIN item i ON i.itemId=oi.fk_itemId JOIN customers c ON c.id=o.CustomerId");) {
			List<Order> order = new ArrayList<>();
			while (resultSet.next()) {
				order.add(modelFromResultSet(resultSet));
				LOGGER.info("OrderId: " + resultSet.getLong("OrderId") +
						"|Item: " + resultSet.getString("itemName") + 
						"| customerId: " + resultSet.getLong("CustomerId") +
						"| Cusomer Name: " + resultSet.getString("first_name") + " " + resultSet.getString("surname") +
						"| Quantity: " + resultSet.getLong("Quantity")); 
			}				
			//return order;
		} catch (SQLException e) { 
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT item.price*OrderedItems.Quantity as TotalCost FROM item,OrderedItems WHERE item.itemId=OrderedItems.fk_itemId;");) {
			List<Order> order = new ArrayList<>();
			while (resultSet.next()) {  
				order.add(modelFromResultSet2(resultSet));
				LOGGER.info("| TotalCost : " + resultSet.getDouble("TotalCost"));
			}
			return order;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	@Override
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `order`");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} 
		return null; 
	}
	@Override
	public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM `order` WHERE OrderId = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO `order`(CustomerId) VALUES (?)");) {
			statement.setLong(1, order.getCustomerId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO `OrderedItems` (fk_OrderId,fk_itemId, Quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, order.getId());
			statement.setLong(2, order.getItemId());
			statement.setLong(3, order.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return order; 
	} 
	
	public int deleteItem(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM OrderedItems WHERE fk_OrderId = ?");) {
			statement.setLong(1, id);
			statement.executeUpdate(); 
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 1;
	}
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM OrderedItems WHERE fk_OrderId = ?");) {
			statement.setLong(1, id);
			statement.executeUpdate(); 
		} catch (Exception e) { 
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM `order` WHERE OrderId = ?");) {
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 1;
	}
}
