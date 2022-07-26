package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Item modelFromResultSet1(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String Itemname = resultSet.getString("Itemname");
		float price = resultSet.getFloat("price");
		return new Item(id, Itemname, price);
	}
	
	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM item ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Item create(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO items(itemName, price) VALUES (?, ?)");) {
			statement.setString(1, item.getItemname());
			statement.setDouble(2, item.getPrice());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	@Override
	public Item update(Item item) {
		// TODO Auto-generated method stub
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE item SET itemName = ?, price = ? WHERE id = ?");) {
			statement.setString(1, item.getItemname());
			statement.setDouble(2, item.getPrice());
			statement.setLong(3, item.getId());
			statement.executeUpdate();
			return read(item.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
