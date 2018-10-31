package co.edu.uco.ucobancaria.datos.dao.interfaces;

import java.util.List;

import co.edu.uco.ucobancaria.dominio.ClienteDominio;

public interface IClienteDAO {

	void crear(ClienteDominio cliente);

	void actualizar(ClienteDominio cliente);

	void eliminar(ClienteDominio cliente);

	List<ClienteDominio> consultar(ClienteDominio cliente);
}
