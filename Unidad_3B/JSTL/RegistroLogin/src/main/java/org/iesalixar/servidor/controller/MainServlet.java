package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DAOUsuario;
import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Comprobamos si tenemos los datos de la petición del formulario
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
<<<<<<< HEAD
		
		if (usuario!=null && password!=null) {
			
			//Check credentials
			DAOUsuario userDao = new DAOUsuarioImpl();
			
			Usuario user = userDao.getUsuario(usuario);
			
			if(user!=null) {
				if(PasswordHashGenerator.checkPassword(password, user.getPassword())) {
					
					HttpSession sesion = request.getSession();
					
					/*Se guardan en sesion atributos del usuario*/
					sesion.setAttribute("usuario", user.getUsuario());
					sesion.setAttribute("email", user.getEmail());
					sesion.setAttribute("role", user.getRole());
					
					/*Se redirecciona al usuario a la zona correcta dependiendo del rol*/					
					if ("admin".equals(user.getRole())) {
						response.sendRedirect("Admin/");
					} else {
						response.sendRedirect("Search");
					}
				}else {
					
					request.setAttribute("error", "login inv�lido");
					doGet(request,response);
					return;
					
				}
			}
		}else {
			request.setAttribute("error", "Usuario no existente");
			doGet(request,response);
			return;
=======

		if (usuario != null && password != null) {

			// Check credentials
>>>>>>> d8d766ce2c47d28587f40b92d8f50ab4c43b721b
		}
	}

}
