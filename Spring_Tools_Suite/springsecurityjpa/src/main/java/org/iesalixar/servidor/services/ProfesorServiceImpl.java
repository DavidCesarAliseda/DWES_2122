package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	ProfesorRepository profRepo;

	@Override
	public List<Profesor> getAllTeachers() {

		List<Profesor> profesores = profRepo.findAll();

		if (profesores != null && profesores.size() > 0) {
			return profesores;
		}

		return new ArrayList<Profesor>();
	}

	@Override
	public Optional<Profesor> findProfesorById(Long id) {
		Optional<Profesor> profesor = null;

		if (id > 0 && id != null) {
			profesor = profRepo.findById(id);
		}

		return profesor;
	}

}
