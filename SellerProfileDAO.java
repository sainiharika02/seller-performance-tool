package com.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SellerProfileDAO
 */
@WebServlet("/SellerProfileDAO")
public class SellerProfileDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerProfileDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public int calculateHealth(SellerProfile profile) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		DataBase database = new DataBase();
		int totalParameters = 6;
		int filledParameters = 0;
		int health = 0;
		try {
			Class.forName(database.getDrivername());
			connection = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
			preparedStatement = connection.prepareStatement(database.getNameQuery());
			preparedStatement.setInt(1, profile.getSeller_id());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				for (int i = 2; i <= 7; i ++) {
					if (resultSet.getString(i) != null) {
						filledParameters ++;
					}
				}
			}
			//Formula for calculating health;
			health = filledParameters * 100 / totalParameters;
		} catch(SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return health;
	}
	
	public String[] getSellerProfile(SellerProfile profile) {
		String list[] = new String[6];
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		DataBase database = new DataBase();
		String name = "";
		try {
			Class.forName(database.getDrivername());
			connection = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
			preparedStatement = connection.prepareStatement(database.getNameQuery());
			preparedStatement.setInt(1, profile.getSeller_id());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				list[0] = resultSet.getString("name");
				list[1] = resultSet.getString("contact_number");
				list[2] = resultSet.getString("aadhar_number");
				list[3] = resultSet.getString("pancard");
				list[4] = resultSet.getString("account_number");
				list[5] = resultSet.getString("ifsc_code");		
			}
		} catch(SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean updateProfile(SellerProfile profile) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		DataBase database = new DataBase();
		String name = "";
		try {
			Class.forName(database.getDrivername());
			connection = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
			preparedStatement = connection.prepareStatement(database.deleteProfileQuery);
			preparedStatement.setInt(1, profile.getSeller_id());
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(database.updateProfileQuery);
			preparedStatement.setInt(1, profile.getSeller_id());
			String value = profile.getName();
			if (value == "") {
				value = null;
			}
			preparedStatement.setString(2, value);
			value = profile.getContact_number();
			if (value == "") {
				value = null;
			}
			preparedStatement.setString(3, value);
			value = profile.getAadhar_number();
			if (value == "") {
				value = null;
			}
			preparedStatement.setString(4, value);
			value = profile.getPancard();
			if (value == "") {
				value = null;
			}
			preparedStatement.setString(5, value);
			value = profile.getAccount_number();
			if (value == "") {
				value = null;
			}
			preparedStatement.setString(6, value);
			value = profile.getIfsc_code();
			if (value == "") {
				value = null;
			}
			preparedStatement.setString(7, value);
			preparedStatement.executeUpdate();
			return true;
		} catch(SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
