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

import aplication.domain.Produto;
import aplication.repository.ProdutoRepository;

@Service
@RestController()
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoAPI {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto>listProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	public Produto findProduto(@PathVariable("id")long id) {
		return produtoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/produtos")
	public Produto createProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PostMapping("/produtos/{id}")
	public Produto fullUpdateProduto(@PathVariable("id")long id, @RequestBody Produto produto) {
		Produto foundProduto = findProduto(id);
		foundProduto.setDescricao(produto.getDescricao());
		foundProduto.setPreco(produto.getPreco());
		foundProduto.setTipo(produto.getTipo());
		return produtoRepository.save(foundProduto);
	}
	
	@PatchMapping("/produtos/{id}")
	public Produto incrementalUpdateProduto(@PathVariable("id") long id, @RequestBody Produto produto) {
		Produto foundProduto = findProduto(id);
		foundProduto.setDescricao(Optional.ofNullable(produto.getDescricao()).orElse(foundProduto.getDescricao()));
		foundProduto.setPreco(Optional.ofNullable(produto.getPreco()).orElse(foundProduto.getPreco()));
		foundProduto.setTipo(Optional.ofNullable(produto.getTipo()).orElse(foundProduto.getTipo()));
		return produtoRepository.save(foundProduto);
	}
	
	@DeleteMapping("/produtos/{id}")
	public void deleteProduto(@PathVariable("id") long id) {
		produtoRepository.delete(findProduto(id));
	}
	
}
