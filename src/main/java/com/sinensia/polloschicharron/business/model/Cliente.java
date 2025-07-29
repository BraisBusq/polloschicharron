package com.sinensia.polloschicharron.business.model;

import java.util.Objects;

public class Cliente extends Persona {

	private boolean clienteGold;
	
	public Cliente() {
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true; // mismo objeto
        if (o == null || getClass() != o.getClass()) return false; // distinto tipo
        if (!super.equals(o)) return false; // compara campos de Persona

        Cliente cliente = (Cliente) o;
        return clienteGold == cliente.clienteGold;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clienteGold);
    }
	
}
