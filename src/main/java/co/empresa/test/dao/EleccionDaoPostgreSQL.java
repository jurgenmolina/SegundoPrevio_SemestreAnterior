package co.empresa.test.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import co.empresa.test.modelo.Eleccion;
import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;
import co.empresa.test.util.ConexionMySQL;
import co.empresa.test.util.ConexionPostgreSQL;

public class EleccionDaoPostgreSQL implements EleccionDao {
	
	private ConexionPostgreSQL conexion;
	
	private static final String SELECT_ELECCION_BY_ID = "SELECT * FROM eleccion WHERE id = ?;";
	private static final String SELECT_ALL_ELECCIONES = "SELECT * FROM eleccion;";
	
	
	
	public EleccionDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}	
	
	public List<Eleccion> selectAll() {
		List <Eleccion> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_ELECCIONES);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String fechainicio = rs.getString("fechainicio");
				String fechafin = rs.getString("fechafin");
				
				String cargo = rs.getString("cargo");
				usuarios.add(new Eleccion(id, nombre, fechainicio, fechafin, cargo));
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuarios;
		
	}
	
	
	public Eleccion select(int id) {
		Eleccion usuario = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ELECCION_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String fechainicio = rs.getString("fechainicio");
				String fechafin = rs.getString("fechafin");
				String cargo = rs.getString("cargo");
				usuario = new Eleccion(id, nombre, fechainicio, fechafin, cargo);
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuario;
		
	}
}