package co.edu.uco.ucobancaria.dominio;

import static co.edu.uco.ucobase.utilitarios.cadenas.UtilTexto.obtenerUtilTexto;

import co.edu.uco.ucobase.utilitarios.cadenas.enumeracion.ComodinTextoEnum;
import co.edu.uco.ucobase.utilitarios.cadenas.enumeracion.ExpresionRegularEnum;
import co.edu.uco.ucobase.utilitarios.dominio.enumeracion.OperacionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;

public final class TipoMovimientoDominio {

	private int codigo;
	private String nombre;
	private String signo;
	private OperacionEnum operacion;

	private TipoMovimientoDominio(final int codigo, final String nombre, final String signo, final OperacionEnum operacion) {
		super();
		setCodigo(codigo);
		setNombre(nombre);
		setSigno(signo);
		setOperacion(operacion);
	}

	public final static TipoMovimientoDominio CREAR(final int codigo, final String nombre, final String signo, final OperacionEnum operacion) {

		final TipoMovimientoDominio retorno = new TipoMovimientoDominio(codigo, nombre, signo, operacion);

		switch (retorno.getOperacion()) {
		case CREAR:
			retorno.asegurarIntegridadNombre();
			retorno.asegurarIntegridadSigno();
			break;
		case ACTUALIZAR:
		case POBLAR:
			retorno.asegurarIntegridadCodigo();
			retorno.asegurarIntegridadNombre();
			retorno.asegurarIntegridadSigno();
			break;
		case DEPENDENCIA:
		case ELIMINAR:
			retorno.asegurarIntegridadCodigo();
			break;
		case CONSULTAR:
			if (retorno.getCodigo() > 0) {
				retorno.asegurarIntegridadCodigo();
			}

			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getNombre())) {
				retorno.asegurarIntegridadNombre();
			}

			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getSigno())) {
				retorno.asegurarIntegridadSigno();
			}
			break;
		default:
			String mensaje = "El objeto Tipo Movimiento no se puede crear, debido a que la operación para validar su integridad no existe.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}

		return retorno;
	}

	public final int getCodigo() {
		return codigo;
	}

	public final String getNombre() {
		return nombre;
	}

	public final String getSigno() {
		return signo;
	}

	public final OperacionEnum getOperacion() {
		return operacion;
	}

	private final void setCodigo(final int codigo) {
		this.codigo = codigo;
	}

	private final void setNombre(final String nombre) {
		this.nombre = obtenerUtilTexto().aplicarTrim(nombre);
	}

	private final void setSigno(final String signo) {
		this.signo = obtenerUtilTexto().aplicarTrim(signo);
	}

	private final void setOperacion(final OperacionEnum operacion) {
		this.operacion = OperacionEnum.obtenerValorDefecto(operacion);
	}

	private void asegurarIntegridadCodigo() {
		if (getCodigo() <= 0) {
			String mensaje = "El código de un tipo de movimiento debe ser mayor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

	private void asegurarIntegridadNombre() {
		if (obtenerUtilTexto().cadenaEsVaciaONula(getNombre())) {
			String mensaje = "El nombre de un tipo de movimiento no puede estar vacío.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getNombre().trim().length() > 250) {
			String mensaje = "El nombre de un tipo de movimiento no tener más de 250 caracteres.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (!ExpresionRegularEnum.SOLO_TEXTO.cumplePatron(getNombre())) {
			String mensaje = "El nombre de un tipo de movimiento sólo puede contener letras y espacios.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}

	private void asegurarIntegridadSigno() {
		if (obtenerUtilTexto().cadenaEsVaciaONula(getSigno())) {
			String mensaje = "El signo de un tipo de movimiento no puede estar vacío.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		} else if (getNombre().trim().intern() != ComodinTextoEnum.SIGNO_SUMA.getComodin() || getNombre().trim().intern() != ComodinTextoEnum.SIGNO_RESTA.getComodin()) {
			String mensaje = "El signo de un tipo de movimiento sólo puede ser más (+) o menos (-).";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnum.DOMINIO);
		}
	}
}