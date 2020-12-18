package ttps.spring.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "permiso")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@permisoId")
public class Permiso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PERMISO_ID")
	private Long id;
	private String tipoPermiso;
	
	//@JsonBackReference
	@ManyToMany(mappedBy = "permisos")
	private Set<Usuario> usuarios;

	public Permiso() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios.add(usuarios);
	}

	public String getTipoPermiso() {
		return tipoPermiso;
	}

	public void setTipoPermiso(String tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
	}
}