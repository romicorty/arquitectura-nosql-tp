package com.fufo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fufo.model.Alumno;
import com.fufo.model.Curso;
import com.fufo.model.Materia;
import com.fufo.service.AlumnoDAO;
import com.fufo.service.MateriaDAO;

@Controller
public class CursoController {
	@Autowired
	private MateriaDAO daoMateria;
	@Autowired
	private AlumnoDAO daoAlumno;
	/**
	 * @param curso
	 * @return Crea una inscripcion para el alumno y la agrega a las inscripciones de la materia.
	 */
	@ResponseBody
	@RequestMapping(value = "/materias/{codigo_materia}/cursos/{codigo_curso}/inscripciones", method = RequestMethod.POST) 
    public Curso addInscripcionACurso(@PathVariable("codigo_materia") String codigoMateria, @PathVariable("codigo_curso") String codigoCurso, @RequestBody Integer padron) {	
		Materia materia = daoMateria.getMateriaByCodigo(codigoMateria);
		Curso curso = null;
		if(materia != null){
			curso = materia.getCursoByCodigo(codigoCurso);
			//Alumno alumno = daoAlumno.getAlumnoByPadron(inscripcionReq.getPadronAlumno());
			Alumno alumno = daoAlumno.getAlumnoByPadron(padron);
			curso.inscribirACurso(alumno);
			daoMateria.saveMateria(materia);
	
		}
		return curso;
    }
}
