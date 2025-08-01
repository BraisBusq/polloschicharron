package com.sinensia.polloschicharron.business.services;

import java.util.List;
import java.util.Optional;

import com.sinensia.polloschicharron.business.model.Establecimiento;
import com.sinensia.polloschicharron.business.model.dtos.EstablecimientoDTO1;

public interface EstablecimientoServices {

	/**
	 * Si el NIF es null o ya existe lanza IllegalStateException
	 * 
	 * 
	 */
	void create(Establecimiento establecimiento);
	
	Optional<Establecimiento> read(String nif);
	
	/**
	 * Si el NIF es null o no existe lanza IllegalStateException
	 * 
	 */
	void update(Establecimiento establecimiento);
	
	List<Establecimiento> getAll();
	
	List<Establecimiento> getByProvincia(String provincia);
	
	// ***********************************
	//
	// DTOs
	//
	// ***********************************
	
	List<EstablecimientoDTO1> getEstablecimientosDTO1();
	
}
