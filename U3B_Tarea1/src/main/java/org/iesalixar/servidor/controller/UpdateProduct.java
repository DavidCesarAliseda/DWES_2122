package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOProductImpl;

import org.iesalixar.servidor.models.Product;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(InicioServlet.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productCode = request.getParameter("pc");
	
		DAOProductImpl daoImpl = new DAOProductImpl();
		
		Product product = daoImpl.getProduct(productCode);
		
		request.setAttribute("producto", product);
		
		request.getRequestDispatcher("../WEB-INF/view/admin/editproduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		String productCode = request.getParameter("productCode");
		String productLine = request.getParameter("productLine");
		int quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
		Double buyPrice  = Double.parseDouble(request.getParameter("buyPrice"));
		
		
		if (productName!=null && productCode!=null && productLine!=null && quantityInStock!=0 && buyPrice!=0.0) {
			
			Product product = new Product();
			
			product.setProductName(productName);
			product.setProductCode(productCode);
			product.setProductLine(productLine);
			product.setQuantityInStock(quantityInStock);
			product.setBuyPrice(buyPrice);
			
			
			DAOProductImpl daoImpl = new DAOProductImpl();
			
			daoImpl.updateProduct(product);
			logger.info("Modificación realizada");

		}
		
		response.sendRedirect(request.getContextPath());
	}

}
