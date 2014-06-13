package com.fufo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fufo.model.Materia;

@Repository
public class MateriaDAO {
    @Autowired
    private MongoTemplate mongoTemplate;
     
    public void addMateria(Materia materia) {
        if (!mongoTemplate.collectionExists(Materia.class)) {
            mongoTemplate.createCollection(Materia.class);
        }      
        mongoTemplate.insert(materia);
    }
    
    public void saveMateria(Materia materia){
    	mongoTemplate.save(materia);
    }
    
    public List<Materia> getMaterias() {
        return mongoTemplate.findAll(Materia.class);
    }

	public Materia getMateriaByCodigo(String codigo) {
		return mongoTemplate.findOne(new Query(Criteria.where("codigo").is(codigo)), Materia.class);
	}

	public List<Materia> getMateriasByDepartamento(String departamento) {
		return mongoTemplate.find(new Query(Criteria.where("departamento").is(departamento)), Materia.class);
	}
}
