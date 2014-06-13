package com.fufo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fufo.model.Docente;

@Repository
public class DocenteDAO {
	   
    @Autowired
    private MongoTemplate mongoTemplate;
     
    public void addDocente(Docente docente) {
        if (!mongoTemplate.collectionExists(Docente.class)) {
            mongoTemplate.createCollection(Docente.class);
        }      
        mongoTemplate.insert(docente);
    }
    
    public List<Docente> getDocentes() {
        return mongoTemplate.findAll(Docente.class);
    }
    
    public Docente getDocenteByDni(Integer dni) {
    	return mongoTemplate.findOne(new Query(Criteria.where("dni").is(dni)), Docente.class);
    }

}
