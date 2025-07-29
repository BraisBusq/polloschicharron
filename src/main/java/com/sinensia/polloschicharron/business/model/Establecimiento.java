package com.sinensia.polloschicharron.business.model;

import java.util.Objects;

public class Establecimiento {
	
	private String nif; // business key
	private String nombre;
	private Direccion direccion;
	private DatosContacto datosContacto;
	
	public Establecimiento() {
		throw new UnsupportedOperationException("notImplemented() cannot be performed because ...");
	}

	public String getNIF() {
		return nif;
	}

	public void setNIF(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public DatosContacto getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(DatosContacto datosContacto) {
		this.datosContacto = datosContacto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Establecimiento other = (Establecimiento) obj;
		return Objects.equals(nif, other.nif);
	}

	@Override
	public String toString() {
		return "Establecimiento [NIF=" + nif + ", nombre=" + nombre + ", direccion=" + direccion + ", datosContacto="
				+ datosContacto + "]";
	}

}
