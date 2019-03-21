package edu.com.iesp.cargas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.com.iesp.cargas.model.Contato;
import edu.com.iesp.cargas.service.ContatoService;

@Controller
@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarContato(@RequestBody Contato contato) {
		Contato contatoMontado = new Contato();
		contatoService.salvarContato(contato);
	}
	
	@GetMapping
	public List<Contato> listarContatos(){
		return contatoService.listarContatos();
	}
	
	@GetMapping("/{id}")
	public Contato buscarContatoPorId(@PathVariable Long id) {
		return contatoService.buscaContatoPorId(id);		
	}
	
	@DeleteMapping("/{id}")
	public void deletaContato(@PathVariable Long id) {
		contatoService.removeContatoPorId(id);
	}
	
	public void alteraContato(Contato contato) {
		contatoService.atualizarContato(contato);
	}
	
}
