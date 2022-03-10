package com.iesalixar.servidor.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesalixar.servidor.model.Profesor;
import com.iesalixar.servidor.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	ProfesorRepository profRepo;
	
	@Override
	public Optional<Profesor> findProfesorById(Long id) {
		return profRepo.findById(id);
	}

	@Override
	public List<Profesor> getAllProfesores() {
		List<Profesor> profesoresBD = profRepo.findAll();

		if (profesoresBD != null && profesoresBD.size() > 0) {

			return profesoresBD;
		}

		return new ArrayList<Profesor>();
	}

	@Override
	public Profesor insertarProfesor(Profesor profesor) {
		if(profesor != null ) {
			Profesor profe = profRepo.save(profesor);
			return profe;
		}
		return null;
	}

	@Override
	public Profesor getProfesorByName(Profesor profesor) {
		if(profesor.getNombre() != null && profesor.getApellido1() != null&& profesor.getApellido2() != null) {
			Profesor profe = profRepo.findByApellido1(profesor.getApellido1());
			return profe;
		}
		return null;
	}

}
