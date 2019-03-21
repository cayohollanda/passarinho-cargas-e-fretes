package edu.com.iesp.cargas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.com.iesp.cargas.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

	
}
