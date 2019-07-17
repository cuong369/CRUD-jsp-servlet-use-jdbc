package com.trancuongifis.controller.products;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trancuongifis.model.Products;
import com.trancuongifis.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/products")
public class HomeProducts extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ProductServiceImpl serviceImpl;
	
	public HomeProducts() {
		this.serviceImpl = new ProductServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if(username == null || username.isEmpty()) {
			resp.sendRedirect(req.getContextPath());
		}else {
			try {
				List<Products> listProducts = serviceImpl.findAll();
				req.setAttribute("listProducts", listProducts);
				
				req.getRequestDispatcher("ListProducts.jsp").forward(req, resp);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
