package co.edu.uco.ucobase.utilitarios.objeto;

/**
 * Objeto utilitario que expone servicios que pueden ser utilizados de forma
 * genérica por algun objeto que los requiera.
 * 
 * @author WSANCHEG
 *
 */
public final class UtilObjeto {

	private static final UtilObjeto INSTANCIA = new UtilObjeto();

	private UtilObjeto() {
		super();
	}

	public static final UtilObjeto obtenerUtilObjeto() {
		return INSTANCIA;
	}

	public final <T> T obtenerValorDefecto(final T objeto, final T valorDefecto) {

		T retorno = objeto;

		if (objetoEsNulo(objeto)) {
			retorno = valorDefecto;
		}

		return retorno;
	}

	public final <T> boolean objetoEsNulo(final T objeto) {
		return (objeto == null);
	}
}
