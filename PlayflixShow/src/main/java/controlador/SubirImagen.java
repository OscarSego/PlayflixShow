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
import modelo.Pelicula;
import modelo.Usuario;


/**
 * <h2> Servlet implementation class SubirImagen </h2>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */
@WebServlet("/SubirImagen")
@MultipartConfig
public class SubirImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String pathFiles = "C:\\Users\\ERAZER\\git\\PlayflixShow\\PlayflixShow\\src\\main\\webapp\\imagenes";
	private File uploads = new File(pathFiles);

    /**
     * Default constructor. 
     */
    public SubirImagen() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * <p> Podremos subir tanto el nombre de la pelicula y el usuario como la imagen </p>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombrePelicula = request.getParameter("nombrePelicula");
		String nombreUsuario = request.getParameter("nombreUsuario");
		int puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
		
		
		Part part = request.getPart("imagenPeliculas");
		
		Path path = Paths.get(part.getSubmittedFileName());
		
		String fileName = path.getFileName().toString();
		
		InputStream input = part.getInputStream();
			
		
		File foto = new File(uploads,fileName);
		
		try {
			Files.copy(input, foto.toPath());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Upss, no ha funcionado");
		}
		
		
		Pelicula s = new Pelicula(nombrePelicula,nombrePelicula,fileName,puntuacion);
		try {
			s.insertarBD();
			response.sendRedirect("peliculas.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
