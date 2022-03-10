package com.example.demo.dto;

import java.util.ArrayList;

public class ConciertoDTO {
	
	private ArrayList<String> grupos;
	private int numEntradas;
	private String tipo;
	
	public ConciertoDTO() {
		grupos = new ArrayList<>();
	}

	public ArrayList<String> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<String> grupos) {
		this.grupos = grupos;
	}

	public int getNumEntradas() {
		return numEntradas;
	}

	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
