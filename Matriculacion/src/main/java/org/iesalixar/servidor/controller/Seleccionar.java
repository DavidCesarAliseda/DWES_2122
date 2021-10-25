package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Seleccionar
 */
@WebServlet("/Seleccionar")
public class Seleccionar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String NAME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";

	private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" + "@"
			+ "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Seleccionar() {
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

		if (!sesion.isNew() && (boolean) sesion.getAttribute("Login")) {
			request.getRequestDispatcher("seleccionar.jsp").forward(request, response);
			return;
		}

		sesion.invalidate();
		response.sendRedirect("Login");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		if (NAME_PATTERN.matcher(request.getParameter("nombre")).matches()
				&& NAME_PATTERN.matcher(request.getParameter("apellido")).matches()
				&& EMAIL_PATTERN.matcher(request.getParameter("email")).matches()) {

			sesion.setAttribute("nombre", request.getParameter("nombre"));
			sesion.setAttribute("apellido", request.getParameter("apellido"));
			sesion.setAttribute("email", request.getParameter("email"));

			sesion.setAttribute("modulos", request.getParameterValues("select"));

			Cookie cookie = new Cookie("curso", request.getParameter("curso"));
			response.addCookie(cookie);

			response.sendRedirect("ConfirmarMatricula");

		} else {
			response.sendRedirect("Seleccionar");
		}
	}

}
