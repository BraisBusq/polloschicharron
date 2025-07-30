package com.sinensia.polloschicharron.integration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="EMPLEADOS")
public class EmpleadoPL extends PersonaPL {
	
	private String licenciaManipuladorAlimentos;

	public EmpleadoPL() {
		// Constructor vacío requerido por JPA
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
		if (!(o instanceof EmpleadoPL)) return false; // tipo diferente
		if (!super.equals(o)) return false; // compara atributos de PersonaPL

		EmpleadoPL that = (EmpleadoPL) o;
		return Objects.equals(licenciaManipuladorAlimentos, that.licenciaManipuladorAlimentos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), licenciaManipuladorAlimentos);
	}
	
	
}
