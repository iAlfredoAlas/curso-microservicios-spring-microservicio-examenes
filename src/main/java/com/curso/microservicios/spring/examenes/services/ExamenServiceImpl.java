package com.curso.microservicios.spring.examenes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.microservicios.spring.commons.services.CommonServiceImpl;
import com.curso.microservicios.spring.examenes.models.repository.AsignaturaRepository;
import com.curso.microservicios.spring.examenes.models.repository.ExamenRepository;
import com.curso.microservicios.spring.generic.examenes.models.entity.Asignatura;
import com.curso.microservicios.spring.generic.examenes.models.entity.Examen;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Asignatura> findAllAsignaturas() {
		return (List<Asignatura>) asignaturaRepository.findAll();
	}

}
