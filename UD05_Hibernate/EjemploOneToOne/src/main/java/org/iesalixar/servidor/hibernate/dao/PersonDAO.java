package org.iesalixar.servidor.hibernate.dao;

import java.util.List;

import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;
import org.iesalixar.servidor.model.Person;

public interface PersonDAO extends GenericDAO<Person>{
	
	public List<Person> searchByFirstAndLastName(final String firstName,final String lastName);
	
	// AQUÍ PODRíA TENER OTRAS OPERACIONES QUE FUERAN SOLO TÍPICAS DE ESTE MODELO


}
