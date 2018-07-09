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
 * Servlet implementation class FeedbackDAO
 */
@WebServlet("/FeedbackDAO")
public class FeedbackDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackDAO() {
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
	
	public String retrieveFeedback(Feedback feedback) {
		String feedback_data = "";
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		DataBase database = new DataBase();
		String feedback_to_process;
		ProcessFeedback process_customer_feedback = new ProcessFeedback();
		try {
			Class.forName(database.getDrivername());
			connection = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
			preparedStatement = connection.prepareStatement(database.feedbackQuery);
			preparedStatement.setInt(1, feedback.getSeller_id());
			resultSet = preparedStatement.executeQuery();
		    while (resultSet.next()) {
		    		feedback_data = feedback_data.concat("<li>");
		    	    feedback_to_process = resultSet.getString("feedback");
		        String category = process_customer_feedback.categorize(feedback_to_process);
		    		if (category.equals("negative")) {
		    			feedback_data = feedback_data.concat("<font color='red'>"+feedback_to_process+"</font>");
		    		} else {
		    			feedback_data = feedback_data.concat("<font color='green'>"+feedback_to_process+"</font>");
		    		}
		    		feedback_data = feedback_data.concat("<br></li>");
		    }
		} catch(SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return feedback_data;
	}
	
	public int calculateFeedback(Feedback feedback) {
		int total_feedback = 0;
		int negative_feedback = 0;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		DataBase database = new DataBase();
		ProcessFeedback process_customer_feedback = new ProcessFeedback();
		String feedback_to_process;
		try {
			Class.forName(database.getDrivername());
			connection = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
			preparedStatement = connection.prepareStatement(database.feedbackQuery);
			preparedStatement.setInt(1, feedback.getSeller_id());
			resultSet = preparedStatement.executeQuery();
		    while (resultSet.next()) {
		    		System.out.println("SId"+feedback.getSeller_id());
		    		total_feedback += 1;
		    		feedback_to_process = resultSet.getString("feedback");
		    		String category = process_customer_feedback.categorize(feedback_to_process);
		    		if (category.equals("negative")) {
		    			negative_feedback += 1;
		    		}
		    		
		    	}
		    System.out.println("NF:"+negative_feedback + "\n");
			System.out.println("TF:"+total_feedback + "\n");
		    return (negative_feedback * 10/ total_feedback);
		} catch(Exception e) {
			System.out.println(e);
		}
		/*if (total_feedback == 0) {
			return 0;
		}*/
		return 0;
	}
}
