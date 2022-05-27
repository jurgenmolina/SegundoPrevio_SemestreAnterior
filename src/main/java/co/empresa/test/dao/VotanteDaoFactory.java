




package co.empresa.test.dao;

public class VotanteDaoFactory {

	public static VotanteDao getVotanteDao(String type) {
		switch(type) {
		case "mysql":
			return new VotanteDaoPostgreSQL();
		case "postgresql":
			return new VotanteDaoPostgreSQL();
		default:
			return new VotanteDaoPostgreSQL();
		}
	}
	
}
