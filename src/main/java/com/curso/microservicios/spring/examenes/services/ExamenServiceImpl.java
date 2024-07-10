package com.curso.microservicios.spring.examenes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.microservicios.spring.commons.services.CommonServiceImpl;
import com.curso.microservicios.spring.examenes.models.entity.Examen;
import com.curso.microservicios.spring.examenes.models.repository.ExamenRepository;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		return repository.findByNombre(term);
	}

}
