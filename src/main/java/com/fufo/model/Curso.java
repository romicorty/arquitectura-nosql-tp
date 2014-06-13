package com.fufo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Curso {
	@Id
	private String codigo;
	private String cuatrimestre;
	private Integer cupo;
	private List<Inscripcion> inscripciones;
	private List<Docente> docentes;
	
	public Curso(List<Docente> docentes, String codigo, String cuatrimestre, Integer cupo){
		this.inscripciones = new ArrayList<>();
		this.docentes = docentes;
		this.codigo = codigo;
		this.cuatrimestre = cuatrimestre;
		this.cupo = cupo;
	}
	
	public List<Docente> getDocentes() {
		return docentes;
	}
	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}
	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}
	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCuatrimestre() {
		return cuatrimestre;
	}
	public void setCuatrimestre(String cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}
	public Integer getCupo() {
		return cupo;
	}
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}
	
	@JsonIgnore
	public Integer getVacantes(){
		return this.cupo - this.inscripciones.size();
	}
	
	/**
	 * Inscribe a un alumno al curso actual.
	 */
	public Inscripcion inscribirACurso(Alumno alumno){
		Inscripcion nuevaInscripcion = new Inscripcion(alumno);
		this.inscripciones.add(nuevaInscripcion);
		return nuevaInscripcion;
	}

}
