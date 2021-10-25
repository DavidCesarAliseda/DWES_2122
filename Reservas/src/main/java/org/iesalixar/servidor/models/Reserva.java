package org.iesalixar.servidor.models;

public class Reserva {
	 public int numPersonas;
	 public String fechaInicio;
	 public String fechaFinal;
	 public String[] servicios;
	 
	public Reserva() {
		super();
	
	}
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String[] getServicios() {
		return servicios;
	}
	public void setServicios(String[] servicios) {
		this.servicios = servicios;
	}
}
