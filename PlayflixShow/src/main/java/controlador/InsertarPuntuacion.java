package controlador;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.PuntuacionPelicula;
import modelo.Usuario;

/**
 * <h2> Servlet implementation class InsertarPuntuacion </h2>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */
@WebServlet("/InsertarPuntuacion")
public class InsertarPuntuacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertarPuntuacion() {
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
	 * <p> Insertamos la puntuacion con los datos del formulario </p>
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	;
		String nombre = request.getParameter("nombrePelicula");
		int puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
		String user = request.getParameter("Usuario");
		
		
		PuntuacionPelicula s = new PuntuacionPelicula(nombre,puntuacion,user);
		try {
			s.insertarBD();
			response.sendRedirect("index.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s.toString());
	
	}

}
