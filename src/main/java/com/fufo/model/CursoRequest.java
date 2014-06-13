package com.fufo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CursoRequest {
	private String codigo;
	private String cuatrimestre;
	private Integer cupo;
	@JsonProperty("dni_docentes")
	private List<Integer> dniDocentes;
	
	public CursoRequest(){
		this.dniDocentes = new ArrayList<>();
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
	public List<Integer> getDniDocentes() {
		return dniDocentes;
	}
	public void setDniDocentes(List<Integer> dniDocentes) {
		this.dniDocentes = dniDocentes;
	}

}
