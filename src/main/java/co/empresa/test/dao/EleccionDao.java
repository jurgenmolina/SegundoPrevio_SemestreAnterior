package co.empresa.test.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.test.modelo.Eleccion;
import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;

public interface EleccionDao {
	public Eleccion select(int id);
	public List < Eleccion > selectAll();
}
