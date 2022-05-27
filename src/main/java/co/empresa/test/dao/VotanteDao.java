package co.empresa.test.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.test.modelo.Usuario;
import co.empresa.test.modelo.Votante;

public interface VotanteDao {
	public void insert(Votante user) throws SQLException;
	public Votante select(int id);
	public List < Votante > selectAll();
	public void delete(int id) throws SQLException;
	public void update(Votante user) throws SQLException;
}
