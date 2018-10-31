package co.edu.uco.ucobancaria.datos.dao.interfaces;

import java.util.List;

import co.edu.uco.ucobancaria.dominio.TipoMovimientoDominio;

public interface ITipoMovimientoDAO {

	void crear(TipoMovimientoDominio tipoMovimiento);

	void actualizar(TipoMovimientoDominio tipoMovimiento);

	void eliminar(TipoMovimientoDominio tipoMovimiento);

	List<TipoMovimientoDominio> consultar(TipoMovimientoDominio tipoMovimiento);
}