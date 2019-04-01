package edu.com.iesp.cargas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.com.iesp.cargas.model.Fornecedor;
import edu.com.iesp.cargas.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	FornecedorService fornecedorService;
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> listarFornecedores(){
		List<Fornecedor> fornecedores = fornecedorService.listarFornecedores();
		return ResponseEntity.ok().body(fornecedores);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> buscarFornecedor(@PathVariable Long id){
		Fornecedor fornecedor = fornecedorService.buscarFornecedor(id);
		return ResponseEntity.ok().body(fornecedor);
	}
	
	@PostMapping
	public ResponseEntity<Fornecedor> salvarFornecedor(@RequestBody Fornecedor fornecedor){
		Fornecedor fornecedorSalvo = fornecedorService.salvarFornecedor(fornecedor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(fornecedorSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(fornecedorSalvo);
	}
	
	@PutMapping
	public ResponseEntity<Fornecedor> atualizarFornecedor(@RequestBody Fornecedor fornecedor){
		Fornecedor fornecedorAtualizar = fornecedorService.atualizarFornecedor(fornecedor);
		return ResponseEntity.ok().body(fornecedorAtualizar);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> removerFornecedor(Long id){
		fornecedorService.removerFornecedor(id);
		return ResponseEntity.noContent().build();
	}
	

}
