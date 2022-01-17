package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="persons")
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	
	@Column(name = "birth", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	//OPCION BIDIRECCIONAL
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, 
			fetch = FetchType.LAZY)
	private HistorialMedico historial;
	
	public Person() {
		
	}
	
	public Person(Long id, String firstName, String lastName, Date dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	//No tiene sentido tener el Get ya que se auto genera
	public Long getId() {
		return id;
	}
	
	//Métodos HELPER para trabajar con las asociaciones
	public HistorialMedico getHistorialMedico() {
		return this.historial;
	}
	
	//Versión bidireccional
	public  void setPassport(HistorialMedico historial) {
		historial.setPerson(this);
		this.historial = historial;
	}
	
	public void removeHistorialMedico() {
		
		if (this.historial!=null) {
			this.historial.setPerson(null);
			this.historial = null;
		}
		
	}

}
