package modelo;

public class TipoDeUsuario extends Usuario {
	
	private RangoDeUsuario tipo;
	private String alta;
	
	public TipoDeUsuario() {
		super();
	}

	public RangoDeUsuario getTipo() {
		return tipo;
	}

	public void setTipo(RangoDeUsuario tipo) {
		this.tipo = tipo;
	}

	public String getAlta() {
		return alta;
	}

	public void setAlta(String alta) {
		this.alta = alta;
	}

	@Override
	public String toString() {
		return "TipoDeUsuario [tipo=" + tipo + ", alta=" + alta + "]";
	}
	
	

}
