package com.trancuongifis.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.trancuongifis.dao.impl.LoginDaoImpl;
import com.trancuongifis.model.Login;
import com.trancuongifis.service.LoginService;

public class LoginSercviceImpl implements LoginService<Login>{

	private LoginDaoImpl loginDaoImpl;
	
	public LoginSercviceImpl() {
		this.loginDaoImpl = new LoginDaoImpl();
	}

	@Override
	public List<Login> findAll() throws SQLException {
		List<Login> listLogin = loginDaoImpl.findAll();
		return listLogin;
	}

	@Override
	public Login findById(long id) throws SQLException {
		Login login = loginDaoImpl.findById(id);
		return login;
	}

	@Override
	public boolean insert(Login obj) throws SQLException {
		boolean check = loginDaoImpl.insert(obj);
		return check;
	}

	@Override
	public boolean update(Login obj) throws SQLException {
		boolean check = loginDaoImpl.update(obj);
		return check;
	}

	@Override
	public boolean delete(long id) throws SQLException {
		boolean check = loginDaoImpl.delete(id);
		return check;
	}

	@Override
	public List<Login> filter(String filterSequence) throws SQLException {
		List<Login> listFilterLogin = loginDaoImpl.filter(filterSequence);
		return listFilterLogin;
	}

}
