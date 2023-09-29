package com.escuela.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuela.dto.CursoDTO;
import com.escuela.entity.CursoEntity;
import com.escuela.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("")
	private List<CursoDTO> getAllCursos() {
		List<CursoDTO> cursos = new ArrayList<>();
		List<CursoEntity> entities = cursoService.getAllCursos();
		
		for (CursoEntity entity : entities)
			cursos.add(entity.toDTO(true));
		
		return cursos;
	}
	
	@PostMapping("/grabar")
	private ResponseEntity<String> saveCurso(@RequestBody CursoDTO cursoDTO) {
		String result = cursoService.saveCurso(cursoDTO.toEntity());
		if (result == "OK") 
			return ResponseEntity.ok("Curso grabado exitosamente");
	    else
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	    
	}
	
	@DeleteMapping("/eliminar")
	private String deleteCurso(@RequestBody CursoDTO cursoDTO) {
		cursoService.deleteCurso(cursoDTO.toEntity());
		return "Curso eliminado exitosamente.";
	}
}
