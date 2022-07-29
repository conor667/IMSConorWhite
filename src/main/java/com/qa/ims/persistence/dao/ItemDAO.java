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
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("itemId");
		String Itemname = resultSet.getString("Itemname");
		float price = resultSet.getFloat("price");
		Long stock = resultSet.getLong("stock");
		return new Item(id, Itemname, price,stock); 
	}
	
	@Override
	public List<Item> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM item");) {
			List<Item> item = new ArrayList<>();
			while (resultSet.next()) { 
				item.add(modelFromResultSet(resultSet));
			}
			return item;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Item readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM item ORDER BY itemId DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Item create(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO item(itemName, price, stock) VALUES (?, ?, ?)");) {
			statement.setString(1, item.getItemname());
			statement.setDouble(2, item.getPrice());
			statement.setLong(3, item.getStock());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.error(e.getMessage()); 
		}
		return null;
	}
	@Override
	public Item update(Item item) {
		// TODO Auto-generated method stub
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE item SET itemName = ?, price = ?, stock = ? WHERE itemId = ?");) {
			statement.setString(1, item.getItemname());
			statement.setDouble(2, item.getPrice());
			statement.setLong(3,item.getStock());
			statement.setLong(4, item.getId());
			statement.executeUpdate();
			return read(item.getId());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return item;
	}
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM item WHERE itemId = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	@Override
	public Item read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM item WHERE itemId = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public Order modelFromResultSet2(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
