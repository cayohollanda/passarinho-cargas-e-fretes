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

@Controller
@RequestMapping("/parceiros")
public class ParceiroController {
	
	@Autowired
	ParceiroService parceiroService;
	
	@GetMapping
	public ResponseEntity<List<Parceiro>> listarParceiroes(){
		List<Parceiro> parceiros = parceiroService.listarParceiroes();
		return ResponseEntity.ok().body(parceiros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Parceiro> buscarParceiro(@PathVariable Long id){
		Parceiro parceiro = parceiroService.buscarParceiro(id);
		return ResponseEntity.ok().body(parceiro);
	}
	
	@PostMapping
	public ResponseEntity<Parceiro> salvarParceiro(@RequestBody Parceiro Parceiro){
		Parceiro parceiroSalvo = parceiroService.salvarParceiro(Parceiro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(parceiroSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(parceiroSalvo);
	}
	
	@PutMapping
	public ResponseEntity<Parceiro> atualizarParceiro(@RequestBody Parceiro parceiro){
		Parceiro parceiroAtualizar = parceiroService.atualizarParceiro(parceiro);
		return ResponseEntity.ok().body(parceiroAtualizar);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> removerParceiro(Long id){
		parceiroService.removerParceiro(id);
		return ResponseEntity.noContent().build();
	}
	

}
