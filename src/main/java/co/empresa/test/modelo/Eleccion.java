package co.empresa.test.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class Eleccion implements Serializable {
	
	
	private Integer id;
	
	private String nombre;
	
	private String fechainicio;
	
	private String fechafin;
	
	private String cargo;

	public Eleccion(String nombre, String fechainicio, String fechafin, String cargo) {
		super();
		this.nombre = nombre;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.cargo = cargo;
	}

	public Eleccion(Integer id) {
		super();
		this.id = id;
	}
	
	

	

	
	
	
	
}
