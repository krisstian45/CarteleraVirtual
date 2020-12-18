package ttps.spring.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="COMENTARIO")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@comentarioId")
public class Comentario {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contenido;
	
	@OneToOne(optional=false)
	private Usuario usuario;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="publicacion_id")
	private Publicacion publicacion;
	
	public Comentario() {
		
		
	}
	

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuarios) {
		this.usuario = usuarios;
	}


	public Publicacion getPublicacion() {
		return publicacion;
	}


	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
}
