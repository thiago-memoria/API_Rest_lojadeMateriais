package aplication.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aplication.domain.SolicitacaoCompra;
import aplication.domain.SolicitacaoCompraStatus;
import aplication.repository.SolicitacaoCompraRepository;

@Component
public class SolicitacaoCompraService {
	
	@Autowired
	SolicitacaoCompraRepository solicitacaoCompraRepository;
	
	public SolicitacaoCompra salvarSolicitacaoCompra(SolicitacaoCompra solicitacaoCompra) {
		solicitacaoCompra.setCreationDate(new Date());
		solicitacaoCompra.setStatus(SolicitacaoCompraStatus.created);
		return solicitacaoCompraRepository.save(solicitacaoCompra);
	}
	
}
