package edu.com.iesp.cargas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public Contato salvarContato (Contato contato) {
		return this.contatoRepository.save(contato);
	}
	
	@Transactional(readOnly=true)
	public List<Contato> listarContatos(){
		return this.contatoRepository.findAll();
	}
	
	@Transactional
	public ResponseEntity<Void> removeContatoPorId(Long id) {
		Contato contato = buscaContato(id);
		if(contato!=null) {
			this.contatoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public Contato buscaContatoPorId(Long id) {
		return this.contatoRepository.getOne(id);
	}
	
	@Transactional
	public void atualizarContato(Contato contato) {
		Optional<Contato> c = contatoRepository.findById(contato.getId());
		if(c.isPresent()) {
			this.contatoRepository.saveAndFlush(contato);
		}
		else {
			return;
		}
	}
	
	public Contato buscaContato(long id) {
		Optional<Contato> c = contatoRepository.findById(id);
		if(c.isPresent()) {
			return c.get();
		}
		else {
			return null;
		}
	}
}
