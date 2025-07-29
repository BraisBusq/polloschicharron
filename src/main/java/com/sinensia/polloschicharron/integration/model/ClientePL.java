package com.sinensia.polloschicharron.integration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true; // misma referencia
        if (o == null || getClass() != o.getClass()) return false; // distinto tipo
        if (!super.equals(o)) return false; // compara campos de PersonaPL

        ClientePL clientePL = (ClientePL) o;
        return clienteGold == clientePL.clienteGold;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clienteGold);
    }
	
}
