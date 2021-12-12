package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOrderImpl;
import org.iesalixar.servidor.model.Order;

/**
 * Servlet implementation class OrderDetails
 */
@WebServlet("/OrderDetails")
public class OrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderNumber = request.getParameter("on");
		
		DAOOrderImpl dao = new DAOOrderImpl();
		
		if (orderNumber!=null) {
			Order order = dao.getOrder(Integer.parseInt(orderNumber));
			request.setAttribute("pedido", order);
		}
		 
		request.getRequestDispatcher("/WEB-INF/view/admin/orderdetails.jsp").forward(request, response);
	}

	

}
