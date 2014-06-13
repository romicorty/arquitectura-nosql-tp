package com.fufo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Materia {
	@Id
	private String codigo;
	private String nombre;
	private String departamento;
	private List<Curso> cursos;
	
	public Materia(){
		this.cursos = new ArrayList<Curso>();
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void agregarCurso(Curso curso){
		this.cursos.add(curso);
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public Curso getCursoByCodigo(String codigo){
		for (Curso curso : this.cursos) {
			if(curso.getCodigo().equalsIgnoreCase(codigo)){
				return curso;
			}
		}
		
		return null;
	}
	

}
