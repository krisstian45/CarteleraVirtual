package ttps.spring.DTO;

public class UsuarioLoginDTO {
	private Long id;
	private String nombre;
	private String usuario;
	private String matricula;
	private String numeroAlumno;
	private String token;
	private String perfil;
	
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNumeroAlumno() {
		return numeroAlumno;
	}
	public void setNumeroAlumno(String numeroAlumno) {
		this.numeroAlumno = numeroAlumno;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
