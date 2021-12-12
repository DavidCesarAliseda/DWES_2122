package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.ProductLine;

/**
 * Servlet implementation class EditarProductServlet
 */
@WebServlet("/EditarProductServlet")
public class EditarProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productCode = request.getParameter("pc");

		if (productCode != null) {

			DAOProductImpl productDaoImpl = new DAOProductImpl();
			DAOProductLineImpl plDaoImpl = new DAOProductLineImpl();
			
			ArrayList<ProductLine> productLines = plDaoImpl.getAll();
			Product product = productDaoImpl.getProduct(productCode);

			request.setAttribute("producto", product);
			request.setAttribute("productLines", productLines);
			
			request.getRequestDispatcher("/WEB-INF/view/admin/productedit.jsp").forward(request, response);
		} else {
			response.sendRedirect("/Admin/Inicio");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productName = request.getParameter("productName");
		String productCode = request.getParameter("productCode");
		String productLine = request.getParameter("productLine");
		int quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
		Double buyPrice = Double.parseDouble(request.getParameter("buyPrice"));

		if (productName != null && productCode != null && productLine != null && quantityInStock != 0
				&& buyPrice != 0.0) {

			Product product = new Product();

			product.setProductName(productName);
			product.setProductCode(productCode);
			product.setProductLine(productLine);
			product.setQuantityInStock(quantityInStock);
			product.setBuyPrice(buyPrice);

			DAOProductImpl daoImpl = new DAOProductImpl();

			daoImpl.updateProduct(product);

			response.sendRedirect(request.getContextPath()+"/Admin/Inicio");

		}
	}

}
