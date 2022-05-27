




package co.empresa.test.dao;

public class VotoDaoFactory {

	public static VotoDao getVotoDao(String type) {
		switch(type) {
		case "mysql":
			return new VotoDaoPostgreSQL();
		case "postgresql":
			return new VotoDaoPostgreSQL();
		default:
			return new VotoDaoPostgreSQL();
		}
	}
	
}
