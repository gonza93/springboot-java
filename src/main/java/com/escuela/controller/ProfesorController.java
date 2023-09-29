package com.escuela.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuela.dto.ProfesorDTO;
import com.escuela.entity.ProfesorEntity;
import com.escuela.service.ProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("")
	private List<ProfesorDTO> getAllProfesores() {
		List<ProfesorDTO> profesoresDTO = new ArrayList<>();
		List<ProfesorEntity> profesorEntities = profesorService.getAllProfesores();
		
		for (ProfesorEntity entity : profesorEntities)
			profesoresDTO.add(entity.toDTO(true));
		
		return profesoresDTO;
	}
	
	@GetMapping("/{id}")
	private ProfesorDTO getProfesorById(@PathVariable Integer id) {
		return profesorService.getProfesor(id).toDTO(true);
	}
	
	@PostMapping("/grabar")
	private String saveProfesor(@RequestBody ProfesorDTO profesorDTO) {
		profesorService.saveProfesor(profesorDTO.toEntity());
		return "El profesor se ha grabado exitosamente";
	}
	
}
