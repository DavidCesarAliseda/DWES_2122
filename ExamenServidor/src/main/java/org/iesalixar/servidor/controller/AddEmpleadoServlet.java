package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.model.Employee;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class AddEmpleadoServlet
 */
@WebServlet("/AddEmpleadoServlet")
public class AddEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(InicioServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmpleadoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOEmployeeImpl daoImpl = new DAOEmployeeImpl();
		DAOOfficeImpl daoOfficeImpl = new DAOOfficeImpl();

		ArrayList<Employee> empleados = daoImpl.getAllEmployees();
		ArrayList<Office> oficinas = daoOfficeImpl.getAllOffices();

		request.setAttribute("empleados", empleados);
		request.setAttribute("oficinas", oficinas);

		request.getRequestDispatcher("/WEB-INF/view/admin/addempleado.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int numEmpleado = Integer.parseInt(request.getParameter("employeeNumber"));
		String nombre = request.getParameter("firstName");
		String apellido = request.getParameter("firstName");
		String extension = request.getParameter("extension");
		String puesto = request.getParameter("jobTitle");
		String mail = request.getParameter("mail");
		String oficina = request.getParameter("officeCode");
		int jefe = Integer.parseInt(request.getParameter("jefe"));

		if (numEmpleado >= 0 && jefe >= 0 && nombre != null && apellido != null && extension != null && puesto != null
				&& oficina != null) {
			Employee empleado = new Employee();
			DAOEmployeeImpl daoImpl = new DAOEmployeeImpl();
			System.out.println();
			empleado.setEmployeeNumber(numEmpleado);
			empleado.setLastName(apellido);
			empleado.setFirstName(nombre);
			empleado.setExtension(extension);
			empleado.setEmail(mail);
			empleado.setOfficeCode(oficina);
			empleado.setReportsTo(jefe);
			empleado.setJobTitle(puesto);

			daoImpl.insertEmployee(empleado);
			logger.info("Se ha añadido usuario");
			
			response.sendRedirect(request.getContextPath()+"/Admin/Empleados");

		}
	}

}
