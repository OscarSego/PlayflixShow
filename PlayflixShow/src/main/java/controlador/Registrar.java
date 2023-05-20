package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Usuario;

/**
 * <h2> Servlet implementation class Registrar </h2>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */
@WebServlet("/Registrar")
@MultipartConfig
public class Registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*private String pathFiles = "C:\\Users\\ERAZER\\Java\\EJEMPLO-PEQUEÑO-WEB\\src\\main\\webapp\\imagenes";
	private File uploads = new File(pathFiles);*/

    /**
     * Default constructor. 
     */
    public Registrar() {
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
	 * <p> Obtenemos los datos del formulario y los insertamos en la base datos </p>
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String correo = request.getParameter("correo");
		
		
		Usuario s = new Usuario(nombre,apellidos,correo,password);
		try {
			s.insertarEnBaseDeDatos();
			response.sendRedirect("formInicio.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s.toString());
	
	}


}
