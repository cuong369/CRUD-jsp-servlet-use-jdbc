package com.trancuongifis.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trancuongifis.dao.LoginDao;
import com.trancuongifis.model.Login;
import com.trancuongifis.util.Common;
import com.trancuongifis.util.DbConnection;

public class LoginDaoImpl implements LoginDao<Login> {

	@Override
	public List<Login> findAll() throws SQLException {
		List<Login> listLogin = new ArrayList<Login>();
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Login.SELECT_ALL);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Login login = new Login();

			login.setId(rs.getLong(Common.Login.ID));
			login.setName(rs.getString(Common.Login.NAME));
			login.setEmail(rs.getString(Common.Login.EMAIL));
			login.setUsername(rs.getString(Common.Login.USERNAME));
			login.setPassword(rs.getString(Common.Login.PASSWORD));

			listLogin.add(login);
		}

		rs.close();
		pst.close();
		DbConnection.closeConnection(con);

		return listLogin;
	}

	@Override
	public Login findById(long id) throws SQLException {
		Login login = new Login();
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Login.SELECT_ONE);
		pst.setLong(1, id);
		ResultSet rs = pst.executeQuery();

		while(rs.next()) {
			login.setId(rs.getLong(Common.Login.ID));
			login.setName(rs.getString(Common.Login.NAME));
			login.setEmail(rs.getString(Common.Login.EMAIL));
			login.setUsername(rs.getString(Common.Login.USERNAME));
			login.setPassword(rs.getString(Common.Login.PASSWORD));			
		}

		rs.close();
		pst.close();
		DbConnection.closeConnection(con);

		return login;
	}

	@Override
	public boolean insert(Login obj) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Login.INSERT);

		pst.setString(1, obj.getName());
		pst.setString(2, obj.getEmail());
		pst.setString(3, obj.getUsername());
		pst.setString(4, obj.getPassword());

		boolean check = pst.executeUpdate() > 0;

		pst.close();
		DbConnection.closeConnection(con);

		return check;
	}

	@Override
	public boolean update(Login obj) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Login.UPDATE);

		pst.setString(1, obj.getName());
		pst.setString(2, obj.getEmail());
		pst.setString(3, obj.getUsername());
		pst.setString(4, obj.getPassword());
		pst.setLong(5, obj.getId());

		boolean check = pst.executeUpdate() > 0;

		pst.close();
		DbConnection.closeConnection(con);

		return check;
	}

	@Override
	public boolean delete(long id) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Login.DELETE);

		pst.setLong(1, id);

		boolean check = pst.executeUpdate() > 0;

		pst.close();
		DbConnection.closeConnection(con);

		return check;
	}

	@Override
	public List<Login> filter(String filterSequence) throws SQLException {
		List<Login> listFilterLogin = new ArrayList<Login>();
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Common.Login.FILTER);
		filterSequence = "%"+filterSequence+"%";
		pst.setString(1, filterSequence);
		pst.setString(2, filterSequence);
		pst.setString(3, filterSequence);
		pst.setString(4, filterSequence);
		pst.setString(5, filterSequence);
		
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Login login = new Login();

			login.setId(rs.getLong(Common.Login.ID));
			login.setName(rs.getString(Common.Login.NAME));
			login.setEmail(rs.getString(Common.Login.EMAIL));
			login.setUsername(rs.getString(Common.Login.USERNAME));
			login.setPassword(rs.getString(Common.Login.PASSWORD));

			listFilterLogin.add(login);
		}

		rs.close();
		pst.close();
		DbConnection.closeConnection(con);

		return listFilterLogin;
	}

}
