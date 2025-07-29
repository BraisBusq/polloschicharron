package com.sinensia.polloschicharron.business.model;

import java.util.Objects;

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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true; // misma referencia
        if (o == null || getClass() != o.getClass()) return false; // distinto tipo
        if (!super.equals(o)) return false; // compara campos de Persona

        Empleado empleado = (Empleado) o;
        return Objects.equals(licenciaManipuladorAlimentos, empleado.licenciaManipuladorAlimentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), licenciaManipuladorAlimentos);
    }
		
}
