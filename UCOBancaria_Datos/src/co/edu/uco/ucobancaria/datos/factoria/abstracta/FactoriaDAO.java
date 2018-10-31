package co.edu.uco.ucobancaria.datos.factoria.abstracta;

import static co.edu.uco.ucobase.utilitarios.objeto.UtilObjeto.obtenerUtilObjeto;

import co.edu.uco.ucobancaria.datos.dao.interfaces.IClienteDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ICuentaDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.IMovimientoDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoCuentaDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoMovimientoDAO;
import co.edu.uco.ucobancaria.datos.factoria.concreta.sqlserver.SQLServerFactoriaDAO;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;
import co.edu.uco.ucobase.utilitarios.sql.enumeracion.FuenteInformacionEnum;

public abstract class FactoriaDAO {

	public static FactoriaDAO obtenerFactoria(FuenteInformacionEnum fuente) {

		FactoriaDAO retorno;

		if (obtenerUtilObjeto().objetoEsNulo(fuente)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de obtener una conexión con la fuente de información";
			final String mensajeTecnico = "Se requiere saber la factoria que se desea obtener.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DATOS);
		}

		switch (fuente) {
		case SQL_SERVER:
			retorno = new SQLServerFactoriaDAO();
			break;
		default:
			final String mensajeUsuario = "Se ha presentado un problema tratando de obtener una conexión con la fuente de información";
			final String mensajeTecnico = "La factoria " + fuente.getNombre() + " no se encuentra implementada.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DATOS);
		}

		return retorno;
	}

	protected abstract void abrirConexion();

	public abstract void iniciarTransaccion();

	public abstract void confirmarTransaccion();

	public abstract void cancelarTransaccion();

	public abstract void cerrarConexion();

	public abstract IClienteDAO obtenerClienteDAO();

	public abstract ICuentaDAO obtenerCuentaDAO();

	public abstract IMovimientoDAO obtenerMovimientoDAO();

	public abstract ITipoCuentaDAO obtenerTipoCuentaDAO();

	public abstract ITipoMovimientoDAO obtenerTipoMovimientoDAO();
}
