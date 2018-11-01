package co.edu.uco.ucobancaria.negocio.fachada.concreta;

import java.util.List;

import co.edu.uco.ucobancaria.datos.factoria.abstracta.FactoriaDAO;
import co.edu.uco.ucobancaria.dto.TipoCuentaDTO;
import co.edu.uco.ucobancaria.negocio.fachada.ITipoCuentaFachada;
import co.edu.uco.ucobancaria.negocio.negocio.ITipoCuentaNegocio;
import co.edu.uco.ucobancaria.negocio.negocio.concreta.TipoCuentaNegocio;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;
import co.edu.uco.ucobase.utilitarios.sql.enumeracion.FuenteInformacionEnum;

public class TipoCuentaFachada implements ITipoCuentaFachada{

	@Override
	public void crear(final TipoCuentaDTO tipoCuenta) {
		final FactoriaDAO factoria = FactoriaDAO.obtenerFactoria(FuenteInformacionEnum.SQL_SERVER);
		
		try {
			factoria.iniciarTransaccion();
			
			final ITipoCuentaNegocio negocio = new TipoCuentaNegocio(factoria);
			
			factoria.confirmarTransaccion();
			
		}catch(final AplicacionExcepcion excepcion) {
			factoria.cancelarTransaccion();
			throw excepcion;
		}catch(final Exception excepcion) {
			factoria.cancelarTransaccion();
			final String mensajeUsuario = "Se ha presentado un problema tratando de registrar la informacion del nuevo tipo de cuenta" ;
			final String mensajeTecnico = "Se ha presentado un problema tratando de crear el nuevo tipo de cuenta" ;
			throw AplicacionExcepcion.CREAR(mensajeTecnico,mensajeUsuario, excepcion, ExcepcionEnum.FACHADA);
		}finally {
			factoria.cerrarConexion();
		}
		
	}

	@Override
	public void actualizar(TipoCuentaDTO tipoCuenta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(TipoCuentaDTO tipoCuenta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoCuentaDTO> consultar(TipoCuentaDTO tipoCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

}
