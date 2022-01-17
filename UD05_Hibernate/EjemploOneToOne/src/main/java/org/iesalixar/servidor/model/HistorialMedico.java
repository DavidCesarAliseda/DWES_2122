package org.iesalixar.servidor.model;

import java.sql.Date;

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
@Table(name="historialmedico")
public class HistorialMedico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nummHistorial")
	private int numHistorial;
	
	@Column(name = "fechaApertura")
	@Temporal(TemporalType.DATE)
	private Date fechaApertura;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
	private Person person;

	public HistorialMedico() {
		super();
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumHistorial() {
		return numHistorial;
	}

	public void setNumHistorial(int numHistorial) {
		this.numHistorial = numHistorial;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	
	
}
