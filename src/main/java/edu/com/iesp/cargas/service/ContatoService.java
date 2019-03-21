package edu.com.iesp.cargas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.com.iesp.cargas.model.Contato;
import edu.com.iesp.cargas.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	
	// CRUD
	@Transactional
	public void salvarContato (Contato contato) {
		this.contatoRepository.save(contato);
	}
	
	@Transactional(readOnly=true)
	public List<Contato> listarContatos(){
		return this.contatoRepository.findAll();
	}
	
	@Transactional
	public void removeContatoPorId(Long id) {
		this.contatoRepository.deleteById(id);
	}
	
	public Contato buscaContatoPorId(Long id) {
		return this.contatoRepository.getOne(id);
	}
	
	@Transactional
	public void atualizarContato(Contato contato) {
		this.contatoRepository.saveAndFlush(contato);
	}
}
