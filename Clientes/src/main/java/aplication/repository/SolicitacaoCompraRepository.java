package aplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import aplication.domain.SolicitacaoCompra;
import aplication.domain.SolicitacaoCompraStatus;

public interface SolicitacaoCompraRepository extends JpaRepository<SolicitacaoCompra, Long> {
	
	List<SolicitacaoCompra> findByStatus(SolicitacaoCompraStatus status);
	
}
