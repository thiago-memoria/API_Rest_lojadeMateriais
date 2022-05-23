package aplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Produto {

	@Id
	@GeneratedValue
	long id;
	String descricao;
	double preco;
	int tipo;
	
	public String getDescricao() {
		return descricao;
	}
	public double getPreco() {
		return preco;
	}
	public int getTipo() {
		return tipo;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
