package co.empresa.test.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class Votante implements Serializable {
	
	
	private Integer id;
	
	private String nombre;
	
	private String email;
	
	private String documento;
	
	private TipoDocumento tipoDocumento;

	private Eleccion eleccion;

	

	public Votante(Integer id) {
		super();
		this.id = id;
	}



	public Votante(String nombre, String email, String documento, TipoDocumento tipoDocumento, Eleccion eleccion) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.eleccion = eleccion;
	}
	
	

	
	
	

	
	
	
	
}
