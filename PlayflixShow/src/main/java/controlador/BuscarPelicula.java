package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.DaoDB;
import modelo.PuntuacionPelicula;
import modelo.Usuario;


/**
 * <h2> Servlet implementation class BuscarPelicula </h2>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */
@WebServlet("/BuscarPelicula")
public class BuscarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BuscarPelicula() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * <p> Buscamos la pelicula en funcion del nombre que recogemos del buscador </p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombrePelicula = request.getParameter("nombrePelicula");
		System.out.println("El nombre es " + nombrePelicula);
		
		PrintWriter respuesta = response.getWriter();
		String json = "";
		
		try {
			
			DaoDB dao = new DaoDB();
			
			PuntuacionPelicula p = new PuntuacionPelicula();
			int punt = p.CalcularPuntuacion(nombrePelicula);
			
			
			HttpSession session = request.getSession();
			session.setAttribute("puntuacion", punt);
			
			int miVariable = (Integer) session.getAttribute("puntuacion");
			
			System.out.println(miVariable);
			
		
		
			json = dao.obtenerPorNombre(nombrePelicula);
			
			respuesta.print(json);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
