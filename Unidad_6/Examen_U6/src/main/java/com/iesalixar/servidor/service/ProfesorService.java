package com.iesalixar.servidor.service;

import java.util.List;
import java.util.Optional;

import com.iesalixar.servidor.model.Profesor;

public interface ProfesorService {
	public Optional<Profesor> findProfesorById(Long id);
	public List<Profesor> getAllProfesores();
	public Profesor insertarProfesor(Profesor profesor);
	public Profesor getProfesorByName(Profesor profesor);
}
