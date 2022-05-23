package aplication.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import aplication.domain.Compra;
import aplication.interfacesOutcoming.GMapsService;
import aplication.repository.CompraRepository;

@Service
@RestController()
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CompraAPI {
	
	@Autowired
	CompraRepository compraRepository;
	
	@Autowired
	GMapsService gMapsService;
	
	@GetMapping("/compras")
	public List<Compra>listCompras(){
		return compraRepository.findAll();
	}
	
	@GetMapping("/compras/{id}")
	public Compra findCompra(@PathVariable("id")long id) {
		return compraRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/compras/{id}")
	public Compra fullUpdateCliente(@PathVariable("id")long id, @RequestBody Compra compra) {
		Compra foundCompra = findCompra(id);
		foundCompra.setValor(compra.getCliente().getCarrinho().getValor());
		foundCompra.setCliente(compra.getCliente());
		foundCompra.setProdutos(compra.getCliente().getCarrinho().getCarrinho());
		foundCompra.setEnderecoEntrega(compra.getEnderecoEntrega());
		foundCompra.setEnderecoLoja(compra.getEnderecoLoja());
		foundCompra.setTempoDeEntrega(gMapsService.getDistanceBetweenAddresses(compra.getEnderecoLoja(), compra.getEnderecoEntrega()));
		return compraRepository.save(foundCompra);
	}
}
