package edu.com.iesp.cargas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.com.iesp.cargas.exceptions.ClienteNaoEncontradoException;
import edu.com.iesp.cargas.model.Cliente;
import edu.com.iesp.cargas.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente cadastrarCliente(Cliente cliente) {
		Cliente clienteCadastrado = clienteRepository.save(cliente);
		return clienteCadastrado;
	}
	
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente buscarClientePorId(Long id) {
		return buscarCliente(id);
	}
	
	public void deletarCliente (Long id) {
		Cliente c = buscarCliente(id);
		clienteRepository.delete(c);
	}
	
	public Cliente atualizarCliente(Cliente cliente) {
		Cliente c;
		if(cliente.getId() != null) {
			c = buscarCliente(cliente.getId());
			return clienteRepository.saveAndFlush(c);
		} else {
			return clienteRepository.save(cliente);
		}
	}
	
	private Cliente buscarCliente(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.isPresent() ? cliente.get() :
								   cliente.orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));
	}
	
}
