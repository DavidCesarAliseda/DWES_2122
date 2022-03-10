package com.iesalixar.servidor.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesalixar.servidor.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Long>{
	
	public Departamento findByNombre(String nombre);	
}
