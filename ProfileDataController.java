package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.SellerProfile;
import com.model.SellerProfileBo;

/**
 * Servlet implementation class ProfileDataController
 */
@WebServlet("/ProfileDataController")
public class ProfileDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileDataController() {
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
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String aadhar = request.getParameter("aadhar");
		String pancard = request.getParameter("pancard");
		String account_number = request.getParameter("account_number");
		String ifsc_code = request.getParameter("ifsc_code");
		SellerProfile profile = new SellerProfile();
		HttpSession session = request.getSession();
		int seller_id = (Integer)session.getAttribute("seller_id");
		profile.setSeller_id(seller_id);
		profile.setName(name);
		profile.setContact_number(contact);
		profile.setAadhar_number(aadhar);
		profile.setPancard(pancard);
		profile.setAccount_number(account_number);
		profile.setIfsc_code(ifsc_code);
		SellerProfileBo data = new SellerProfileBo();
		if (data.completeProfile(profile)) {
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			int health = data.getHealthPercentage(profile);
			session.setAttribute("health", health);
			rd.include(request, response);
		}
	}

}
