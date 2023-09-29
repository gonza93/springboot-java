package com.escuela.dto;

import java.io.Serializable;

import com.escuela.entity.CursoEntity;

public class CursoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private ProfesorDTO profesor;

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

	public ProfesorDTO getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesorDTO profesor) {
		this.profesor = profesor;
	}
	
	public CursoEntity toEntity() {
		CursoEntity entity = new CursoEntity();
		entity.setId(this.id);
		entity.setNombre(this.nombre);
		
		if (this.profesor != null)
			entity.setProfesor(this.profesor.toEntity());
		
		return entity;
	}
	
}
