package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(InicioServlet.class);

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
		String nombre = request.getParameter("firstname");
		String apellido = request.getParameter("lastname");

		if (usuario != null && usuario != null && usuario != null && usuario != null) {
			DAOUsuarioImpl dao = new DAOUsuarioImpl();
			Usuario user = dao.getUsuario(usuario);

			if (user != null) {
				if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {
					HttpSession sesion = request.getSession();

					sesion.setAttribute("usuario", user.getUsuario());
					sesion.setAttribute("email", user.getEmail());
					sesion.setAttribute("nombre", user.getFirstName());
					sesion.setAttribute("apellido", user.getLastName());
					sesion.setAttribute("role", user.getRole());

					if ("admin".equals(user.getRole())) {
						response.sendRedirect(request.getContextPath()+"/Admin/Inicio");
						logger.info("El Admin a entrado en sesion");
					} else {
						response.sendRedirect(request.getContextPath()+"/Oficinas");
						logger.info("El usuario a entrado en sesion");
					}
					

				} else {

					request.setAttribute("error", "login inválido");
					doGet(request, response);
					return;
				}
			} else {
				request.setAttribute("error", "Usuario no existente");
				doGet(request, response);
				return;
			}
		}

	}
}
