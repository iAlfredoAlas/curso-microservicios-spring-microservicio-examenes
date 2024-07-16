package com.curso.microservicios.spring.examenes.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.microservicios.spring.commons.controllers.CommonController;
import com.curso.microservicios.spring.examenes.services.ExamenService;
import com.curso.microservicios.spring.generic.examenes.models.entity.Examen;
import com.curso.microservicios.spring.generic.examenes.models.entity.Pregunta;

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

		List<Pregunta> eliminadas = examenDb.getPreguntas().stream()
				.filter(pregDb -> !examen.getPreguntas().contains(pregDb)).collect(Collectors.toList());

		eliminadas.forEach(examenDb::removePregunta);// La pregunta se envia por argumento
		examenDb.setPreguntas(examen.getPreguntas());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByNombre(term));
	}
	
	@GetMapping("/asignaturas")
	public ResponseEntity<?> listarAsignaturas(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllAsignaturas());
	}
	
}
