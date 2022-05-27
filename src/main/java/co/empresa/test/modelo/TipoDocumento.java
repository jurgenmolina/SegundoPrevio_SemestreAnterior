package co.empresa.test.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class TipoDocumento implements Serializable {
	
	
	private Integer id;
	
	private String descripcion;

	public TipoDocumento(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	public TipoDocumento(Integer id) {
		this.id = id;
	}

	
	
	
	

	
	
	
	
}
