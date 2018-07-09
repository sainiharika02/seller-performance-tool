package com.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedbackBo
 */
@WebServlet("/FeedbackBo")
public class FeedbackBo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackBo() {
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
	
	public String getFeedback(Feedback feedback) {
		FeedbackDAO feedback_dao = new FeedbackDAO();
		return feedback_dao.retrieveFeedback(feedback);
	}

	public int calculate(Feedback feedback) {
		FeedbackDAO feedback_dao = new FeedbackDAO();
		System.out.println("Feedback %"+feedback_dao.calculateFeedback(feedback));
		return feedback_dao.calculateFeedback(feedback);
	}
}
