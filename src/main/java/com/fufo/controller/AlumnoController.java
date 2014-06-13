package com.fufo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fufo.model.Alumno;
import com.fufo.service.AlumnoDAO;

@Controller  
public class AlumnoController {
	
	@Autowired
	private AlumnoDAO dao;
	
	@ResponseBody
	@RequestMapping(value = "/alumnos", method = RequestMethod.POST) 
    public Alumno[] agregarAlumnos(@RequestBody Alumno[] alumnos) {
		for (Alumno alumno : alumnos) {
			dao.addAlumno(alumno);
		} 
        return alumnos; 
    } 
	
	
	@ResponseBody
	@RequestMapping(value = "/alumnos", method = RequestMethod.GET) 
    public List<Alumno> getAlumnos() {  
        return dao.getAlumnos(); 
    }   
}
