package aplication.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import aplication.domain.SolicitacaoCompraStatus;

public class SaidaSolicitacaoCompra {
	
	
	Long id;
//	@OneToOne
//	Compra compra;
//	@OneToOne
//	Cliente cliente;
	
	@Enumerated(EnumType.STRING)
	SolicitacaoCompraStatus status;
	Date creationDate;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
