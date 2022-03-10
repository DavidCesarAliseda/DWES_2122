package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class AlumnoDTO {

	private String nombre;
	private String apellidos;
	private String DNI;
	private ArrayList<String> curso;
	private ArrayList<String> materias;
	
	public AlumnoDTO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public ArrayList<String> getCurso() {
		return curso;
	}

	public void setCurso(ArrayList<String> curso) {
		this.curso = curso;
	}

	public ArrayList<String> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<String> materias) {
		this.materias = materias;
	}
	
}
