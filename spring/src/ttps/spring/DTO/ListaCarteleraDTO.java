package ttps.spring.DTO;

public class ListaCarteleraDTO {
	private Long id;
	private String titulo;
	private String subtitulo;
	private String info;

	public ListaCarteleraDTO(Long id,String titulo,String subtitulo, String info) {
		this.setId(id);
		this.setTitulo(titulo);
		this.setSubtitulo(subtitulo);
		this.setInfo(info);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getInfoa() {
		return info;
	}
	public void setInfo(String propia) {
		this.info = propia;
	}
	
	

}
