package com.trancuongifis.controller.products;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trancuongifis.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/delete-product")
public class DeleteProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProductServiceImpl serviceImpl;

	public DeleteProductController() {
		this.serviceImpl = new ProductServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if(username == null || username.isEmpty()) {
			resp.sendRedirect(req.getContextPath());
		}else {
			String custId = req.getParameter("custId");
			if(custId == null || custId.isEmpty()) {
				req.getRequestDispatcher("products").forward(req, resp);
			}else {
				long id = Long.parseLong(custId);
				try {
					serviceImpl.delete(id);
					req.getRequestDispatcher("products").forward(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
}
