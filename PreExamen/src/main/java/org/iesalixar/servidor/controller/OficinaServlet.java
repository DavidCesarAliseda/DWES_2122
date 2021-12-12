package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.dao.DAOProduct;
import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class OficinaServlet
 */
@WebServlet("/OficinaServlet")
public class OficinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(InicioServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OficinaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOOfficeImpl officeDao = new DAOOfficeImpl();

		ArrayList<Office> oficinas = officeDao.getAllOffices();

		request.setAttribute("oficinas", oficinas);
		request.getRequestDispatcher("/WEB-INF/view/buscaroficinas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ciudad = request.getParameter("office");

		if (ciudad != null) {

			DAOOfficeImpl dao = new DAOOfficeImpl();
			request.setAttribute("ofi", dao.getOffice(ciudad));

			doGet(request, response);
			return;
		}
		doGet(request,response);
	}

}
