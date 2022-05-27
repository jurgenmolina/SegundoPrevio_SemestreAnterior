




package co.empresa.test.dao;

public class CandidatoDaoFactory {

	public static CandidatoDao getCandidatoDao(String type) {
		switch(type) {
		case "mysql":
			return new CandidatoDaoPostgreSQL();
		case "postgresql":
			return new CandidatoDaoPostgreSQL();
		default:
			return new CandidatoDaoPostgreSQL();
		}
	}
	
}
