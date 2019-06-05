package edu.com.iesp.cargas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.com.iesp.cargas.model.Parceiro;
import edu.com.iesp.cargas.service.ParceiroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/parceiros")
@Api(value = "Parceiro", description = "API para gerenciamento de parceiros.")
public class ParceiroController {
	
	@Autowired
	ParceiroService parceiroService;
	
	@ApiOperation(value = "Realiza listagem de todos os parceiros cadastrados na base.")
	@GetMapping
	public ResponseEntity<List<Parceiro>> listarParceiroes(){
		List<Parceiro> parceiros = parceiroService.listarParceiroes();
		return ResponseEntity.ok().body(parceiros);
	}
	
	@ApiOperation(value = "Realiza a busca de um parceiro a partir de seu identificador.")
	@GetMapping("/{id}")
	public ResponseEntity<Parceiro> buscarParceiro(@PathVariable Long id){
		Parceiro parceiro = parceiroService.buscarParceiro(id);
		return ResponseEntity.ok().body(parceiro);
	}
	
	@ApiOperation(value = "Realiza o cadastro de um novo parceiro.")
	@PostMapping
	public ResponseEntity<Parceiro> salvarParceiro(@RequestBody Parceiro Parceiro){
		Parceiro parceiroSalvo = parceiroService.salvarParceiro(Parceiro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(parceiroSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(parceiroSalvo);
	}
	
	@ApiOperation(value = "Realiza a atualização dos dados de um parceiro.")
	@PutMapping
	public ResponseEntity<Parceiro> atualizarParceiro(@RequestBody Parceiro parceiro){
		Parceiro parceiroAtualizar = parceiroService.atualizarParceiro(parceiro);
		return ResponseEntity.ok().body(parceiroAtualizar);
	}
	
	@ApiOperation(value = "Remove um parceiro através de seu identificador.")
	@DeleteMapping
	public ResponseEntity<Void> removerParceiro(Long id){
		parceiroService.removerParceiro(id);
		return ResponseEntity.noContent().build();
	}
	

}
