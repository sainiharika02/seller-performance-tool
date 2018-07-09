package com.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SalesDAO
 */
@WebServlet("/SalesDAO")
public class SalesDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesDAO() {
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
	
	public int getTotalPerformance(Sales sales) {
		int performance = 0;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		DataBase database = new DataBase();
		try {
			int totalsales = 0;
			Class.forName(database.getDrivername());
			connection = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
			preparedStatement = connection.prepareStatement(database.performanceQuery);
			preparedStatement.setInt(1, sales.getSeller_id());
			resultSet = preparedStatement.executeQuery();
		    while (resultSet.next()) {
		    		totalsales = resultSet.getInt(2);
		    		performance += totalsales;
		    		System.out.println(performance+"\n");
		    		for (int i = 3; i <= 7; i ++) {
		    			System.out.println("\n"+performance);
		    			performance -= resultSet.getInt(i);
		    		}
		    }
		    if (totalsales == 0) {
		    		return 0;
		    }
		    performance = (performance  * 100) / totalsales;
		    System.out.println("\nTotal"+performance);
		} catch(Exception e) {
			System.out.println(e);
		}
		return performance;
	}
	
	public int[] getSalesDetails(Sales sales) {
		int sales_details[] = new int[7];
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		DataBase database = new DataBase();
		int k = 0;
		try {
			int totalsales = 0;
			Class.forName(database.getDrivername());
			connection = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
			preparedStatement = connection.prepareStatement(database.performanceQuery);
			preparedStatement.setInt(1, sales.getSeller_id());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				for (int i = 2; i <= 7; i ++) {
					sales_details[k ++] = resultSet.getInt(i);
				}
			}
		} catch(Exception e) {
			System.out.println(e);
		} 
		return sales_details;
	}

}
