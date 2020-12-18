package ttps.spring.model;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="PUBLICACION")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@publicacionId")
public class Publicacion{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PUBLICACION_ID")
	private Long id;
	private String titulo;
	private String subtitulo;
	private String texto;
	private String comentariosHabilitados;
	private Long id_dueño;
	
	@ManyToOne (optional=false)
	@JoinColumn(name="cartelera_id")
	private Cartelera cartelera;
	
	public Cartelera getCartelera() {
		return cartelera;
	}
	public void setCartelera(Cartelera cartelera) {
		this.cartelera = cartelera;
	}
	@OneToMany(mappedBy="publicacion")
	private List<Comentario> comentarios;
	
	
	
	
	public Publicacion(){
		
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getComentariosHabilitados() {
		return comentariosHabilitados;
	}
	public void setComentariosHabilitados(String comentariosHabilitados) {
		this.comentariosHabilitados = comentariosHabilitados;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(Comentario comentarios) {
		this.comentarios.add(comentarios);
	}
	public Long getId_dueño() {
		return id_dueño;
	}
	public void setId_dueño(Long id_dueño) {
		this.id_dueño = id_dueño;
	}
}
