package com.iesalixar.servidor.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesalixar.servidor.model.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura,Long> {

	
}
