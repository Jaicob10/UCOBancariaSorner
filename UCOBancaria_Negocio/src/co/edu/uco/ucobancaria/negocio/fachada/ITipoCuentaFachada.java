package co.edu.uco.ucobancaria.negocio.fachada;

import java.util.List;

import co.edu.uco.ucobancaria.dto.TipoCuentaDTO;

public interface ITipoCuentaFachada {
	void crear(TipoCuentaDTO tipoCuenta);

	void actualizar(TipoCuentaDTO tipoCuenta);

	void eliminar(TipoCuentaDTO tipoCuenta);

	List<TipoCuentaDTO> consultar(TipoCuentaDTO tipoCuenta);

}
