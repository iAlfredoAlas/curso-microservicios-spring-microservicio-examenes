package com.curso.microservicios.spring.examenes.services;

import org.springframework.stereotype.Service;

import com.curso.microservicios.spring.commons.services.CommonServiceImpl;
import com.curso.microservicios.spring.examenes.models.entity.Examen;
import com.curso.microservicios.spring.examenes.models.repository.ExamenRepository;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

}
