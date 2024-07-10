package com.curso.microservicios.spring.examenes.services;

import java.util.List;

import com.curso.microservicios.spring.commons.services.CommonService;
import com.curso.microservicios.spring.examenes.models.entity.Examen;

public interface ExamenService extends CommonService<Examen> {
	
	public List<Examen> findByNombre(String term);

}
