package com.curso.microservicios.spring.examenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curso.microservicios.spring.generic.examenes.models.entity.Examen;

public interface ExamenRepository extends CrudRepository<Examen, Long> {

	@Query("select exam from Examen exam where exam.nombre like %?1%")
	public List<Examen> findByNombre(String term);
	
}
