package com.escuela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuela.entity.CursoEntity;
import com.escuela.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public String saveCurso(CursoEntity cursoEntity) {
		try {
			cursoRepository.save(cursoEntity);
			return "OK";
		}
		catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public List<CursoEntity> getAllCursos() {
		return cursoRepository.findAll();
	}
	
	public void deleteCurso(CursoEntity cursoEntity) {
		cursoRepository.delete(cursoEntity);
	}
}
