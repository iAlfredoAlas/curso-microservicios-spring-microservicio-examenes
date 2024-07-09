package com.curso.microservicios.spring.examenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.microservicios.spring.examenes.models.entity.Examen;

public interface ExamenRepository extends CrudRepository<Examen, Long> {

}
