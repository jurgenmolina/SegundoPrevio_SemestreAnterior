




package co.empresa.test.dao;

public class TipoDocumentoDaoFactory {

	public static TipoDocumentoDao getTipoDocumentoDao(String type) {
		switch(type) {
		case "mysql":
			return new TipoDocumentoDaoPostgreSQL();
		case "postgresql":
			return new TipoDocumentoDaoPostgreSQL();
		default:
			return new TipoDocumentoDaoPostgreSQL();
		}
	}
	
}
