package co.edu.uco.ucobancaria.dto;

import static co.edu.uco.ucobase.utilitarios.cadenas.UtilTexto.obtenerUtilTexto;

/**
 * Objeto de transferencia de datos que representa a un Cliente.
 * 
 * @author WSANCHEG
 *
 */
public final class ClienteDTO {

	private int codigo;
	private String numeroIdentificacion;
	private String nombre;
	private String correo;
	private String clave;

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(final int codigo, final String numeroIdentificacion, final String nombre, final String correo, final String clave) {
		super();
		setCodigo(codigo);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombre(nombre);
		setCorreo(correo);
		setClave(clave);
	}

	public final int getCodigo() {
		return codigo;
	}

	public final void setCodigo(final int codigo) {
		this.codigo = codigo;
	}

	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = obtenerUtilTexto().aplicarTrim(numeroIdentificacion);
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(final String nombre) {
		this.nombre = obtenerUtilTexto().aplicarTrim(nombre);
	}

	public final String getCorreo() {
		return correo;
	}

	public final void setCorreo(final String correo) {
		this.correo = obtenerUtilTexto().aplicarTrim(correo);
	}

	public final String getClave() {
		return clave;
	}

	public final void setClave(final String clave) {
		this.clave = obtenerUtilTexto().aplicarTrim(clave);
	}

}
