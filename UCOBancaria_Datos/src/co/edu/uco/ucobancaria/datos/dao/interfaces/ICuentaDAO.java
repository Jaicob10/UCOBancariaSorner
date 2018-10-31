package co.edu.uco.ucobancaria.datos.dao.interfaces;

import java.util.List;

import co.edu.uco.ucobancaria.dominio.CuentaDominio;

public interface ICuentaDAO {

	void crear(CuentaDominio cuenta);

	void actualizar(CuentaDominio cuenta);

	void eliminar(CuentaDominio cuenta);

	List<CuentaDominio> consultar(CuentaDominio cuenta);
}
