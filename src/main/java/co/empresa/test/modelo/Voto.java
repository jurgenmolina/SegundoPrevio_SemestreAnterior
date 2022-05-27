package co.empresa.test.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class Voto implements Serializable {
	
	
	private Integer id;
	
	private String fechacreacion;
	
	private String fechavoto;
	
	private String uuid;
	
	private String enlace;
	
	private Estamento estamento;
	
	private Candidato candidato;
	
	private Votante votante;

	public Voto(String fechacreacion, String fechavoto, String uuid, String enlace, Estamento estamento,
			Candidato candidato, Votante votante) {
		super();
		this.fechacreacion = fechacreacion;
		this.fechavoto = fechavoto;
		this.uuid = uuid;
		this.enlace = enlace;
		this.estamento = estamento;
		this.candidato = candidato;
		this.votante = votante;
	}

	public Voto(Estamento estamento, Candidato candidato, Votante votante) {
		super();
		this.estamento = estamento;
		this.candidato = candidato;
		this.votante = votante;
	}
	

	
	

	

	
	
	
	
}
