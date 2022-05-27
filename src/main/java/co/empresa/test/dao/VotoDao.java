package co.empresa.test.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.test.modelo.Estamento;
import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;
import co.empresa.test.modelo.Voto;

public interface VotoDao {
	public Voto select(int id);
	public List < Voto > selectAll();
	public void insert(Voto voto) throws SQLException;
}
