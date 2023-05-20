package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * <h2> Servlet implementation class Puntuacion </h2>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */
@WebServlet("/Puntuacion")
public class Puntuacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Puntuacion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * <p> Recoge la puntuacion en una variable sesion </p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		int miVariable = (Integer) session.getAttribute("puntuacion");
		
		System.out.println(miVariable);
		
		PrintWriter respuesta = response.getWriter();
		respuesta.print(miVariable);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
