package aplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Carrinho {
	
	@Id
	@GeneratedValue
	long id;
	@OneToOne Cliente cliente;
	@OneToOne Produto[] carrinho;
	double valor;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto[] getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Produto[] carrinho) {
		this.carrinho = carrinho;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
