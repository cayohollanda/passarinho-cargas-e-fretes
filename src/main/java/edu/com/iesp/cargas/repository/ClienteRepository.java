package edu.com.iesp.cargas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.com.iesp.cargas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
