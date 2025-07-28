package com.sinensia.polloschicharron.business.model;

public class Empleado extends Persona {
	
	private String licenciaManipuladorAlimentos;

	public Empleado() {
		throw new UnsupportedOperationException("notImplemented() cannot be performed because ...");
	}

	public String getLicenciaManipuladorAlimentos() {
		return licenciaManipuladorAlimentos;
	}

	public void setLicenciaManipuladorAlimentos(String licenciaManipuladorAlimentos) {
		this.licenciaManipuladorAlimentos = licenciaManipuladorAlimentos;
	}
		
}
