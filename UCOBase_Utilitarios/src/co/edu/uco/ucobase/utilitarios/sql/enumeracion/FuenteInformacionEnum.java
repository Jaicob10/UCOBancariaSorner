package co.edu.uco.ucobase.utilitarios.sql.enumeracion;

public enum FuenteInformacionEnum {
	MY_SQL("MySQL"), SQL_SERVER("SQL Server"), POSTGRESQL("PostgreSQL"), ORACLE("Oracle"), DB2("DB2");

	private String nombre;

	private FuenteInformacionEnum(final String nombre) {
		setNombre(nombre);
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}
}
