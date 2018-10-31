package co.edu.uco.ucobancaria.negocio.negocio.ensamblador;

import java.util.List;

import co.edu.uco.ucobase.utilitarios.dominio.enumeracion.OperacionEnum;

public interface IEnsamblador<Dominio, DTO> {

	DTO enmsablarDTO(Dominio objetoDominio);

	Dominio ensamblarDominio(DTO objetoDto, OperacionEnum operacion);

	List<DTO> enmsablarListaDTO(List<Dominio> listaObjetosDominio);
}
