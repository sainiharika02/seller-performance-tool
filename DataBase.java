package com.model;

public class DataBase {
	String Drivername = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/seller_performance_tool";
	String username = "root";
	String password = "123456";
	String login_validation_query = "SELECT * FROM login WHERE username = ? and password = ?";
	String nameQuery = "SELECT * FROM seller_profile where seller_id = ?";
	String deleteProfileQuery = "DELETE FROM seller_profile where seller_id = ?";
	String updateProfileQuery = "INSERT INTO seller_profile(seller_id, name, contact_number, aadhar_number, pancard, account_number, ifsc_code) values(?, ?, ?, ?, ?, ?, ?)";
	String feedbackQuery = "SELECT * FROM customer_feedback WHERE seller_id = ?"; 
	String performanceQuery = "SELECT * FROM seller_performance WHERE seller_id = ?";
	String productTypeQuery = "SELECT product_type FROM products WHERE seller_id = ?";
	String recommendationQuery = "SELECT productintrend FROM recommendation WHERE product_type = ?";
	public String getDrivername() {
		return Drivername;
	}
	public String getUrl() {
		return url;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getNameQuery() {
		return nameQuery;
	}
}
