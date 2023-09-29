package com.escuela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuela.entity.AlumnoEntity;
import com.escuela.repository.AlumnoRepository;

@Service
public class AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	public void saveAlumno(AlumnoEntity alumno) {
		alumnoRepository.save(alumno);
	}
	
	public List<AlumnoEntity> getAllAlumnos() {
		return alumnoRepository.findAll();
	}
	
	public void deleteAlumno(Integer id) {
		alumnoRepository.deleteById(id);
	}
}
