package co.edu.uco.ucobancaria.datos.dao.interfaces;

import java.util.List;

import co.edu.uco.ucobancaria.dominio.TipoCuentaDominio;

public interface ITipoCuentaDAO {

	void crear(TipoCuentaDominio tipoCuenta);

	void actualizar(TipoCuentaDominio tipoCuenta);

	void eliminar(TipoCuentaDominio tipoCuenta);

	List<TipoCuentaDominio> consultar(TipoCuentaDominio tipoCuenta);
}
