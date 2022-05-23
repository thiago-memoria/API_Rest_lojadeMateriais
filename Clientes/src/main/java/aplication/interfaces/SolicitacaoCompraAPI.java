package aplication.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aplication.domain.SolicitacaoCompra;
import aplication.dto.EntradaSolicitacaoCompra;
import aplication.dto.SaidaSolicitacaoCompra;
import aplication.mapper.SolicitacaoCompraMapper;
import aplication.service.SolicitacaoCompraService;

@Service
@RestController
@RequestMapping(path = "/solicitacaoCompras", produces = MediaType.APPLICATION_JSON_VALUE)
public class SolicitacaoCompraAPI {
	
	@Autowired
	SolicitacaoCompraService solicitacaoCompraService;
	
	@Autowired
	SolicitacaoCompraMapper solicitacaoCompraMapper;
	
	@PostMapping
	public EntityModel<SaidaSolicitacaoCompra> fazerSolicitacaoCompra(@RequestBody EntradaSolicitacaoCompra entradaSolicitacaoCompra){
		SolicitacaoCompra solicitacaoCompra = solicitacaoCompraService.salvarSolicitacaoCompra(solicitacaoCompraMapper.map(entradaSolicitacaoCompra));
		SaidaSolicitacaoCompra saidaSolicitacaoCompra = solicitacaoCompraMapper.map(solicitacaoCompra);
		return solicitacaoCompraMapper.buildSaidaModel(solicitacaoCompra, saidaSolicitacaoCompra);
	}
	
}
