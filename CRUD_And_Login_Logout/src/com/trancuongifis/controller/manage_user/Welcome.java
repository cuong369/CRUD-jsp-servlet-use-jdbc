package com.trancuongifis.controller.manage_user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trancuongifis.model.Login;
import com.trancuongifis.service.impl.LoginSercviceImpl;

@WebServlet(urlPatterns = "/welcome")
public class Welcome extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private LoginSercviceImpl loginServiceImpl;

	public Welcome() {
		this.loginServiceImpl = new LoginSercviceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		
		if(username == null || username == "") {
			resp.sendRedirect("login.jsp");
		}else {
			try {
				List<Login> listUser = loginServiceImpl.findAll();
				req.setAttribute("listUser", listUser);
				req.getRequestDispatcher("welcome.jsp").forward(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
