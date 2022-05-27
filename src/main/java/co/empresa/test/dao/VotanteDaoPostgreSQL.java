package co.empresa.test.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.modelo.Eleccion;
import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;
import co.empresa.test.modelo.Votante;
import co.empresa.test.util.ConexionMySQL;
import co.empresa.test.util.ConexionPostgreSQL;

public class VotanteDaoPostgreSQL implements VotanteDao {
	
	private ConexionPostgreSQL conexion;
	
	private static final String INSERT_VOTANTE_SQL = "INSERT INTO votante (nombre, email, documento, tipodocumento, eleccion) VALUES (?, ?, ?, ?, ?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM usuario WHERE id = ?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE usuario SET nombre = ?, email = ?, pais = ? WHERE id = ?;";
	private static final String SELECT_VOTANTE_BY_ID = "SELECT * FROM votante WHERE id = ?;";
	private static final String SELECT_ALL_VOTANTES = "SELECT * FROM votante;";
	
	
	
	public VotanteDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}

	public void insert(Votante votante) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_VOTANTE_SQL);
			System.out.println(votante);
			preparedStatement.setString(1, votante.getNombre());
			preparedStatement.setString(2, votante.getEmail());
			preparedStatement.setString(3, votante.getDocumento());
			preparedStatement.setInt(4, votante.getTipoDocumento().getId());
			preparedStatement.setInt(5, votante.getEleccion().getId());
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
	
	public void update(Votante usuario)  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setInt(4, usuario.getId());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public List<Votante> selectAll() {
		List <Votante> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_VOTANTES);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String documento = rs.getString("documento");
				TipoDocumento tipodocumento = new TipoDocumento();
				tipodocumento.setId(rs.getInt("tipodocumento"));
				
				Eleccion eleccion = new Eleccion();
				eleccion.setId(rs.getInt("eleccion"));
				usuarios.add(new Votante(id, nombre, email, documento, tipodocumento, eleccion));
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuarios;
		
	}
	
	
	public Votante select(int id) {
		Votante usuario = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_VOTANTE_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String documento = rs.getString("documento");
				TipoDocumento tipodocumento = new TipoDocumento();
				tipodocumento.setId(rs.getInt("tipodocumento"));
				Eleccion eleccion = new Eleccion();
				eleccion.setId(rs.getInt("eleccion"));
				usuario = new Votante(id, nombre, email, documento, tipodocumento, eleccion);
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuario;
		
	}
}