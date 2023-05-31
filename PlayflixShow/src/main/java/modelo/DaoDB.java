package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.mysql.cj.protocol.Resultset;

/**
 * <h2> Clase DaoDB </h2>
 * <p> Esta clase nos permite trabajar realizando consultas a la base de datos </p>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */

public class DaoDB {
	
	/**
	 * Atributo getInstance
	 */
	public static Object getInstance;
	/**
	 * Atributo con
	 */
	private Connection con = null;
	
	/**
	 *Constructor sin parametros almacenar la conexion en una variable 
	 * @throws SQLException
	 */
	
	public DaoDB() throws SQLException {
		
			con = DaoConexion.getConnection();
		
	}	
	
	/**
	 * Metodo con parametros 
	 * <p> Este metodo nos permite realizar la inserccion de los usuarios en la base de datos </p> 
	 * @param s
	 * @throws SQLException
	 */
	
	public void insertar(Usuario s) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("INSERT users (nombre,apellido,correo,password) VALUES (?,?,?,?)")	;
		ps.setString(1,s.getNombre() );
		ps.setString(2, s.getApellidos());
		ps.setString(3, s.getCorreo());
		ps.setString(4,s.getPassword() );

		
		ps.executeUpdate();
		ps.close();
		
	}
	
	/**
	 * Metodo con parametros
	 * <p> Este metodo nos permite realizar la inserccion de las peliculas en la base de datos </p> 
	 * @param s
	 * @throws SQLException
	 */
	
	public void insertarPeliculas(Pelicula s) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("INSERT peliculas (nombrePelicula,nombreUsuario,imagenPeliculas,puntuacion) VALUES (?,?,?,?)")	;
		ps.setString(1,s.getNombrePelicula());
		ps.setString(2,s.getNombreUsuario());
		ps.setString(3, s.getimagenPeliculas());
		ps.setInt(4, s.getPuntuacion());

		
		ps.executeUpdate();
		ps.close();
		
	}
	
	/**
	 * Metodo con parametros
	 * <p> Este metodo nos permite realizar la inserccion de la puntuacion dada por el usuario en la base de datos </p> 
	 * @param s
	 * @throws SQLException
	 */
	
	public void insertarPuntuacion(PuntuacionPelicula s) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("INSERT puntuacionpelicula (nombrePelicula,puntuacion,usuario) VALUES (?,?,?)")	;
		ps.setString(1,s.getNombrePelicula());
		ps.setInt(2, s.getPuntuacion());
		ps.setString(3, s.getUsuario());

		
		ps.executeUpdate();
		ps.close();
		
	}
	
	/**
	 * Metodo sin parametros
	 * <p> Este metodo nos permite obtener de la base datos las peliculas </p>
	 * @return <ul><li> Devuelve un array list con todos los datos de las peliculas </li></ul>
	 * @throws SQLException
	 */
	
	public ArrayList<Pelicula> obtenerPeliculas() throws SQLException{
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM peliculas");
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Pelicula> resul = null;
		
		while(rs.next()) {
			
			if(resul == null) {
				resul = new ArrayList<>();
			}
			resul.add(new Pelicula(rs.getString("nombrePelicula"),rs.getNString("imagenPeliculas"), rs.getInt("puntuacion")));
			
		}
		
		return resul;
	}
	
	/**
	 * Metodo con 2 parametros
	 * <p> Este metodo devuelve de la base datos el nombre y la password que luego utilizamos para validar </p>
	 * @param nombre
	 * @param password
	 * @return <ul><li> Devuelve el en un array tanto el nombre como la password </li></ul>
	 * @throws SQLException
	 */
	
	public Usuario validarDatos(String nombre, String password) throws SQLException{
		
		String json = "";
		PreparedStatement ps = con.prepareStatement("SELECT nombre, password FROM users WHERE nombre = ? AND password = ?");
		ps.setString(1, nombre);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		Usuario usuario = null;
		
		if(rs.next()) {
			usuario = new Usuario();
			usuario.setNombre(rs.getString("nombre"));
			usuario.setPassword(rs.getString("password"));
		}
		
		return usuario;
	}
	
	/**
	 * Metodo con 1 parametro
	 * <p> Este metodo devuelve el nombre de la pelicula en funcion de que usuario sea </p>
	 * @param nombrePelicula
	 * @return <ul><li> Devuelve el nombre de las peliculas dependiendo del usuario que sea </li></ul>
	 * @throws SQLException
	 */
	
	public String obtenerPorNombre(String nombrePelicula) throws SQLException {
		
		String json = "";
		PreparedStatement ps = con.prepareStatement("SELECT * FROM peliculas WHERE nombrePelicula=?");
		ps.setString(1, nombrePelicula);
		
		ResultSet rs = ps.executeQuery();
		
		Pelicula s;
		
		while(rs.next()) {
			
			s = new  Pelicula(rs.getString("nombrePelicula"),rs.getNString("imagenPeliculas"), rs.getInt("puntuacion"));
		
			Gson gsonFinal = new Gson();
			json = gsonFinal.toJson(s);
		}
		
		return json;
		
	}
	
	/**
	 * Metodo con 1 parametro
	 * <p> Este metodo obtiene la puntuacion de las peliculas en funcion de su nombre </p>
	 * @param nombrePelicula
	 * @return <ul><li> Nos devuelve todos los resultados dependiendo de la pelicula que sea </li></ul>
	 * @throws SQLException
	 */
	
	public ArrayList<PuntuacionPelicula> obtenerPuntuacion(String nombrePelicula) throws SQLException{
		
		PreparedStatement ps = con.prepareStatement("SELECT puntuacion FROM puntuacionpelicula WHERE nombrePelicula=?");
		ps.setString(1, nombrePelicula);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<PuntuacionPelicula> resul = null;
		
		while(rs.next()) {
			
			if(resul == null) {
				resul = new ArrayList<>();
			}
			resul.add(new PuntuacionPelicula(rs.getInt("puntuacion")));
			
		}
		
		return resul;
	}
		
	/**
	 * Metodo con 1 paramtro
	 * <p> Este metodo nos devuelve el nombre del usuario </p>
	 * @param nombre
	 * @return <ul><li> Devuelve el nombre del usuario </li></ul>
	 * @throws SQLException
	 */
	
	public String nombreUser(String nombre) throws SQLException {
		
		String json = "";
		PreparedStatement ps = con.prepareStatement("SELECT nombre FROM users WHERE nombre = ?");
		ps.setString(1, nombre);
		
		ResultSet rs = ps.executeQuery();
		
		Usuario us;
		
		while(rs.next()) {
			
			us = new  Usuario(rs.getString("nombre"));
		
			Gson gsonFinal = new Gson();
			json = gsonFinal.toJson(us);
		}
		
		return json;
		
	}
	
	/**
	 * Metodo sin parametros
	 * <p> Este metodo se utiliza para que los datos dados en obtener peliculas nos los pase a json </p>
	 * @return <ul><li> Devuelve el json </li></ul>
	 * @throws SQLException
	 */
	
	public String obtenerJSON() throws SQLException {
		
		String jsonFinal = "";
		
		Gson gsonFinal = new Gson();
		jsonFinal = gsonFinal.toJson(this.obtenerPeliculas());
		
		return jsonFinal;
	}

}
