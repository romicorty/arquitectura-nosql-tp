package com.fufo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fufo.model.Docente;
import com.fufo.service.DocenteDAO;

@Controller  
public class DocenteController {
	
	@Autowired
	private DocenteDAO dao;
	/*
	@ResponseBody
	@RequestMapping(value = "/docentes", method = RequestMethod.POST) 
    public Docente addDocente(@RequestBody Docente docente) {
		dao.addDocente(docente);
        return docente; 
    } */
	
	@ResponseBody
	@RequestMapping(value = "/docentes", method = RequestMethod.POST) 
    public Docente[] agregarDocentes(@RequestBody Docente[] docentes) {
		for (Docente docente : docentes) {
			dao.addDocente(docente);
		} 
        return docentes; 
    } 
	
	
	@ResponseBody
	@RequestMapping(value = "/docentes", method = RequestMethod.GET) 
    public List<Docente> getDocentes() {  
        return dao.getDocentes(); 
    }   
}
