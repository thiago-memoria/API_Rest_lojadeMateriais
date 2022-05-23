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

import aplication.domain.Carrinho;
import aplication.repository.CarrinhoRepository;

@Service
@RestController()
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CarrinhoAPI {
	
	@Autowired
	CarrinhoRepository carrinhoRepository;
	
	@GetMapping("/carrinho")
	public List<Carrinho>listCarrinho(){
		return carrinhoRepository.findAll();
	}
	
	@GetMapping("/carrinhos/{id}")
	public Carrinho findCarrinho(@PathVariable("id")long id) {
		return carrinhoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/carrinhos/{id}")
	public Carrinho fullUpdateCarrinho(@PathVariable("id")long id, @RequestBody Carrinho carrinho) {
		Carrinho foundcarrinho = findCarrinho(id);
		foundcarrinho.setCliente(carrinho.getCliente());
		foundcarrinho.setValor(carrinho.getValor());
		foundcarrinho.setCarrinho(carrinho.getCarrinho());
		return carrinhoRepository.save(foundcarrinho);
	}
	
}
