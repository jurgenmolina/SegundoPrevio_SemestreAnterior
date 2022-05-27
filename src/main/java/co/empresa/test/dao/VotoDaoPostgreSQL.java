package co.empresa.test.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.modelo.Candidato;
import co.empresa.test.modelo.Eleccion;
import co.empresa.test.modelo.Estamento;
import co.empresa.test.modelo.TipoDocumento;
import co.empresa.test.modelo.Usuario;
import co.empresa.test.modelo.Votante;
import co.empresa.test.modelo.Voto;
import co.empresa.test.util.ConexionMySQL;
import co.empresa.test.util.ConexionPostgreSQL;

public class VotoDaoPostgreSQL implements VotoDao {
	
	private ConexionPostgreSQL conexion;
	
	private static final String INSERT_VOTO_SQL = "INSERT INTO voto (fechacreacion, fechavoto,  uuid, enlace, estamento,candidato,votante) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_TIPO_BY_ID = "SELECT * FROM usuario WHERE id = ?;";
	private static final String SELECT_ALL_VOTOS = "SELECT * FROM voto;";
	
	
	
	public VotoDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}	
	
	
	public void insert(Voto voto) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_VOTO_SQL);
			preparedStatement.setString(1, voto.getFechacreacion());
			preparedStatement.setString(2, voto.getFechavoto());
			preparedStatement.setString(3, voto.getUuid());
			preparedStatement.setString(4, voto.getEnlace());
			preparedStatement.setInt(5, voto.getEstamento().getId());
			preparedStatement.setInt(6, voto.getCandidato().getId());
			preparedStatement.setInt(7, voto.getVotante().getId());
			conexion.execute();
		} catch (SQLException e) {
		}
	}
	
	public List<Voto> selectAll() {
		List <Voto> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_VOTOS);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String fechacreacion = rs.getString("fechacreacion");
				String fechavoto = rs.getString("fechavoto");
				String uuid = rs.getString("uuid");
				String enlace = rs.getString("enlace");
				Estamento estamento = new Estamento();
				estamento.setId(rs.getInt("estamento"));
				Candidato candidato = new Candidato();
				candidato.setId(rs.getInt("candidato"));
				Votante votante = new Votante();
				votante.setId(rs.getInt("votante"));
				
				usuarios.add(new Voto(id, fechacreacion, fechavoto,uuid, enlace, estamento, candidato, votante));
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuarios;
		
	}
	
	
	public Voto select(int id) {
		Voto usuario = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_TIPO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				usuario = new Voto();
			}
			
		} catch (SQLException e) {
			
		}
		
		return usuario;
		
	}
}