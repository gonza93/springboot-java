package com.escuela.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuela.dto.AlumnoDTO;
import com.escuela.entity.AlumnoEntity;
import com.escuela.service.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("")
	public List<AlumnoDTO> getAllAlumnos(){
		List<AlumnoDTO> alumnos = new ArrayList<>();
		List<AlumnoEntity> alumnoEntities = alumnoService.getAllAlumnos();
		
		for(AlumnoEntity entity : alumnoEntities)
			alumnos.add(entity.toDTO());
		
		return alumnos;
	}
	
	@PostMapping("/grabar")
	public String saveAlumno(@RequestBody AlumnoDTO alumno) {
		alumnoService.saveAlumno(alumno.toEntity());
		return "El alumno ha sido grabado exitosamente.";
	}
	
}
