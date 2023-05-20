package modelo;

import java.sql.SQLException;

/**
 * <h2> Clase Usuario </h2>
 * <p> Se pueden crear usuarios que tiene la web, insertar en la base dedatos y validar si existen <p>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */

public class Usuario {
	
	/**
	 * Atributo id 
	 */
	private int id;
	/**
	 * Atributo nombre del usuario
	 */
	private String nombre;
	/**
	 * Atributo apellidos del usuario
	 */
	private String apellidos;
	/**
	 * Atrinuto correo del usuario
	 */
	private String correo;
	/**
	 * Atributo password del usuario
	 */
	private String password;
	
	/**
	 * Constructor vacio
	 */
	
	public Usuario() {
		super();
	}
	
	/**
	 * Constructor con un parametro
	 * Crea objetos con el nombre del usuario
	 * @param nombre
	 */
	
	public Usuario(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Contructor con 5 parametros
	 * Crea objetos con todos los atributos del usuario (id, nombre, apellidos, correo, password)
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param password
	 */

	public Usuario(int id, String nombre, String apellidos, String correo, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
	}
	
	/**
	 * Constructor con 4 parametros
	 * Crea objetos con el nombre, apellido, correo y password
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param password
	 */

	public Usuario(String nombre, String apellidos, String correo, String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
	}
	
	/**
	 * Constructor con 2 parametros
	 * Crea objetos con el nombre y el apellido
	 * @param nombre
	 * @param password
	 */
	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	
	/**
	 * Metodo con 2 parametros
	 * <p> Realiza la validacion del usuario. Si el nombre y la password se encuentran en la base datos </p>
	 * @param nombre
	 * @param password
	 * @return <ul>
	 * <li> Si el usuario es distinto de null existe en la base de datos </li>
	 * </ul>
	 * @throws SQLException
	 */
	
	public boolean validarUser(String nombre, String password) throws SQLException {
		
		DaoDB dao = new DaoDB();
		Usuario user = dao.validarDatos(nombre, password);
		
		return user != null;
	}
	
	/**
	 * Metodo sin parametros
	 * <p> Inserta los datos del usuario en la base de datos </p>
	 * @throws SQLException
	 */

	public void insertarEnBaseDeDatos() throws SQLException {

		DaoDB dao = new DaoDB();
		
		dao.insertar(this);
		

	}
	
	/**
	 * Metodo
	 * <p> Devuelve el id </p>
	 * @return <ul><li> Delvuelve el id del usuario </li></ul>
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * Metodo pasamos 1 parametro
	 * @param id
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Metodo
	 * <p> Devuelve el nombre </p>
	 * @return <ul><li> Delvuelve el nombre del usuario </li></ul>
	 */

	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo con 1 parametro
	 * @param nombre
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo
	 * <p> Devuelve los apellidos </p>
	 * @return <ul><li> Delvuelve los apellidos del usuario </li></ul>
	 */

	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * Metodo con 1 parametro
	 * @param apellidos
	 */

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * Metodo
	 * <p> Devuelve el correo </p>
	 * @return <ul><li> Delvuelve el correo del usuario </li></ul>
	 */

	public String getCorreo() {
		return correo;
	}
	
	/**
	 * Metodo con 1 parametro
	 * @param correo
	 */

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**
	 * Metodo
	 * <p> Devuelve la password del usuario </p>
	 * @return <ul><li> Delvuelve la password del usuario </li></ul>
	 */

	public String getPassword() {
		return password;
	}
	
	/**
	 * Metodo con 1 parametro
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Metodo
	 * @return <ul><li> Nos devuelve una cadena con todos los datos del usuario </li></ul>
	 */

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo
				+ ", password=" + password + "]";
	}
	
	
}

