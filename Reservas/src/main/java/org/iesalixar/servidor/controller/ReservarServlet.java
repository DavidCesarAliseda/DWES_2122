package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ReservarServlet
 */
@WebServlet("/ReservarServlet")
public class ReservarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(ReservarServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession();

		if (!sesion.isNew() && sesion.getAttribute("usuario") != null && sesion.getAttribute("hora") != null) {
			request.getRequestDispatcher("reservar.jsp").forward(request, response);
			return;
		}

		// Logeo que ha intentado entrar directamente en la aplicación sin tener sesión
		logger.error("Intento de entrar en Reservar sin tener sesión");

		sesion.invalidate();
		response.sendRedirect(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		if (!sesion.isNew() && sesion.getAttribute("usuario") != null && sesion.getAttribute("hora") != null) {
			if (request.getParameter("fechaInicio") != null && request.getParameter("fechaFin") != null
					&& request.getParameter("personas") != null && request.getParameter("Reservar") != null
					&& request.getParameter("Reservar").equals("Reservar")) {

				sesion.setAttribute("fechaInicio", request.getParameter("fechaInicio"));
				sesion.setAttribute("fechaFin", request.getParameter("fechaFin"));
				sesion.setAttribute("personas", request.getParameter("personas"));
				sesion.setAttribute("checkbox", request.getParameterValues("checkbox"));

				logger.info("El usuario ha hecho la reserva");
				response.sendRedirect(request.getContextPath() + "/ConfirmarServlet");
				return;

			} else {

				logger.error("Faltan parámetros");

				response.sendRedirect(request.getContextPath() + "/ReservarServlet");
				return;

			}
		}
		logger.error("Intento de entrar en Inicio sin tener sesión");

		sesion.invalidate();
		response.sendRedirect(request.getContextPath());

	}

}
