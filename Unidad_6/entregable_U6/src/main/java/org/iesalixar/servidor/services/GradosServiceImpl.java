package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.models.Grado;
import org.iesalixar.servidor.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradosServiceImpl implements GradoService {

	@Autowired
	GradoRepository gradoRepo;

	@Override
	public List<Grado> getAllGrados() {

		List<Grado> gradosBD = gradoRepo.findAll();

		if (gradosBD != null && gradosBD.size() > 0) {

			return gradosBD;
		}

		return new ArrayList<Grado>();
	}

	@Override
	public Optional<Grado> findGradoById(Long id) {
		Optional<Grado> grado = null;

		if (id != null) {
			grado = gradoRepo.findById(id);
		}

		return grado;
	}

	@Override
	public Grado insertarGrado(Grado grado) {
		if (grado != null && getGradoByName(grado.getNombre()) == null) {
			Grado grad = gradoRepo.save(grado);
			return grad;
		}

		return null;
	}

	@Override
	public Grado getGradoByName(String nombre) {
		if (nombre != null) {
			Grado grado = gradoRepo.findByNombre(nombre);
			return grado;
		}

		return null;
	}

	@Override
	public Grado actualizarGrado(Grado grado) {
		if (grado==null || grado.getId() ==null || grado.getNombre()==null) {
			return null;
		}
		
		return gradoRepo.save(grado); 
	}

	

}
