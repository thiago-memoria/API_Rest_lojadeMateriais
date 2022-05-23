package aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aplication.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
