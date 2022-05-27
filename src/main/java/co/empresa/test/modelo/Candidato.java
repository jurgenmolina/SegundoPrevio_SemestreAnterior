package co.empresa.test.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class Candidato implements Serializable {
	
	
	private Integer id;
	
	private String documento;
	
	private String nombre;
	
	private String apellido;
	
	private Eleccion eleccion;
	
	private int numero;

	public Candidato(String documento, String nombre, String apellido, Eleccion eleccion, int numero) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eleccion = eleccion;
		this.numero = numero;
	}

	public Candidato(Eleccion eleccion) {
		super();
		this.eleccion = eleccion;
	}

	public Candidato(Integer id) {
		super();
		this.id = id;
	}
	
	

	

	
	
	
	
}
