package ttps.spring.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "perfil")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@perfilId")
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PERFIL_ID")
	private Long id;
	private String tipoPerfil;
	
	//@JsonBackReference
	@OneToMany(mappedBy="perfil",fetch=FetchType.EAGER)
	private Set<Usuario> usuarios;

	public Perfil() {
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

	public void setUsuarios(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

}