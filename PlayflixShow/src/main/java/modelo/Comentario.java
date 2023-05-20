package modelo;

import java.sql.Date;

public class Comentario {
	
	private int id;
	private String comentario;
	private String usuario;
	private Date fecha;
	
	public Comentario() {
		super();
	}

	public Comentario(int id, String comentario, String usuario, Date fecha) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", comentario=" + comentario + ", usuario=" + usuario + ", fecha=" + fecha
				+ "]";
	}
	
	
	
	

}
