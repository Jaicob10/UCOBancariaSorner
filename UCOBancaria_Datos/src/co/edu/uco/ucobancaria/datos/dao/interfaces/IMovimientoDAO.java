package co.edu.uco.ucobancaria.datos.dao.interfaces;

import java.util.List;

import co.edu.uco.ucobancaria.dominio.MovimientoDominio;

public interface IMovimientoDAO {

	void crear(MovimientoDominio movimiento);

	void actualizar(MovimientoDominio movimiento);

	void eliminar(MovimientoDominio movimiento);

	List<MovimientoDominio> consultar(MovimientoDominio movimiento);
}
