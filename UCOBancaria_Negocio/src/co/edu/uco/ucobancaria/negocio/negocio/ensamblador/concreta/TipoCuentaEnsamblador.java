package co.edu.uco.ucobancaria.negocio.negocio.ensamblador.concreta;

import static co.edu.uco.ucobase.utilitarios.objeto.UtilObjeto.obtenerUtilObjeto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.ucobancaria.dominio.TipoCuentaDominio;
import co.edu.uco.ucobancaria.dto.TipoCuentaDTO;
import co.edu.uco.ucobancaria.negocio.negocio.ensamblador.IEnsamblador;
import co.edu.uco.ucobase.utilitarios.dominio.enumeracion.OperacionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;

public final class TipoCuentaEnsamblador implements IEnsamblador<TipoCuentaDominio, TipoCuentaDTO> {

	private static final IEnsamblador<TipoCuentaDominio, TipoCuentaDTO> INSTANCIA = new TipoCuentaEnsamblador();

	private TipoCuentaEnsamblador() {
		super();
	}

	public static final IEnsamblador<TipoCuentaDominio, TipoCuentaDTO> obtenerTipoCuentaEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public final TipoCuentaDTO enmsablarDTO(final TipoCuentaDominio objetoDominio) {

		if (obtenerUtilObjeto().objetoEsNulo(objetoDominio)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando realizar la operación deseada sobre un tipo de cuenta";
			final String mensajeTecnico = "No es posible ensamblar un TipoCuentaDTO con un TipoCuentaDominio nulo.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.NEGOCIO);
		}

		return new TipoCuentaDTO(objetoDominio.getCodigo(), objetoDominio.getNombre());
	}

	@Override
	public final TipoCuentaDominio ensamblarDominio(final TipoCuentaDTO objetoDto, final OperacionEnum operacion) {

		if (obtenerUtilObjeto().objetoEsNulo(operacion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando realizar la operación deseada sobre un tipo de cuenta";
			final String mensajeTecnico = "No es posible ensamblar un TipoCuentaDominio con la operación vacía. La operación es requerida para asegurar la integridad del objeto.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.NEGOCIO);
		}

		final TipoCuentaDTO mapeadorDTO = obtenerUtilObjeto().obtenerValorDefecto(objetoDto, new TipoCuentaDTO());

		return TipoCuentaDominio.CREAR(mapeadorDTO.getCodigo(), mapeadorDTO.getNombre(), operacion);
	}

	@Override
	public final List<TipoCuentaDTO> enmsablarListaDTO(final List<TipoCuentaDominio> listaObjetosDominio) {

		final List<TipoCuentaDominio> listaMapeadoraDominio = obtenerUtilObjeto().obtenerValorDefecto(listaObjetosDominio, new ArrayList<>());
		final List<TipoCuentaDTO> listaDtos = new ArrayList<>();

		for (final TipoCuentaDominio tipoCuentaDominio : listaMapeadoraDominio) {
			listaDtos.add(enmsablarDTO(tipoCuentaDominio));
		}

		return listaDtos;
	}
}
