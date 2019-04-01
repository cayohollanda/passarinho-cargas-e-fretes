package edu.com.iesp.cargas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.com.iesp.cargas.model.Fornecedor;
import edu.com.iesp.cargas.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Transactional
	public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor); 
	}
	
	public List<Fornecedor> listarFornecedores() {
		return fornecedorRepository.findAll();
	}
	
	@Transactional
	public void removerFornecedor(Long id) {
		fornecedorRepository.deleteById(id);
	}
	
	public Fornecedor buscarFornecedor (Long id) {
		return fornecedorRepository.getOne(id);
	}
	@Transactional
	public Fornecedor atualizarFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.saveAndFlush(fornecedor);
	}

}
