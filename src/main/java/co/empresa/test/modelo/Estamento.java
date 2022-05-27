package co.empresa.test.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class Estamento implements Serializable {
	
	
	private Integer id;
	
	private Eleccion eleccion;
	
	private String descripcion;

	public Estamento(Eleccion eleccion, String descripcion) {
		super();
		this.eleccion = eleccion;
		this.descripcion = descripcion;
	}
	
	

	public Estamento(Eleccion eleccion) {
		super();
		this.eleccion = eleccion;
	}



	public Estamento(Integer id) {
		super();
		this.id = id;
	}
	

	

	
	
	
	
}
