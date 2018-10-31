package co.edu.uco.ucobancaria.datos.factoria.concreta.sqlserver;

import static co.edu.uco.ucobase.utilitarios.sql.UtilSQL.obtenerUtilSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.ucobancaria.datos.dao.concreta.sqlserver.TipoCuentaSQLServerDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.IClienteDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ICuentaDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.IMovimientoDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoCuentaDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoMovimientoDAO;
import co.edu.uco.ucobancaria.datos.factoria.abstracta.FactoriaDAO;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;

public final class SQLServerFactoriaDAO extends FactoriaDAO {

	private Connection conexion;

	public SQLServerFactoriaDAO() {
		super();
		abrirConexion();
	}

	@Override
	protected final void abrirConexion() {

		if (obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de obtener una conexión con la fuente de información";
			final String mensajeTecnico = "Se requiere saber la factoria que se desea obtener.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DATOS);
		}

		try {
			final String cadenaConexion = "jdbc:sqlserver://prueba-farid.database.windows.net:1433;database=UCOBancaria;user=ucobancaria_dml;password=uc0b4nc4r14.2018;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection(cadenaConexion);
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de abrir una conexión con la fuente de información";
			final String mensajeTecnico = "Se ha presentado un problema tratando de obtener la conexión con SQL Server. Por favor revise la traza de errores.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de abrir una conexión con la fuente de información";
			final String mensajeTecnico = "Se ha presentado un problema inesperado tratando de obtener la conexión con SQL Server. Por favor revise la traza de errores.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		}
	}

	@Override
	public final void cerrarConexion() {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cerrar la conexión contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de cerrar la conexión contra SQL Server. La conexión ya se encuentra cerrada.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DATOS);
		}

		try {
			conexion.close();
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cerrar la conexión contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de cerrar la conexión contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cerrar la conexión contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema inesperado tratando de cerrar la conexión contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		}
	}

	@Override
	public final void iniciarTransaccion() {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de iniciar una operación contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de iniciar una transacción contra SQL Server. La conexión se encuentra cerrada.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DATOS);
		}

		try {
			conexion.setAutoCommit(false);
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de iniciar una operación contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de iniciar una transacción contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de iniciar una operación contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema inesperado tratando de iniciar una transacción contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		}
	}

	@Override
	public final void confirmarTransaccion() {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de confirmar los cambios de una operación contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de confirmar una transacción contra SQL Server. La conexión se encuentra cerrada.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DATOS);
		}

		try {
			conexion.commit();
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de confirmar los cambios de una operación contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de confirmar una transacción contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de confirmar los cambios de una operación contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema inesperado tratando de confirmar una transacción contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		}
	}

	@Override
	public final void cancelarTransaccion() {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cancelar los cambios de una operación contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de cancelar una transacción contra SQL Server. La conexión se encuentra cerrada.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DATOS);
		}

		try {
			conexion.rollback();
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cancelar los cambios de una operación contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de cancelar una transacción contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cancelar los cambios de una operación contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema inesperado tratando de cancelar una transacción contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnum.DATOS);
		}
	}

	@Override
	public IClienteDAO obtenerClienteDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICuentaDAO obtenerCuentaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMovimientoDAO obtenerMovimientoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final ITipoCuentaDAO obtenerTipoCuentaDAO() {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando realizar la operación deseada un tipo de cuenta";
			final String mensajeTecnico = "No es posible crear un TipoCuentaSQLServerDAO con una conexión que no está abierta.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DATOS);
		}

		return new TipoCuentaSQLServerDAO(conexion);
	}

	@Override
	public ITipoMovimientoDAO obtenerTipoMovimientoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
