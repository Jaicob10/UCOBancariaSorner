package co.edu.uco.ucobancaria.dto;

import static co.edu.uco.ucobase.utilitarios.cadenas.UtilTexto.obtenerUtilTexto;
import static co.edu.uco.ucobase.utilitarios.objeto.UtilObjeto.obtenerUtilObjeto;

/**
 * Objeto de transferencia de datos que representa a una Cuenta.
 * 
 * @author WSANCHEG
 *
 */
public final class CuentaDTO {

	private int codigo;
	private String numero;
	private TipoCuentaDTO tipoCuenta;
	private ClienteDTO cliente;
	private double saldo;

	public CuentaDTO() {
		super();
	}

	public CuentaDTO(final int codigo, final String numero, final TipoCuentaDTO tipoCuenta, final ClienteDTO cliente,
			final double saldo) {
		super();
		setCodigo(codigo);
		setNumero(numero);
		setTipoCuenta(tipoCuenta);
		setCliente(cliente);
		setSaldo(saldo);
	}

	public final int getCodigo() {
		return codigo;
	}

	public final void setCodigo(final int codigo) {
		this.codigo = codigo;
	}

	public final String getNumero() {
		return numero;
	}

	public final void setNumero(final String numero) {
		this.numero = obtenerUtilTexto().aplicarTrim(numero);
	}

	public final TipoCuentaDTO getTipoCuenta() {
		return tipoCuenta;
	}

	public final void setTipoCuenta(final TipoCuentaDTO tipoCuenta) {
		this.tipoCuenta = obtenerUtilObjeto().obtenerValorDefecto(tipoCuenta, new TipoCuentaDTO());
	}

	public final ClienteDTO getCliente() {
		return cliente;
	}

	public final void setCliente(final ClienteDTO cliente) {
		this.cliente = obtenerUtilObjeto().obtenerValorDefecto(cliente, new ClienteDTO());
	}

	public final double getSaldo() {
		return saldo;
	}

	public final void setSaldo(final double saldo) {
		this.saldo = saldo;
	}
}
