package modelo;

import java.sql.Date;

/**
 * <h2> Clase Comentario </h2>
 * <p> Se pueden crar objetos de peliculas con el id, comentario, usuario, fecha,  </p>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */

public class Comentario {
	
	/**
	 * Atibuto id
	 */
	private int id;
	
	/**
	 * Atibuto comentario
	 */
	private String comentario;
	
	/**
	 * Atibuto usuario
	 */
	private String usuario;
	
	/**
	 * Atibuto fecha
	 */
	private Date fecha;
	
	
	/**
	 * Constructor vacio
	 */
	public Comentario() {
		super();
	}
	
	/**
	 * Constructor con 4 parametros
	 * Crea objetos con el id, comentario, usuario y fecha
	 * @param id
	 * @param comentario
	 * @param usuario
	 * @param fecha
	 */

	public Comentario(int id, String comentario, String usuario, Date fecha) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.usuario = usuario;
		this.fecha = fecha;
	}
	
	/**
	 * Constructor con 1 paramtros
	 * @param comentario
	 * @return respuesta
	 */
	public String tamanioComentario(String comentario) {
		
        String texto = comentario;
        String respuesta = "";

        if (texto.length() < 400) {
            respuesta = "El texto tiene menos de 400 caracteres.";
        } else {
            respuesta = "El texto tiene 400 o más caracteres.";
        }
		
		return  respuesta;
	}

	/**
	 * 
	 * @return id
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
 * 
 * @return comentario
 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * Metodo con 1 parametro
	 * @param comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * 
	 * @return usuario
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
	 * 
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Metodo con 1 parametro
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Metodo sin parametros
	 * <p> Devuelve una cadena con todos los datos de los comentarios </p>
	 */
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", comentario=" + comentario + ", usuario=" + usuario + ", fecha=" + fecha
				+ "]";
	}
	
	
	
	

}
