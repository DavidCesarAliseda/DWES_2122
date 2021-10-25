package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.models.Reserva;

/**
 * Servlet implementation class ConfirmarServlet
 */
@WebServlet("/ConfirmarServlet")
public class ConfirmarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		if(!sesion.isNew() && sesion.getAttribute("fechaInicio") != null && sesion.getAttribute("fechaFin") != null &&
				sesion.getAttribute("personas") != null && sesion.getAttribute("checkbox") != null ){
		
			Reserva reserva = new Reserva();
			
			reserva.setFechaInicio((String)sesion.getAttribute("fechaInicio"));
			reserva.setFechaFinal((String)sesion.getAttribute("fechaFin"));
			reserva.setNumPersonas(Integer.valueOf((String) (sesion.getAttribute("personas"))));
			reserva.setServicios((String[])sesion.getAttribute("checkbox"));
			
			request.setAttribute("reservaBeans", reserva);
			
			request.getRequestDispatcher("confirmar.jsp").forward(request, response);
		}
	}

}
