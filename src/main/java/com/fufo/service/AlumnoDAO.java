package com.fufo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fufo.model.Alumno;

@Repository
public class AlumnoDAO {
	   
    @Autowired
    private MongoTemplate mongoTemplate;
     
    public void addAlumno(Alumno alumno) {
        if (!mongoTemplate.collectionExists(Alumno.class)) {
            mongoTemplate.createCollection(Alumno.class);
        }      
        mongoTemplate.insert(alumno);
    }
    
    public List<Alumno> getAlumnos() {
        return mongoTemplate.findAll(Alumno.class);
    }
    
    public Alumno getAlumnoByPadron(Integer padron){
		return mongoTemplate.findOne(new Query(Criteria.where("padron").is(padron)), Alumno.class);
    }

}
