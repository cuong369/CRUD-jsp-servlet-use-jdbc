package com.trancuongifis.controller.manage_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trancuongifis.util.Common;
import com.trancuongifis.util.DbConnection;

public class CheckLogin {

	public static boolean check(String username, String password) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			pst = con.prepareStatement(Common.checkLogin.CHECK);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbConnection.closeConnection(con);
		}
		return false;	
	}

}
