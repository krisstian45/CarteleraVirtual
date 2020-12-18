package ttps.spring.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "usuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@usuarioId")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USUARIO_ID")
	private Long id;
	private String nombre;
	private String usuario;
	private String contra;
	private String matricula;
	private String numeroAlumno;
	private String token;

	@ManyToOne
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Permiso> permisos;

	@OneToMany(mappedBy = "usuario")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Notificacion> notificaciones;

	@OneToMany(mappedBy = "dueño")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Cartelera> dueñoDe;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
	        name = "UsuarioInteres_CarteleraInteres", 
	        joinColumns = { @JoinColumn(name = "usuario_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "cartelera_id") }
	    )
	private Set<Cartelera> cartelerasDeInteres;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	 @JoinTable(
		        name = "UsuarioPublicadores_CarteleraPublciadores", 
		        joinColumns = { @JoinColumn(name = "usuario_id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "cartelera_id") }
		    )
	private Set<Cartelera> cartelerasDePublicadoresAcceso;

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getNumeroAlumno() {
		return numeroAlumno;
	}

	public void setNumeroAlumno(String numeroAlumno) {
		this.numeroAlumno = numeroAlumno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Permiso permisos) {
		this.permisos.add(permisos);
	}

	public Set<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(Notificacion notificacion) {
		this.notificaciones.add(notificacion);
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set<Cartelera> getDueñoDe() {
		return dueñoDe;
	}

	public void setDueñoDe(Set<Cartelera> dueñoDe) {
		this.dueñoDe = dueñoDe;
	}

	public Set<Cartelera> getCartelerasDeInteres() {
		return cartelerasDeInteres;
	}

	public void setCartelerasDeInteres(Cartelera carteleraDeInteres) {
		this.cartelerasDeInteres.add(carteleraDeInteres);
	}

	public Set<Cartelera> getCartelerasDePublicadoresAcceso() {
		return cartelerasDePublicadoresAcceso;
	}

	public void setCartelerasDePublicadoresAcceso(Cartelera cartelerasDePublicadoresAcceso) {
		this.cartelerasDePublicadoresAcceso.add(cartelerasDePublicadoresAcceso);
	}
}
