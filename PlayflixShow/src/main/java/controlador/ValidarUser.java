package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.DaoDB;
import modelo.Usuario;

/**
 * <h2> Servlet implementation class ValidaUser </h2>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */

@WebServlet("/ValidarUser")
public class ValidarUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ValidarUser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * <p> Comprobamos la validacion echa desde la clase Usuario </p>
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter respuesta = response.getWriter();
		String json = "";
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		
		try {
			Usuario user = new Usuario();
			boolean Valid = user.validarUser(nombre, password);
			if(Valid) {
				HttpSession session = request.getSession();
				session.setAttribute("nombre", nombre);
				
				response.sendRedirect("paginaInicio.html");
				
			}else {
				System.out.println("Fallo");
				response.sendRedirect("formInicio.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
