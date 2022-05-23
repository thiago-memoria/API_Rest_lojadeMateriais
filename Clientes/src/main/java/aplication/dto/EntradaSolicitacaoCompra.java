package aplication.dto;

import javax.persistence.OneToOne;

import aplication.domain.Cliente;
import aplication.domain.Compra;
import lombok.Data;

@Data
public class EntradaSolicitacaoCompra {
	
	@OneToOne
	Compra compra;
	@OneToOne
	Cliente cliente;
	String destino;
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
}
