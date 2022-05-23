package aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aplication.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
