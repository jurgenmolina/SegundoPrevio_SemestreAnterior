package co.empresa.test.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;
import co.empresa.test.util.ConexionMySQL;
import co.empresa.test.util.ConexionPostgreSQL;

public class TipoDocumentoDaoPostgreSQL implements TipoDocumentoDao {
	
	private ConexionPostgreSQL conexion;
	
	private static final String SELECT_TIPO_BY_ID = "SELECT * FROM usuario WHERE id = ?;";
	private static final String SELECT_ALL_TIPOS = "SELECT * FROM tipodocumento;";
	
	
	
	public TipoDocumentoDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}	
	
	public List<TipoDocumento> selectAll() {
		List <TipoDocumento> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_TIPOS);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");
				System.out.println("La id es : " + id + "  descripcion " + descripcion);
				usuarios.add(new TipoDocumento(id, descripcion));
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuarios;
		
	}
	
	
	public TipoDocumento select(int id) {
		TipoDocumento usuario = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_TIPO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String descripcion = rs.getString("descripcion");
				usuario = new TipoDocumento(id, descripcion);
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuario;
		
	}
}