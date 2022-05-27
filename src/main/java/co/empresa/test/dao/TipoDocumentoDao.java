package co.empresa.test.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;

public interface TipoDocumentoDao {
	public TipoDocumento select(int id);
	public List < TipoDocumento > selectAll();
}
