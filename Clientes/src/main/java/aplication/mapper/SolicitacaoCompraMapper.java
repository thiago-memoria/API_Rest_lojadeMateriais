package aplication.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import aplication.domain.Cliente;
import aplication.domain.Compra;
import aplication.domain.SolicitacaoCompra;
import aplication.dto.EntradaSolicitacaoCompra;
import aplication.dto.SaidaSolicitacaoCompra;
import aplication.interfaces.CompraAPI;
import aplication.repository.ClienteRepository;
import aplication.repository.CompraRepository;


@Component
public class SolicitacaoCompraMapper {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	public SolicitacaoCompra map(EntradaSolicitacaoCompra entrada) {
		
		Cliente cliente = clienteRepository.findById(entrada.getCliente().getId()).orElseThrow(() ->
		new ResponseStatusException(HttpStatus.NOT_FOUND));
		Compra compra = compraRepository.findById(entrada.getCompra().getId()).orElseThrow(() ->
		new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		SolicitacaoCompra solicitacaoCompra = new SolicitacaoCompra();
		solicitacaoCompra.setCliente(entrada.getCliente());
		solicitacaoCompra.setCompra(entrada.getCompra());
		solicitacaoCompra.setDestino(entrada.getDestino());
		
		return solicitacaoCompra;
	}
	
	public SaidaSolicitacaoCompra map(SolicitacaoCompra solicitacaoCompra) {
		SaidaSolicitacaoCompra saidaSolicitacaoCompra = new SaidaSolicitacaoCompra();
		
		saidaSolicitacaoCompra.setId(solicitacaoCompra.getId());
		saidaSolicitacaoCompra.setCreationDate(solicitacaoCompra.getCreationDate());
		saidaSolicitacaoCompra.setStatus(solicitacaoCompra.getStatus());
		
		return saidaSolicitacaoCompra;
	}
		
	public EntityModel<SaidaSolicitacaoCompra> buildSaidaModel(SolicitacaoCompra solicitacaoCompra, SaidaSolicitacaoCompra saida){
		
		EntityModel<SaidaSolicitacaoCompra> model = EntityModel.of(saida);
		
		Link compraLink = WebMvcLinkBuilder
		.linkTo(CompraAPI.class)
		.slash(solicitacaoCompra.getCompra().getId()) 
		.withRel("compra")
		.withTitle(solicitacaoCompra.getCompra().getCliente().getName());
		model.add(compraLink);
		return model;
	}
	
}
