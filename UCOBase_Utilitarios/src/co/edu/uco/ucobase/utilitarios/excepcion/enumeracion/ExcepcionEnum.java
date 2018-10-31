package co.edu.uco.ucobase.utilitarios.excepcion.enumeracion;

public enum ExcepcionEnum {

	DATOS("DATOS", "Excepción presentada en la capa de datos"), 
	NEGOCIO("NEGOCIO", "Excepción presentada en la capa de lógica de negocio"), 
	FACHADA("FACHADA", "Excepción presentada en la capa de fachada"), 
	API("API", "Excepción presentada en la capa de servicios"),
	DTO("DTO", "Excepción presentada en la capa de dto"),
	DOMINIO("DOMINIO", "Excepción presentada en la capa de dominio"),
	GENERAL("GENERAL", "Excepción presentada a nivel General");

	private String codigo;
	private String nombre;

	private ExcepcionEnum(final String codigo, final String nombre) {
		setCodigo(codigo);
		setNombre(nombre);
	}

	public String getCodigo() {
		return codigo;
	}

	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
