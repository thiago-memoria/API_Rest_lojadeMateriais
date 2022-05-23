package aplication.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import aplication.domain.Cliente;
import aplication.repository.ClienteRepository;

@Service
@RestController()
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteAPI {

	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente>listClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente findCliete(@PathVariable("id")long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/clientes/{id}")
	public Cliente fullUpdateCliente(@PathVariable("id")long id, @RequestBody Cliente cliente) {
		Cliente foundCliente = findCliete(id);
		foundCliente.setName(cliente.getName());
		foundCliente.setCarrinho(cliente.getCarrinho());
		return clienteRepository.save(foundCliente);
	}
	
	@PatchMapping("/clientes/{id}")
	public Cliente incrementalUpdateCliente(@PathVariable("id")long id, @RequestBody Cliente cliente) {
		Cliente foundCliente = findCliete(id);
		foundCliente.setName(Optional.ofNullable(cliente.getName()).orElse(foundCliente.getName()));
		foundCliente.setCarrinho(Optional.ofNullable(cliente.getCarrinho()).orElse(foundCliente.getCarrinho()));
		return clienteRepository.save(foundCliente);
	}
	
	@DeleteMapping("/cliente/{id}")
	public void deleteCliente(@PathVariable("id")long id) {
		clienteRepository.delete(findCliete(id));
	}
}
