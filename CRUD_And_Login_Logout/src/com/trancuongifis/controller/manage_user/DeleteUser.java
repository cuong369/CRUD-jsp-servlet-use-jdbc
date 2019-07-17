package com.trancuongifis.controller.manage_user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trancuongifis.service.impl.LoginSercviceImpl;

@WebServlet(urlPatterns = "/delete")
public class DeleteUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LoginSercviceImpl loginServiceImpl;

	public DeleteUser() {
		this.loginServiceImpl = new LoginSercviceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null || username.isEmpty()) {
			resp.sendRedirect("login");
		} else {
			String custId = req.getParameter("custId");
			if (custId == null || custId.isEmpty()) {
				req.getRequestDispatcher("welcome").forward(req, resp);
			} else {
				long id = Long.parseLong(custId);
				try {
					loginServiceImpl.delete(id);
					resp.sendRedirect(req.getContextPath() + "/welcome");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
