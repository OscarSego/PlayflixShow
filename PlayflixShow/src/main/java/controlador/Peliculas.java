package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.DaoDB;

/**
 * <h2> Servlet implementation class Peliculas </h2>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */
@WebServlet("/Peliculas")
public class Peliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Peliculas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * <p> Permitira visualizar las peliculas </p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		PrintWriter respuesta = response.getWriter();
		String json = "";
		
		try {
			DaoDB dao = new DaoDB();
			
			json = dao.obtenerJSON();
			System.out.println(json);
			
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
