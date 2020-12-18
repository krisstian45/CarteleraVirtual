package ttps.spring.DTO;

public class CreateCarteleraDTO {
	private long idUsuario;
	private String titulo;
	private String subtitulo;
	private String informarcion;
	private long docente;
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getInformarcion() {
		return informarcion;
	}
	public void setInformarcion(String informarcion) {
		this.informarcion = informarcion;
	}
	public long getDocente() {
		return docente;
	}
	public void setDocente(long docente) {
		this.docente = docente;
	}
	
	
	
}
