package aplication.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class SolicitacaoCompra {
	
	@Id
	@GeneratedValue
	long id;
	
	@OneToOne
	Compra compra;
	@OneToOne
	Cliente cliente;
	
	@Enumerated(EnumType.STRING)
	SolicitacaoCompraStatus status;
	Date creationDate;
	
	public long getId() {
		return id;
	}
	
	public SolicitacaoCompraStatus getStatus() {
		return status;
	}

	public void setStatus(SolicitacaoCompraStatus status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

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
	String destino;
	
}
