package com.trancuongifis.controller.products;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trancuongifis.model.Products;
import com.trancuongifis.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/add_edit")
public class AddEditController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ProductServiceImpl serviceImpl;

	public AddEditController() {
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
			String name = req.getParameter("name");
			String quantity = req.getParameter("quantity");
			String price = req.getParameter("price");
			String longin_id = req.getParameter("longin_id");
			
			long qty = Long.parseLong(quantity);
			double values = Double.parseDouble(price);
			long idLog = Long.parseLong(longin_id);
			
			Products products = new Products(name, qty, values, idLog);
			
			if(custId == null || custId.isEmpty()) {
				try {
					serviceImpl.insert(products);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				long id = Long.parseLong(custId);
				products.setId(id);
				try {
					serviceImpl.update(products);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			resp.sendRedirect(req.getContextPath() + "/products");
		}
	}
}
