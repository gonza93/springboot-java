package com.escuela.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuela.entity.ProfesorEntity;
import com.escuela.repository.ProfesorRepository;

@Service
public class ProfesorService {

	@Autowired
	private ProfesorRepository profesorRepository;
	
	public void saveProfesor(ProfesorEntity profesorEntity) {
		profesorRepository.save(profesorEntity);
	}
	
	public ProfesorEntity getProfesor(Integer id) {
		Optional<ProfesorEntity> profesorSearch = profesorRepository.findById(id);
		return profesorSearch.get();
	}
	
	public List<ProfesorEntity> getAllProfesores() {
		return profesorRepository.findAll();
	}
	
	public void deleteProfesor(ProfesorEntity profesorEntity) {
		profesorRepository.delete(profesorEntity);
	}
}
