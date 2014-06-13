package com.fufo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Docente {
	@JsonProperty("nombre_apellido")
	private String nombreYApellido;
	private Integer dni;
	
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	

}
