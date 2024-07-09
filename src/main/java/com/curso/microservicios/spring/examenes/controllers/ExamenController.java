package com.curso.microservicios.spring.examenes.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.microservicios.spring.commons.controllers.CommonController;
import com.curso.microservicios.spring.examenes.models.entity.Examen;
import com.curso.microservicios.spring.examenes.services.ExamenService;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
		Optional<Examen> optExamen = service.findbyId(id);

		if (!optExamen.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		Examen examenDb = optExamen.get();
		examenDb.setNombre(examen.getNombre());

		examenDb.getPreguntas().stream().filter(pregDb -> !examen.getPreguntas().contains(pregDb))
				.forEach(examenDb::removePregunta);// La pregunta se envia por argumento

		examenDb.setPreguntas(examen.getPreguntas());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
	}
}
