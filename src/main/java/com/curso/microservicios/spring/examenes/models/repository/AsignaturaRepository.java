package com.curso.microservicios.spring.examenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.microservicios.spring.generic.examenes.models.entity.Asignatura;

public interface AsignaturaRepository extends CrudRepository<Asignatura, Long> {

}
