package com.escuela.entity;

import java.util.ArrayList;
import java.util.List;

import com.escuela.dto.CursoDTO;
import com.escuela.dto.ProfesorDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class ProfesorEntity {
	
	@Id
	@Column(name = "id_profesor")
	private Integer id;
	
	@Column
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
	private List<CursoEntity> cursosEntities;

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

	public List<CursoEntity> getCursosEntities() {
		return cursosEntities;
	}

	public void setCursosEntities(List<CursoEntity> cursosEntities) {
		this.cursosEntities = cursosEntities;
	}
	
	public ProfesorDTO toDTO(boolean showDependencies) {
		ProfesorDTO profesorDTO = new ProfesorDTO();
		
		profesorDTO.setId(this.id);
		profesorDTO.setNombre(this.nombre);
		
		List<CursoDTO> cursoDTO = new ArrayList<>();
		
		if (showDependencies)
			for (CursoEntity cursoEntity : this.cursosEntities)
				cursoDTO.add(cursoEntity.toDTO(false));
			
		profesorDTO.setCursos(cursoDTO);
		
		return profesorDTO;
	}
	
}
