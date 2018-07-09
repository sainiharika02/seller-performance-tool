package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Feedback;
import com.model.FeedbackBo;
import com.model.Login;
import com.model.LoginBo;
import com.model.Recommendation;
import com.model.RecommendationBo;
import com.model.Sales;
import com.model.SalesBo;
import com.model.SellerProfile;
import com.model.SellerProfileBo;
/**
 * Servlet implementation class SelerDataController
 */
@WebServlet("/SellerDataController")
public class SellerDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SellerDataController() {
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
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		LoginBo login_bo = new LoginBo();
		int seller_id = login_bo.isSuccessfulLogin(login);
		if (seller_id > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("seller_id", seller_id);
			SellerProfile profile = new SellerProfile();
			profile.setSeller_id(seller_id);
			SellerProfileBo data = new SellerProfileBo();
			int health = data.getHealthPercentage(profile);
			session.setAttribute("health", health);
			
		    String list[] = data.getProfile(profile);
		    session.setAttribute("name", list[0]);
		    session.setAttribute("contact", list[1]);
		    session.setAttribute("aadhar", list[2]);
		    session.setAttribute("pancard", list[3]);
		    session.setAttribute("account_number", list[4]);
		    session.setAttribute("ifsc_code", list[5]);
			//session.setAttribute("name", name);
		    Sales sales = new Sales();
			sales.setSeller_id(seller_id);
			SalesBo sales_bo = new SalesBo();
			int performance = sales_bo.calculatePerformance(sales);
			//System.out.println("Performance : "+performance);
			Feedback feedback = new Feedback();
			FeedbackBo feedback_bo = new FeedbackBo();
			feedback.setSeller_id(seller_id);
			performance = performance - feedback_bo.calculate(feedback);
			session.setAttribute("performance", performance);
			if (performance < 80) {
				Recommendation recommendation = new Recommendation();
				recommendation.setSeller_id(seller_id);
				RecommendationBo recommendation_bo = new RecommendationBo();
				String recommend_user = recommendation_bo.getRecommendation(recommendation);
				session.setAttribute("recommendation", recommend_user);
			}
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
		} else {
			out.println("<font color='red'>Invalid Credentials<br></font>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
	}

}
