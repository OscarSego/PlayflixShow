package modelo;

/**
 * <h2> Clase TipoDeUsuario </h2>
 * <p> Se pueden crar objetos de peliculas con el tipo, alta </p>
 * @author Oscar Sanchez Garcia
 * @version v.1_2023
 * @since 04-2023
 */
public class TipoDeUsuario extends Usuario {
	
	/**
	 * Atibuto tipo
	 */
	private RangoDeUsuario tipo;
	
	/**
	 * Atibuto alta
	 */
	private String alta;
	
	/**
	 * Constructor vacio
	 */
	public TipoDeUsuario() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public RangoDeUsuario getTipo() {
		return tipo;
	}

	/**
     * Metodo con 1 parametro
	 * @param tipo
	 */
	public void setTipo(RangoDeUsuario tipo) {
		this.tipo = tipo;
	}

	/**
	 * 
	 * @return
	 */
	public String getAlta() {
		return alta;
	}

	/**
     * Metodo con 1 parametro
	 * @param alta
	 */
	public void setAlta(String alta) {
		this.alta = alta;
	}

	/**
	 * Metodo sin parametros
	 * <p> Devuelve una cadena con todos los datos del Tipo de usuario </p>
	 */
	@Override
	public String toString() {
		return "TipoDeUsuario [tipo=" + tipo + ", alta=" + alta + "]";
	}
	
	

}
