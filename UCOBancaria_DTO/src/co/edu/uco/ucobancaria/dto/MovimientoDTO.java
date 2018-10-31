package co.edu.uco.ucobancaria.dto;

import static co.edu.uco.ucobase.utilitarios.cadenas.UtilTexto.obtenerUtilTexto;
import static co.edu.uco.ucobase.utilitarios.fecha.UtilFecha.obtenerUtilFecha;
import static co.edu.uco.ucobase.utilitarios.objeto.UtilObjeto.obtenerUtilObjeto;

import java.util.Date;

public final class MovimientoDTO {

	private int codigo;
	private Date fecha;
	private TipoMovimientoDTO tipoMovimiento;
	private CuentaDTO cuenta;
	private double valor;
	private double naturalezaValor;
	private String comentario;

	public MovimientoDTO() {
		super();
	}

	public MovimientoDTO(final int codigo, final Date fecha, final TipoMovimientoDTO tipoMovimiento, final CuentaDTO cuenta, final double valor, final String comentario) {
		super();
		setCodigo(codigo);
		setFecha(fecha);
		setTipoMovimiento(tipoMovimiento);
		setCuenta(cuenta);
		setValor(valor);
		setComentario(comentario);
	}

	public final int getCodigo() {
		return codigo;
	}

	public final void setCodigo(final int codigo) {
		this.codigo = codigo;
	}

	public final Date getFecha() {
		return fecha;
	}

	public final void setFecha(final Date fecha) {
		this.fecha = obtenerUtilObjeto().obtenerValorDefecto(fecha, obtenerUtilFecha().obtenerFechaActual());
	}

	public final TipoMovimientoDTO getTipoMovimiento() {
		return tipoMovimiento;
	}

	public final void setTipoMovimiento(final TipoMovimientoDTO tipoMovimiento) {
		this.tipoMovimiento = obtenerUtilObjeto().obtenerValorDefecto(tipoMovimiento, new TipoMovimientoDTO());
	}

	public final CuentaDTO getCuenta() {
		return cuenta;
	}

	public final void setCuenta(final CuentaDTO cuenta) {
		this.cuenta = obtenerUtilObjeto().obtenerValorDefecto(cuenta, new CuentaDTO());
	}

	public final double getValor() {
		return valor;
	}

	public final void setValor(final double valor) {
		this.valor = valor;
	}

	public final double getNaturalezaValor() {
		return naturalezaValor;
	}

	public final void setNaturalezaValor(final double naturalezaValor) {
		this.naturalezaValor = naturalezaValor;
	}

	public final String getComentario() {
		return comentario;
	}

	public final void setComentario(final String comentario) {
		this.comentario = obtenerUtilTexto().aplicarTrim(comentario);
	}

}
