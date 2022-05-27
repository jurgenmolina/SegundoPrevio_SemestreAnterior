package co.empresa.test.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.modelo.Candidato;
import co.empresa.test.modelo.Eleccion;
import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;
import co.empresa.test.modelo.Votante;
import co.empresa.test.util.ConexionMySQL;
import co.empresa.test.util.ConexionPostgreSQL;

public class CandidatoDaoPostgreSQL implements 	CandidatoDao {
	
	private ConexionPostgreSQL conexion;
	
	private static final String INSERT_Candidato_SQL = "INSERT INTO candidato (documento, nombre, apellido, eleccion, numero) VALUES (?, ?, ?, ?, ?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM usuario WHERE id = ?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE usuario SET nombre = ?, email = ?, pais = ? WHERE id = ?;";
	private static final String SELECT_CANDIDATO_BY_ID = "SELECT * FROM candidato WHERE id = ?;";
	private static final String SELECT_ALL_CANDIDATOS = "SELECT * FROM candidato;";
	
	
	
	public CandidatoDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}

	public void insert(Candidato candidato) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_Candidato_SQL);
			preparedStatement.setString(1, candidato.getDocumento());
			preparedStatement.setString(2, candidato.getNombre());
			preparedStatement.setString(3, candidato.getApellido());
			preparedStatement.setInt(4, candidato.getEleccion().getId());
			preparedStatement.setInt(5, candidato.getNumero());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public void delete (int id)  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1, id);

			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public void update(Candidato usuario)  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setInt(4, usuario.getId());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public List<Candidato> selectAll() {
		List <Candidato> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_CANDIDATOS);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String documento = rs.getString("documento");
				
				Eleccion eleccion = new Eleccion();
				eleccion.setId(rs.getInt("eleccion"));
				Integer numero = rs.getInt("numero");
				
				usuarios.add(new Candidato(id, documento, nombre, apellido, eleccion, numero));
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuarios;
		
	}
	
	
	public Candidato select(int id) {
		Candidato usuario = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_CANDIDATO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Eleccion eleccion = new Eleccion();
				eleccion.setId(rs.getInt("eleccion"));
				int numero = rs.getInt("numero");
				usuario = new Candidato(documento, nombre, apellido, eleccion, numero);
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuario;
		
	}
}