package org.iesalixar.servidor.david;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loggin
 */
@WebServlet("/Loggin")
public class Loggin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loggin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		

		out.println("<html>");
		out.println("<head><title>Ejemplo de Loggin desde el Servlet</title><head>");
		out.println("<body>");
		out.println("<h2 style=\"color: blue\">Loggin</h2>");
		out.println(
				"<p>Introduzca su usuario y contrasena: </p>");

		out.println("<form method=\"post\">");
		out.println("<label for=\"usuario\">Usuario:</label><input id=\"usuario\" type=\"text\" name=\"usuario\" required><br>");
		out.println("<br>");
		out.println(
				"<label for=\"contrasena\">Contrasena:</label><input id=\"contrasena\" type=\"text\" name=\"contrasena\"  required><br>");
		out.println("<button type=\"submit\" name=\"submit\" style=\"margin:10px\">Enviar</button>");
		out.println("</form>");
		out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		String user = request.getParameter("usuario");
		String pass = request.getParameter("contrasena");
		String admin = "admin";
		
		if (pass.equals(admin)) {
			out.println("Bienvenido "+user);
		} else {
			doGet(request, response);
			out.println("<h3 style=\"color: red\">Usuario o contrasena incorrecta, vuelva a introducirla</h3>");
			
		}
	}

}
