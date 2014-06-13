package com.fufo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Inscripcion {
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date fecha = new Date();
	private Alumno alumno;
	
	public Inscripcion(Alumno alumno){
		this.alumno = alumno;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}
