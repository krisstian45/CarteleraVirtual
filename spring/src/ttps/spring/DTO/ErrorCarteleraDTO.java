package ttps.spring.DTO;

public class ErrorCarteleraDTO {
	private String tituloError;
	private String subtituloError;
	private String informarcionError;
	private String docenteError;
	private Boolean pass;
	
	
	public ErrorCarteleraDTO() {}
	public Boolean getPass() {
		return pass;
	}
	public void setPass(Boolean pass) {
		this.pass = pass;
	}
	public String getTituloError() {
		return tituloError;
	}
	public void setTituloError(String tituloError) {
		this.tituloError = tituloError;
	}
	public String getSubtituloError() {
		return subtituloError;
	}
	public void setSubtituloError(String subtituloError) {
		this.subtituloError = subtituloError;
	}
	public String getInformarcionError() {
		return informarcionError;
	}
	public void setInformarcionError(String informarcionError) {
		this.informarcionError = informarcionError;
	}
	public String getDocenteError() {
		return docenteError;
	}
	public void setDocenteError(String docenteError) {
		this.docenteError = docenteError;
	}
	
	
}
