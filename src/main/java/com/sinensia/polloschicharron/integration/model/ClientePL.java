package com.sinensia.polloschicharron.integration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class ClientePL extends PersonaPL {

	@Column(name="GOLD")
	private boolean clienteGold;
		
	public ClientePL() {
		throw new UnsupportedOperationException("notImplemented() cannot be performed because ...");
	}

	public boolean isClienteGold() {
		return clienteGold;
	}

	public void setClienteGold(boolean clienteGold) {
		this.clienteGold = clienteGold;
	}

	@Override
	public String toString() {
		return "Cliente [clienteGold=" + clienteGold + ", toString()=" + super.toString() + "]";
	}
	
}
