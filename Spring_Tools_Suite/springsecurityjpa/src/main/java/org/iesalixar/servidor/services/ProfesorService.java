package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Profesor;

public interface ProfesorService {

	public List<Profesor> getAllTeachers();
	public Optional<Profesor> findProfesorById(Long id); 
	
	
}
