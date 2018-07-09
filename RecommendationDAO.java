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
 * Servlet implementation class RecommendationDAO
 */
@WebServlet("/RecommendationDAO")
public class RecommendationDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendationDAO() {
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
	public String getRecommendation(Recommendation recommendation) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		DataBase database = new DataBase();
		int seller_id = 0;
		try {
			String producttype = null;
			Class.forName(database.getDrivername());
			connection = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
			preparedStatement = connection.prepareStatement(database.productTypeQuery);
			preparedStatement.setInt(1, recommendation.getSeller_id());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				producttype = resultSet.getString("product_type");
			}
			preparedStatement = connection.prepareStatement(database.recommendationQuery);
			preparedStatement.setString(1, producttype);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("productintrend");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
