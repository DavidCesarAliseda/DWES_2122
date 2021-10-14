package org.iesalixar.servidor.david;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Propiedades
 */
@WebServlet("/Propiedades")
public class Propiedades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Propiedades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties prop = new Properties();
		InputStream is = null;
		ArrayList<String> listaPropiedades = new ArrayList<String>();
		 
		 try {
		    is = new FileInputStream("resources/bd.properties");
		    prop.load(is);
		    
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		 for (Enumeration e = prop.keys(); e.hasMoreElements();) {
			 
			 Object obj = e.nextElement();
			 String value = prop.getProperty(obj.toString());
			 
			 listaPropiedades.add(value);
			 
		 }
		 request.setAttribute("propiedades", listaPropiedades);
		 request.getRequestDispatcher("index.jsp").forward(request, response);
		 
		 

		 

		 

	}

}
