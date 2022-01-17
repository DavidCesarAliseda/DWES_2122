package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.ProductLineDAO;
import org.iesalixar.servidor.dao.ProductLineDAOImpl;
import org.iesalixar.servidor.model.ProductLine;


/**
 * Servlet implementation class CategoriasServlet
 */
public class CategoriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductLineDAO  dao = new ProductLineDAOImpl();
		
		request.setAttribute("categorias", dao.getAllProductLine());
		
		request.getRequestDispatcher("/WEB-INF/view/categorias.jsp").forward(request, response);
	}

	

}
