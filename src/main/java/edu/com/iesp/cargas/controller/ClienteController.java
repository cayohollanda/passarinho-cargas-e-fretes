package edu.com.iesp.cargas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.com.iesp.cargas.model.Cliente;
import edu.com.iesp.cargas.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Api pra gerenciamento de clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation(value = "Retorna uma listagem com todos os clientes cadastrados.")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listarClientes(){
		return ResponseEntity.ok().body(clienteService.listarClientes());
	}
	
	@ApiOperation(value="Busca um cliente específico identificado pelo Id")
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Cliente buscarCliente (@PathVariable Long id) {
		return clienteService.buscarClientePorId(id);
	}
	
	@ApiOperation(value="Realiza o cadastro de um cliente")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.cadastrarCliente(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(clienteSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(clienteSalvo);
	}
	
	@ApiOperation(value = "Deletar um cliente a partir de seu identificador")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Atualiza os dados do cliente passado na requisicao")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente){
		clienteService.atualizarCliente(cliente);
		return ResponseEntity.noContent().build();
	}
	
	

}
