package modelo;

import java.sql.SQLException;

/**
 * <h2> Clase Usuario </h2>
 * <p> Se pueden crar objetos de peliculas con el id, nombre de la pelicula, nombre del usuario, imagen de las peliculas y la puntucion <p>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */

public class Pelicula {
	
	/**
	 * Atibuto id
	 */
	private int id;
	/**
	 * Atributo nombrePelicula
	 */
	private String nombrePelicula;
	/**
	 * Atributo nombreUsuario
	 */
	private String nombreUsuario;
	/**
	 * Atributo imagenPelicual
	 */
	private String imagenPeliculas;
	/**
	 * Atributo puntuacion
	 */
	private int puntuacion;
	
	/**
	 * Constructor vacio
	 */
	
	public Pelicula() {
		super();
	}
	
	/**
	 * Constructor con 2 parametros
	 * Crea objetos con el nombre de la pelicula y el nombre del usuario
	 * @param nombrePelicula
	 * @param nombreUsuario
	 */

	public Pelicula(String nombrePelicula, String nombreUsuario) {
		super();
		this.nombrePelicula = nombrePelicula;
		this.nombreUsuario = nombreUsuario;
	}
	
	/**
	 * Constructor con 3 parametros
	 * Crea objetos con el nombre de la pelicula, la imagen de la pelicula y la puntuacion
	 * @param nombrePelicula
	 * @param imagenPelicula
	 * @param puntuacion
	 */

	public Pelicula(String nombrePelicula,String imagenPelicula, int puntuacion) {
		super();
		this.nombrePelicula = nombrePelicula;
		this.imagenPeliculas = imagenPelicula;
		this.puntuacion = puntuacion;
	}

	/**
	 * Constructor con 4 paramtros
	 * Crea objetos con el nombre de la pelicula, el nombre del usuario, la imagen de la pelicula y la puntuacion
	 * @param nombrePelicula
	 * @param nombreUsuario
	 * @param imagenPeliculas
	 * @param puntuacion
	 */

	public Pelicula(String nombrePelicula, String nombreUsuario, String imagenPeliculas,int puntuacion) {
		super();
		this.nombrePelicula = nombrePelicula;
		this.nombreUsuario = nombreUsuario;
		this.imagenPeliculas = imagenPeliculas;
		this.puntuacion = puntuacion;
	}
	
	/**
	 * Constructor con 3 paramtros
	 * Crea objetos con el nombre de la pelicula, el nombre del usuario y la imagen de las peliculas
	 * @param id
	 * @param nombrePelicula
	 * @param nombreUsuario
	 * @param imagenPeliculas
	 */

	public Pelicula(int id, String nombrePelicula, String nombreUsuario, String imagenPeliculas) {
		super();
		this.id = id;
		this.nombrePelicula = nombrePelicula;
		this.nombreUsuario = nombreUsuario;
		imagenPeliculas = imagenPeliculas;
	}
	
	/**
	 * Metodo sin parametros
	 * <p> Permite insertar los datos proporcionados por el usuario en la base de datos </p>
	 * @throws SQLException
	 */
	
	public void insertarBD() throws SQLException {
		
		DaoDB dao = new DaoDB();
		
		dao.insertarPeliculas(this);
	}
	
	/**
	 * Metodo
	 * <p> Devuelve el id de la pelicula </p>
	 * @return <ul><li> Devuelve el id </li></ul>
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
	 * @return <ul><li> Devuelve el nombre de la pelicula </li></ul>
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
	 * <p> Devuelve el nombre del usuario </p>
	 * @return <ul><li> Devuelve el usuario de la pelicula </li></ul>
	 */

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	/**
	 * Metodo con 1 parametro
	 * @param nombreUsuario
	 */

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Metodo
	 * <p> Devuelve la imagen de la pelicula </p>
	 * @return <ul><li> Devuelve la imagen de la pelicula </li></ul>
	 */
	
	public String getimagenPeliculas() {
		return imagenPeliculas;
	}
	
	/**
	 * Metodo con 1 parametro
	 * @param imagenPeliculas
	 */

	public void setimagenPeliculas(String imagenPeliculas) {
		imagenPeliculas = imagenPeliculas;
	}
	
	/**
	 * Metodo
	 * <p> Devuelve la pntuacion de la pelicula </p>
	 * @return <ul><li> Devuelve la puntuacion de la pelicula </li></ul>
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
	 * Metodo sin parametros
	 * <p> Devuelve una cadena con todos los datos de la pelicula </p>
	 */

	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", nombrePelicula=" + nombrePelicula + ", nombreUsuario=" + nombreUsuario
				+ ", ImagenPeliculas=" + imagenPeliculas + "]";
	}
	
	

}
