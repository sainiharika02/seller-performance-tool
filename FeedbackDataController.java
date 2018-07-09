package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Feedback;
import com.model.FeedbackBo;

/**
 * Servlet implementation class FeedbackDataController
 */
@WebServlet("/FeedbackDataController")
public class FeedbackDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int seller_id = (Integer)session.getAttribute("seller_id");
		Feedback feedback = new Feedback();
		feedback.setSeller_id(seller_id);
		FeedbackBo feedback_bo = new FeedbackBo();
		String feedback_data = feedback_bo.getFeedback(feedback);
		//System.out.println("DC : "+feedback_data);
		session.setAttribute("feedback", feedback_data);
		//System.out.println("DC : "+session.getAttribute("feedback"));
		RequestDispatcher rd = request.getRequestDispatcher("Feedback.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
