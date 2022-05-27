




package co.empresa.test.dao;

public class EstamentoDaoFactory {

	public static EstamentoDao getEstamentoDao(String type) {
		switch(type) {
		case "mysql":
			return new EstamentoDaoPostgreSQL();
		case "postgresql":
			return new EstamentoDaoPostgreSQL();
		default:
			return new EstamentoDaoPostgreSQL();
		}
	}
	
}
