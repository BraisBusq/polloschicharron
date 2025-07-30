package com.sinensia.polloschicharron.business.model;

public class Direccion {

	private String calle;
	private String poblacion;
	private String codigoPostal;
	private String provincia;
	private String pais;
	
	public Direccion() {
		// Constructor vacío requerido por JPA
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Direccion [direccion=" + calle + ", poblacion=" + poblacion + ", codigoPostal=" + codigoPostal
				+ ", provincia=" + provincia + ", pais=" + pais + "]";
	}
	
}
