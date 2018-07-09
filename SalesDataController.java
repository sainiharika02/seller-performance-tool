package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Sales;
import com.model.SalesBo;

@WebServlet("/SalesDataController")
public class SalesDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SalesDataController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int seller_id = (Integer)session.getAttribute("seller_id");
		Sales sales = new Sales();
		sales.setSeller_id(seller_id);
		SalesBo sales_bo = new SalesBo();
		int[] sales_details = sales_bo.getSalesDetails(sales);
		session.setAttribute("total_sales", sales_details[0]);
		session.setAttribute("delivery_delayed", sales_details[1]);
		session.setAttribute("products_cancelled", sales_details[2]);
		session.setAttribute("customers_viewed", sales_details[3]);
		session.setAttribute("addedtocart", sales_details[4]);
		session.setAttribute("defect", sales_details[5]);
		RequestDispatcher rd = request.getRequestDispatcher("Sales.jsp");
		rd.include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
