package com.escuela.entity;

import com.escuela.dto.CursoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class CursoEntity {
	
	@Id
	@Column(name = "id_curso")
	private Integer id;
	
	@Column
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
	private ProfesorEntity profesorEntity;

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

	public ProfesorEntity getProfesor() {
		return profesorEntity;
	}

	public void setProfesor(ProfesorEntity profesor) {
		this.profesorEntity = profesor;
	}
	
	public CursoDTO toDTO(boolean showDependencies) {
		CursoDTO cursoDTO = new CursoDTO();
		cursoDTO.setId(this.id);
		cursoDTO.setNombre(this.nombre);

		if (showDependencies)
			if (this.profesorEntity != null)
				cursoDTO.setProfesor(this.profesorEntity.toDTO(false));
		
		return cursoDTO;
	}
	
}
