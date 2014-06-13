package com.fufo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InscripcionRequest {
	@JsonProperty("padron")
	private Integer padronAlumno;

	public Integer getPadronAlumno() {
		return padronAlumno;
	}

	public void setPadronAlumno(Integer padronAlumno) {
		this.padronAlumno = padronAlumno;
	}
}
