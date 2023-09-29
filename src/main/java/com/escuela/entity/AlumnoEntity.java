package com.escuela.entity;



import com.escuela.dto.AlumnoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class AlumnoEntity {
	
	@Id
	@Column(name = "id_alumno")
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private char sexo;
	
	@Column
	private int edad;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public AlumnoDTO toDTO() {
		AlumnoDTO alumno = new AlumnoDTO();
		alumno.setId(this.id);
		alumno.setNombre(this.nombre);
		alumno.setEdad(this.edad);
		alumno.setSexo(this.sexo);
		
		return alumno;
	}
	
}
