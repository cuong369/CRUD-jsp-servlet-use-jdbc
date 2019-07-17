package com.trancuongifis.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trancuongifis.dao.ProductsDao;
import com.trancuongifis.model.Products;
import com.trancuongifis.util.Common;
import com.trancuongifis.util.DbConnection;

public class ProductsDaoImpl implements ProductsDao<Products> {

	@Override
	public List<Products> findAll() throws SQLException {
		List<Products> listProducts = new ArrayList<Products>();
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Products.SELECT_ALL);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Products products = new Products();
			products.setId(rs.getLong(Common.Products.ID));
			products.setName(rs.getString(Common.Products.NAME));
			products.setQuantity(rs.getLong(Common.Products.QUANTITY));
			products.setPrice(rs.getDouble(Common.Products.PRICE));
			products.setLongin_id(rs.getLong(Common.Products.LOGIN_ID));

			listProducts.add(products);
		}

		rs.close();
		pst.close();
		DbConnection.closeConnection(con);

		return listProducts;
	}

	@Override
	public Products findById(long id) throws SQLException {
		Products products = new Products();
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Products.SELECT_ONE);
		pst.setLong(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			products.setId(rs.getLong(Common.Products.ID));
			products.setName(rs.getString(Common.Products.NAME));
			products.setQuantity(rs.getLong(Common.Products.QUANTITY));
			products.setPrice(rs.getDouble(Common.Products.PRICE));
			products.setLongin_id(rs.getLong(Common.Products.LOGIN_ID));
		}

		rs.close();
		pst.close();
		DbConnection.closeConnection(con);

		return products;
	}

	@Override
	public boolean insert(Products obj) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Products.INSERT);
		pst.setString(1, obj.getName());
		pst.setLong(2, obj.getQuantity());
		pst.setDouble(3, obj.getPrice());
		pst.setLong(4, obj.getLongin_id());

		boolean check = pst.executeUpdate() > 0;

		pst.close();
		DbConnection.closeConnection(con);

		return check;
	}

	@Override
	public boolean update(Products obj) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Products.UPDATE);
		pst.setString(1, obj.getName());
		pst.setLong(2, obj.getQuantity());
		pst.setDouble(3, obj.getPrice());
		pst.setLong(4, obj.getLongin_id());
		pst.setLong(5, obj.getId());

		boolean check = pst.executeUpdate() > 0;

		pst.close();
		DbConnection.closeConnection(con);

		return check;
	}

	@Override
	public boolean delete(long id) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Products.DELETE);

		pst.setLong(1, id);

		boolean check = pst.executeUpdate() > 0;

		pst.close();
		DbConnection.closeConnection(con);

		return check;
	}

	@Override
	public List<Products> filter(String filterSequence) throws SQLException {
		List<Products> listFilterProducts = new ArrayList<Products>();
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Products.FILTER);

		filterSequence = "%" + filterSequence + "%";

		pst.setString(1, filterSequence);
		pst.setString(2, filterSequence);
		pst.setString(3, filterSequence);
		pst.setString(4, filterSequence);
		pst.setString(5, filterSequence);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			Products products = new Products();
			products.setId(rs.getLong(Common.Products.ID));
			products.setName(rs.getString(Common.Products.NAME));
			products.setQuantity(rs.getLong(Common.Products.QUANTITY));
			products.setPrice(rs.getDouble(Common.Products.PRICE));
			products.setLongin_id(rs.getLong(Common.Products.LOGIN_ID));

			listFilterProducts.add(products);
		}

		rs.close();
		pst.close();
		DbConnection.closeConnection(con);

		return listFilterProducts;
	}

}
