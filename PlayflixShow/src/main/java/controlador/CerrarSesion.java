package controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * <h2> Servlet implementation class CerrarSesion </h2>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */
@WebServlet("/CerrarSesion")
public class CerrarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CerrarSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * <p> Cerramos la sesion del usuario </p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String miVariable = (String) session.getAttribute("nombre");
		
		if(miVariable != null) {
			session.invalidate();
		}
		
		  response.setStatus(HttpServletResponse.SC_OK);
		  response.getWriter().write("");
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
