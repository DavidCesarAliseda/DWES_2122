package com.example.demo.dto;

import java.io.Serializable;

public class RegistroDTO implements Serializable{
	private String usuario;
	private String contraseña;
	private String confirmacionContraseña;
	private String tipo;
	
	public RegistroDTO() {
		super();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getConfirmacionContraseña() {
		return confirmacionContraseña;
	}

	public void setConfirmacionContraseña(String confirmacionContraseña) {
		this.confirmacionContraseña = confirmacionContraseña;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
