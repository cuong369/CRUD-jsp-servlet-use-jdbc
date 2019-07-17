package com.trancuongifis.model;

public class Products {

	private long id;
	private String name;
	private long quantity;
	private double price;
	private long longin_id;

	public Products() {

	}

	public Products(String name, long quantity, double price, long longin_id) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.longin_id = longin_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getLongin_id() {
		return longin_id;
	}

	public void setLongin_id(long longin_id) {
		this.longin_id = longin_id;
	}

}
