package com.iesalixar.servidor.service;

import java.util.List;
import java.util.Optional;

import com.iesalixar.servidor.model.Asignatura;




public interface AsignaturaService {
	
	public List<Asignatura> getAllAsignaturas();
	public Optional<Asignatura> findAsignaturaById(Long id);

}
