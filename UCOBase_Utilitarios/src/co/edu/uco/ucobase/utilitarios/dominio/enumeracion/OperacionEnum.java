package co.edu.uco.ucobase.utilitarios.dominio.enumeracion;

import static co.edu.uco.ucobase.utilitarios.objeto.UtilObjeto.obtenerUtilObjeto;

public enum OperacionEnum {
	
	CREAR, ACTUALIZAR, ELIMINAR, CONSULTAR, POBLAR, DEPENDENCIA, SIN_VALOR;
	
	public final static OperacionEnum obtenerValorDefecto(final OperacionEnum operacion) {
		return obtenerUtilObjeto().obtenerValorDefecto(operacion, OperacionEnum.SIN_VALOR);
	}

}
