package com.trancuongifis.controller.manage_user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password  =req.getParameter("password");
		
		if(CheckLogin.check(username, password)) {
			req.getSession().setAttribute("username", username);
//			req.getSession().setAttribute("password", password);
			resp.sendRedirect("welcome");
//			req.getRequestDispatcher("welcome").forward(req, resp);
		}else {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
