




package co.empresa.test.dao;

public class EleccionDaoFactory {

	public static EleccionDao getEleccionDao(String type) {
		switch(type) {
		case "mysql":
			return new EleccionDaoPostgreSQL();
		case "postgresql":
			return new EleccionDaoPostgreSQL();
		default:
			return new EleccionDaoPostgreSQL();
		}
	}
	
}
