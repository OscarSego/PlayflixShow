package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <h2> Clase Usuario </h2>
 * <p> Se pueden crear objetos con el id, nombre de la pelicula, puntuacion y usuario </p>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */


public class PuntuacionPelicula {
	
	/**
	 * Atributo id
	 */
	private int id;
	/**
	 * Atributo nombrePelicula
	 */
	private String nombrePelicula;
	/**
	 * Atributo puntuacion
	 */
	private int puntuacion;
	/**
	 * Atributo usuario
	 */
	private String usuario;
	
	/**
	 * Constructor vacio
	 */
	
	public PuntuacionPelicula() {

	}
	
	/**
	 * Contructor con un parametro
	 * Crea objetos con la puntuacion
	 * @param puntuacion
	 */
	
	public PuntuacionPelicula(int puntuacion) {
		super();
		this.puntuacion = puntuacion;
	}
	
	/**
	 * Constructor con 4 parametros
	 * Crea objetos con el id, el nombre de la pelicula, la puntuacion y el usuario
	 * @param id
	 * @param nombrePelicula
	 * @param puntuacion
	 * @param usuario
	 */

	public PuntuacionPelicula(int id, String nombrePelicula, int puntuacion, String usuario) {
		super();
		this.id = id;
		this.nombrePelicula = nombrePelicula;
		this.puntuacion = puntuacion;
		this.usuario = usuario;
	}
	
	/**
	 * Constructor con 3 parametros
	 * Crea objetos con el nombre de la pelicula, la puntuacion y el usuario
	 * @param nombrePelicula
	 * @param puntuacion
	 * @param usuario
	 */
	
	public PuntuacionPelicula(String nombrePelicula,int puntuacion, String usuario) {
		super();
		this.nombrePelicula = nombrePelicula;
		this.puntuacion = puntuacion;
		this.usuario = usuario;
	}
	
	/**
	 * Metodo con un parametros
	 * <p> Calcula la puntuacion de las peliculas. Se pasa el nombre de la pelicula y recoge todas las puntuaciones y hace una media </p>
	 * @param nombrePelicula
	 * @return <ul><li> Devuelve la  puntuacio</li></ul>
	 * @throws SQLException
	 */
	
	public int CalcularPuntuacion(String nombrePelicula) throws SQLException  {
		
		this.nombrePelicula = nombrePelicula;
		
		int total = 0;
		int cont = 0;
		int media = 0;
		
		DaoDB dao = new DaoDB();
		ArrayList<PuntuacionPelicula> p = dao.obtenerPuntuacion(nombrePelicula);
		
		for(int i=0; i < p.size(); i++) {
			total += p.get(i).getPuntuacion();
			cont ++;
		}
		
		media = total/cont;
		
		return media;
		
	}
	
	/**
	 * Metodo sin parametros
	 * <p> Permite insertar en la los datos proporcionados por el usuario en la base de datos </p>
	 * @throws SQLException
	 */
	
	public void insertarBD() throws SQLException {
		
		DaoDB dao = new DaoDB();
		
		dao.insertarPuntuacion(this);
	}
	
	/**
	 * Metodo
	 * <p> Devuelve el id </p>
	 * @return <ul><li> Devuelve el id</li></ul>
	 */

	public int getId() {
		return id;
	}
	
	/**
	 * Metodo con 1 parametro
	 * @param id
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Metodo
	 * <p> Devuelve el nombre de la pelicula </p>
	 * @return <ul><li> Devuelve el nombre de la pelicula</li></ul>
	 */

	public String getNombrePelicula() {
		return nombrePelicula;
	}
	
	/**
	 * Metodo con 1 parametro
	 * @param nombrePelicula
	 */

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}
	
	/**
	 * Metodo
	 * <p> Devuelve la puntuacion de la pelicula </p>
	 * @return <ul><li> Devuelve la puntuacion de la pelicula</li></ul>
	 */

	public int getPuntuacion() {
		return puntuacion;
	}
	
	/**
	 * Metodo con 1 parametro
	 * @param puntuacion
	 */

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	/**
	 * Metodo
	 * <p> Devuelveel usuario que ha puesto la puntuacion </p>
	 * @return <ul><li> Devuelve el usuario</li></ul>
	 */

	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * Metodo con 1 parametro
	 * @param usuario
	 */

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Metodo sin parametros
	 * @return <ul><li> Devuelve una cadena con todos los datos que se generan sobre la puntuacion de la pelicula </li></ul>
	 */

	@Override
	public String toString() {
		return "Puntuacion [id=" + id + ", nombrePelicula=" + nombrePelicula + ", puntuacion=" + puntuacion
				+ ", usuario=" + usuario + "]";
	}
	
	

}
