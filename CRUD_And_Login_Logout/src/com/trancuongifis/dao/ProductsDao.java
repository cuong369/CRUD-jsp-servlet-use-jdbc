package com.trancuongifis.dao;

import java.sql.SQLException;
import java.util.List;

public interface ProductsDao <T>{

	// find all object type T
	List<T> findAll() throws SQLException;

	// find by id object type T
	T findById(long id) throws SQLException;

	// insert a object type T
	boolean insert(T obj) throws SQLException;

	// update a object type T
	boolean update(T obj) throws SQLException;

	// delete a object type T
	boolean delete(long id) throws SQLException;

	// filter search objects type T by String sequence
	List<T> filter(String filterSequence) throws SQLException;
}
