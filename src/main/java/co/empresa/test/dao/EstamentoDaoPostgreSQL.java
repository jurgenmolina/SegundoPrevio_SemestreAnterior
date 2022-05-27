package co.empresa.test.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.modelo.Eleccion;
import co.empresa.test.modelo.Estamento;
import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;
import co.empresa.test.util.ConexionMySQL;
import co.empresa.test.util.ConexionPostgreSQL;

public class EstamentoDaoPostgreSQL implements EstamentoDao {
	
	private ConexionPostgreSQL conexion;
	
	private static final String SELECT_TIPO_BY_ID = "SELECT * FROM usuario WHERE id = ?;";
	private static final String SELECT_ALL_ESTAMENTOS = "SELECT * FROM estamento;";
	
	
	
	public EstamentoDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}	
	
	public List<Estamento> selectAll() {
		List <Estamento> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_ESTAMENTOS);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				Eleccion eleccion = new Eleccion();
				eleccion.setId(rs.getInt("eleccion"));
				String descripcion = rs.getString("descripcion");
				
				usuarios.add(new Estamento(id, eleccion,descripcion));
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuarios;
		
	}
	
	
	public Estamento select(int id) {
		Estamento usuario = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_TIPO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String descripcion = rs.getString("descripcion");
				usuario = new Estamento();
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuario;
		
	}
}