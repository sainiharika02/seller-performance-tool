package com.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginDAO
 */
@WebServlet("/LoginDAO")
public class LoginDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public int ValidateUser(Login login) {
    		String username = login.getUsername();
    		String password = login.getPassword();
    		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        DataBase database = new DataBase();
        int seller_id = 0;
        try {
            Class.forName(database.getDrivername());
            connection = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
            preparedStatement = connection.prepareStatement(database.login_validation_query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
            		seller_id = resultSet.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return seller_id;
    }
    public LoginDAO() {
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

}
