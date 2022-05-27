package co.empresa.test.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.test.modelo.Candidato;
import co.empresa.test.modelo.Usuario;
import co.empresa.test.modelo.Votante;

public interface CandidatoDao {
	public void insert(Candidato user) throws SQLException;
	public Candidato select(int id);
	public List < Candidato > selectAll();
	public void delete(int id) throws SQLException;
	public void update(Candidato user) throws SQLException;
}
