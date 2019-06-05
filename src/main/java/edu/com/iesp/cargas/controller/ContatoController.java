package edu.com.iesp.cargas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.com.iesp.cargas.model.Contato;
import edu.com.iesp.cargas.service.ContatoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@Api(value = "Contatos", description = "Api para gerenciamento de contatos")
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@ApiOperation(value = "Realiza o cadastro de um novo cliente.")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Contato> cadastrarContato(@RequestBody Contato contato) {
		Contato contatoSalvo = contatoService.salvarContato(contato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}").buildAndExpand(contato).toUri();
		return ResponseEntity.created(uri).body(contatoSalvo);
	}
	@ApiOperation(value = "Realiza a listagem de todos os clientes cadastrados na base.")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Contato>> listarContatos(){
		return ResponseEntity.ok().body(contatoService.listarContatos());
	}
	
	@ApiOperation(value = "Busca um cliente a partir de seu identificador")
	@GetMapping("/{id}")
	public ResponseEntity<Contato> buscarContatoPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(this.contatoService.buscaContatoPorId(id));
	}
	
	@ApiOperation(value = "Deleta um cliente específico a partir de seu identificador.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletaContato(@PathVariable Long id) {
		return contatoService.removeContatoPorId(id);
	}
	
	@ApiOperation(value = "Realiza a atualizacao de um cliente passado na requisição.")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Contato> alteraContato(@RequestBody Contato contato) {
		contatoService.atualizarContato(contato);
		return ResponseEntity.noContent().build();
	}
	
}
