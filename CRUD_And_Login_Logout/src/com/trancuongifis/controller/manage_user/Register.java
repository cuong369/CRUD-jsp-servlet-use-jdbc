package com.trancuongifis.controller.manage_user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trancuongifis.model.Login;
import com.trancuongifis.service.impl.LoginSercviceImpl;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LoginSercviceImpl loginServiceImpl;

	public Register() {
		this.loginServiceImpl = new LoginSercviceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custid = req.getParameter("custId");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Login login = new Login(name, email, username, password);
		
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		if(custid == null || custid.isEmpty()) {
			if (name == null || email == null || username == null || password == null || name == "" || email == ""
					|| username == "" || password == "") {
				printWriter.println("Field: name, email, username, password. That all must not null and empty !!!");
				req.getRequestDispatcher("register.jsp").include(req, resp);
			}else {
				boolean check;
				try {
					check = loginServiceImpl.insert(login);
					if (check == true) {
						printWriter.println("Register success !!!");
						req.getRequestDispatcher("register.jsp").include(req, resp);
					} else {
						printWriter.println("Register fail. Please register again !!!");
						req.getRequestDispatcher("register.jsp").include(req, resp);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			long id = Long.parseLong(custid);
			login.setId(id);
			try {
				loginServiceImpl.update(login);
				req.getRequestDispatcher("welcome").forward(req, resp);
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
