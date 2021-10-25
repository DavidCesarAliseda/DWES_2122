package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class InicioServlet
 */
//@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(InicioServlet.class);

	private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";

	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InicioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		if (!sesion.isNew()) {
			if (request.getParameter("user") != null && request.getParameter("password") != null
					&& request.getParameter("confirmpass") != null && request.getParameter("email") != null
					&& request.getParameter("confirmpass").equals(request.getParameter("confirmpass"))
					/*&& PASSWORD_PATTERN.matcher(request.getParameter("password")).matches()*/) {

				sesion.setAttribute("usuario", request.getParameter("user"));
				sesion.setAttribute("hora", sesion.getCreationTime());
				
				response.sendRedirect(request.getContextPath() + "/ReservarServlet");
				logger.info("El usuario a entrado en sesion");

				return;
			} else {

				// Logeo que ha intentado entrar directamente en la aplicación sin tener sesión
				logger.error("Faltan parámetros o la contraseña es incorrecta");

				response.sendRedirect(request.getContextPath() + "/InicioServlet");
				return;

			}
		}
		logger.error("Intento de entrar en Inicio sin tener sesión");

		// No tengo sesion.
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());

	}

}
