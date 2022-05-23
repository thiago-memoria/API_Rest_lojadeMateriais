package aplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Compra {
	
	@Id
	@GeneratedValue
	long id;
	double valor;
	String enderecoLoja;
	String enderecoEntrega;
	Integer tempoDeEntrega;
	@OneToOne Produto[] produtos;
	@OneToOne Cliente cliente;
	
	public Integer getTempoDeEntrega() {
		return tempoDeEntrega;
	}

	public void setTempoDeEntrega(Integer tempoDeEntrega) {
		this.tempoDeEntrega = tempoDeEntrega;
	}
	
	public String getEnderecoLoja() {
		return enderecoLoja;
	}

	public void setEnderecoLoja(String enderecoLoja) {
		this.enderecoLoja = enderecoLoja;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Produto[] getProdutos() {
		return produtos;
	}
	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
