package com.trancuongifis.util;

public interface Common {

	interface TableName {
		public static final String LOGIN = "Login";
		public static final String PRODUCTS = "Products";
	}

	interface Login {
		// Query
		public static final String SELECT_ALL = "SELECT * FROM crud_login_logout_registration.login;";
		public static final String SELECT_ONE = "SELECT * FROM crud_login_logout_registration.login WHERE id = ?;";
		public static final String INSERT = "INSERT INTO `crud_login_logout_registration`.`login` (`name`, `email`, `username`, `password`) VALUES (?, ?, ?, ?);";
		public static final String UPDATE = "UPDATE `crud_login_logout_registration`.`login` SET `name` = ?, `email` = ?, `username` = ?, `password` = ? WHERE (`id` = ?);";
		public static final String DELETE = "DELETE FROM `crud_login_logout_registration`.`login` WHERE (`id` = ?);";
		public static final String FILTER = "SELECT * FROM crud_login_logout_registration.login WHERE id like ? or name like ? or username like ? or password like ? or password like ?;";

		// Attribute
		public static final String ID = "id";
		public static final String NAME = "name";
		public static final String EMAIL = "email";
		public static final String USERNAME = "username";
		public static final String PASSWORD = "password";
	}

	interface Products {
		// Query
		public static final String SELECT_ALL = "SELECT * FROM crud_login_logout_registration.products;";
		public static final String SELECT_ONE = "SELECT * FROM crud_login_logout_registration.products WHERE id = ?;";
		public static final String INSERT = "INSERT INTO `crud_login_logout_registration`.`products` (`name`, `qty`, `price`, `login_id`) VALUES (?, ?, ?, ?);";
		public static final String UPDATE = "UPDATE `crud_login_logout_registration`.`products` SET `name` = ?, `qty` = ?, `price` = ?, `login_id` = ? WHERE (`id` = ?);";
		public static final String DELETE = "DELETE FROM `crud_login_logout_registration`.`products` WHERE (`id` = ?);";
		public static final String FILTER = "SELECT * FROM crud_login_logout_registration.products WHERE id like ? or name like ? or qty like ? or price like ? or login_id like ?;";

		// Attribute
		public static final String ID = "id";
		public static final String NAME = "name";
		public static final String QUANTITY = "qty";
		public static final String PRICE = "price";
		public static final String LOGIN_ID = "login_id";
	}
	
	interface checkLogin{
		public static final String CHECK = "SELECT username, password FROM crud_login_logout_registration.login WHERE username = ? and password = ?;";
	}
}
