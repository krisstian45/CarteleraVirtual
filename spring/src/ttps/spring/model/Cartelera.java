package ttps.spring.model;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@carteleraId")
public class Cartelera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String subtitulo;
	private String informarcion;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Tag> tags;

	@OneToMany(mappedBy = "cartelera")
	private Set<Publicacion> publicaciones;

	// @JsonBackReference
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "dueño_id")
	private Usuario dueño;

	// @JsonBackReference
	@ManyToMany(mappedBy = "cartelerasDeInteres")
	private Set<Usuario> interesados;

	@ManyToMany(mappedBy = "cartelerasDePublicadoresAcceso")
	private Set<Usuario> misPublicadores;

	public Cartelera() {

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

	public String getInformarcion() {
		return informarcion;
	}

	public void setInformarcion(String informarcion) {
		this.informarcion = informarcion;
	}

	public Set<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(Publicacion publicaciones) {
		this.publicaciones.add(publicaciones);
	}

	public Set<Tag> getNombreTag() {
		return tags;
	}

	public void setNombreTag(Tag nombreTag) {
		this.tags.add(nombreTag);
	}
	/*
	 * public List<Usuario> getSuscriptos() { return suscriptos; }
	 * 
	 * public void setSuscriptos(Usuario suscriptos) {
	 * this.suscriptos.add(suscriptos); }
	 */

	public Usuario getDueño() {
		return dueño;
	}

	public void setDueño(Usuario usuario) {
		this.dueño = usuario;
	}

	public Set<Usuario> getInteresados() {
		return interesados;
	}

	public void setInteresados(Usuario interes) {
		this.interesados.add(interes);
	}

	public Set<Usuario> getMisPublicadores() {
		return misPublicadores;
	}

	public void setMisPublicadores(Usuario misPublicadores) {
		this.misPublicadores.add(misPublicadores);
	}
	/*
	 * public List getArchivosAdjunto() { return archivosAdjunto; } public void
	 * setArchivosAdjunto(A archivosAdjunto) { this.archivosAdjunto =
	 * archivosAdjunto; }
	 */

}
