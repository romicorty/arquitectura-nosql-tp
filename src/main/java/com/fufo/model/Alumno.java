package com.fufo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="alumnos")
public class Alumno {
	@JsonProperty("nombre_apellido")
	private String nombreYApellido;
	@Id
	private Integer padron;
	
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}
	public Integer getPadron() {
		return padron;
	}
	public void setPadron(Integer padron) {
		this.padron = padron;
	}
}
