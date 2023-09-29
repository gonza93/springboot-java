package com.escuela.model;

import com.escuela.entity.AlumnoEntity;

public class Alumno {
	
	private int id;
	private String nombre;
	private char sexo;
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
	
	public AlumnoEntity toEntity() {
		AlumnoEntity entity = new AlumnoEntity();
		entity.setId(this.id);
		entity.setNombre(this.nombre);
		entity.setSexo(this.sexo);
		entity.setEdad(this.edad);
		
		return entity; 
	}
}
