package co.empresa.test.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.test.modelo.Estamento;
import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;

public interface EstamentoDao {
	public Estamento select(int id);
	public List < Estamento > selectAll();
}
