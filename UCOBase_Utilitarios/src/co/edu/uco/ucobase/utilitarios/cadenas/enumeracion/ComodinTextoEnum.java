package co.edu.uco.ucobase.utilitarios.cadenas.enumeracion;

public enum ComodinTextoEnum {
	
	BLANCO(""), SIGNO_SUMA("+"), SIGNO_RESTA("-");
	
	private String comodin;

	private ComodinTextoEnum(final String comodin) {
		setComodin(comodin);
	}

	public final String getComodin() {
		return comodin;
	}

	private final void setComodin(final String comodin) {
		this.comodin = comodin;
	}
}
