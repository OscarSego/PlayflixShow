package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h2> Clase DaoConexion </h2>
 * <p> Clase para crear la conexion con la base de datos </p>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */

public class DaoConexion {
	
/**
 * Atributo instance
 */
	
public static Connection instance = null;

/**
 * Constructor vacio
 */
	
	public DaoConexion() {
		
	}
	
/**
 * Metodo sin parametros
 * <p> Con este metodo creamos la conexion a la base de datos </p>
 * @return <ul><li> Devuelve la conexion </li></ul>
 * @throws SQLException
 */

	public static Connection getConnection() throws SQLException {
		
		instance = DriverManager.getConnection("jdbc:mysql://localhost/saludos", "root","");
		
		return instance;
	}

}
