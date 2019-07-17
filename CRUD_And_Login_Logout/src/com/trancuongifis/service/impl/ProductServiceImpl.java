package com.trancuongifis.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.trancuongifis.dao.ProductsDao;
import com.trancuongifis.dao.impl.ProductsDaoImpl;
import com.trancuongifis.model.Products;

public class ProductServiceImpl implements ProductsDao<Products>{

	private ProductsDaoImpl productDaoImpl;
	
	public ProductServiceImpl() {
		this.productDaoImpl = new ProductsDaoImpl();
	}
	
	@Override
	public List<Products> findAll() throws SQLException {
		List<Products> listProducts = productDaoImpl.findAll();
		return listProducts;
	}

	@Override
	public Products findById(long id) throws SQLException {
		Products products = productDaoImpl.findById(id);
		return products;
	}

	@Override
	public boolean insert(Products obj) throws SQLException {
		boolean check = productDaoImpl.insert(obj);
		return check;
	}

	@Override
	public boolean update(Products obj) throws SQLException {
		boolean check = productDaoImpl.update(obj);
		return check;
	}

	@Override
	public boolean delete(long id) throws SQLException {
		boolean check = productDaoImpl.delete(id);
		return check;
	}

	@Override
	public List<Products> filter(String filterSequence) throws SQLException {
		List<Products> listFilterProducts = productDaoImpl.filter(filterSequence);
		return listFilterProducts;
	}

}
