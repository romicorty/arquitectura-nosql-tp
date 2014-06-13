package com.fufo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fufo.model.Curso;
import com.fufo.model.CursoRequest;
import com.fufo.model.Docente;
import com.fufo.model.Materia;
import com.fufo.service.DocenteDAO;
import com.fufo.service.MateriaDAO;

@Controller
public class MateriaController {
	@Autowired
	private MateriaDAO dao;
	@Autowired
	private DocenteDAO daoDocente;
	
	/**
	 * @param materias
	 * @return Agrega las materias al sistema
	 */
	@ResponseBody
	@RequestMapping(value = "/materias", method = RequestMethod.POST) 
    public Materia[] agregarMaterias(@RequestBody Materia[] materias) {
		for (Materia materia : materias) {
			dao.addMateria(materia);
		} 
        return materias; 
    } 
	
	/**
	 * @param curso
	 * @return Crea un curso con sus docentes y lo agrega a la materia indicada.
	 */
	@ResponseBody
	@RequestMapping(value = "/materias/{codigo}/cursos", method = RequestMethod.POST) 
    public CursoRequest addCursoAMateria(@PathVariable("codigo") String codigo, @RequestBody CursoRequest cursoReq) {
		Curso nuevoCurso = this.crearCurso(cursoReq);
		
		Materia materia = getMateriaByCodigo(codigo);
		materia.agregarCurso(nuevoCurso);
		dao.saveMateria(materia);
		return cursoReq;
    } 

	/**
	 * @return Devuelve todas las materias del sistema
	 */
	@ResponseBody
	@RequestMapping(value = "/materias", method = RequestMethod.GET) 
    public List<Materia> getMaterias(@RequestParam(value = "departamento", required = false) String departamento) {
		if(departamento != null)
			return dao.getMateriasByDepartamento(departamento); 
		else
			return dao.getMaterias(); 
    }   
	
	/**
	 * @param codigo
	 * @return Devuelve una materia por codigo
	 */
	@ResponseBody
	@RequestMapping(value = "/materias/{codigo}", method = RequestMethod.GET) 
    public Materia getMateriaByCodigo(@PathVariable("codigo") String codigo) {  
        return dao.getMateriaByCodigo(codigo); 
    }
	
	private Curso crearCurso(CursoRequest cursoReq){
		List<Docente> docentes = new ArrayList<>();
		for (Integer dni : cursoReq.getDniDocentes()) {
			Docente docente = daoDocente.getDocenteByDni(dni);
			docentes.add(docente);
		}
		Curso nuevoCurso = new Curso(docentes,cursoReq.getCodigo(),cursoReq.getCuatrimestre(),cursoReq.getCupo());
		return nuevoCurso;
	}

	
	
}
