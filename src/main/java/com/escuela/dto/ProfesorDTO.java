package com.escuela.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.escuela.entity.CursoEntity;
import com.escuela.entity.ProfesorEntity;

public class ProfesorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private List<CursoDTO> cursos;
	
	public ProfesorDTO() {
		this.cursos = new ArrayList<>();
	}
	
	public ProfesorDTO(Integer id) {
		this.id = id;
		this.cursos = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<CursoDTO> getCursos() {
		return cursos;
	}
	public void setCursos(List<CursoDTO> cursos) {
		this.cursos = cursos;
	}
	
	public ProfesorEntity toEntity() {
		ProfesorEntity entity = new ProfesorEntity();
		entity.setId(this.id);
		entity.setNombre(this.nombre);
		
		List<CursoEntity> cursoEntities = new ArrayList<>();
		for (CursoDTO cursoDTO : this.cursos)
			cursoEntities.add(cursoDTO.toEntity());
			
		entity.setCursosEntities(null);
		
		return entity;
	}
	
}
