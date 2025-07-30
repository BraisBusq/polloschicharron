package com.sinensia.polloschicharron.integration.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ESTABLECIMIENTOS")
public class EstablecimientoPL {
	
	@Id
	private String nif; // business key
	
	@Column(name="NOMBRE_COMERCIAL")
	private String nombre;
	
	@Embedded
	private DireccionPL direccion;
	
	@Embedded
	private DatosContactoPL datosContacto;
	
	public EstablecimientoPL() {
		// Constructor vacío requerido por JPA
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

	public DireccionPL getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionPL direccion) {
		this.direccion = direccion;
	}

	public DatosContactoPL getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(DatosContactoPL datosContacto) {
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
		EstablecimientoPL other = (EstablecimientoPL) obj;
		return Objects.equals(nif, other.nif);
	}

	@Override
	public String toString() {
		return "Establecimiento [NIF=" + nif + ", nombre=" + nombre + ", direccion=" + direccion + ", datosContacto="
				+ datosContacto + "]";
	}

}
