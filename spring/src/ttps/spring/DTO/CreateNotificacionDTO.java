package ttps.spring.DTO;

public class CreateNotificacionDTO {
	private long id;
	private String nombre;
	private long usuario;
	
	public CreateNotificacionDTO() {}
	
	public CreateNotificacionDTO(String nombreC, long usuarioC) {
		setNombre(nombreC);
		setUsuario(usuarioC);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getUsuario() {
		return usuario;
	}
	public void setUsuario(long usuarioC) {
		this.usuario = usuarioC;
	}
}
