package br.com.theWandererApi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.theWandererApi.exception.ResourceNotFoundException;
import br.com.theWandererApi.models.Clientes;
import br.com.theWandererApi.repositories.ClientesRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/clientes")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ClientesController {
	
	@Autowired
	private ClientesRepository repo;	
	
	@GetMapping
	public List<Clientes> findAll(@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails);
		List<Clientes> result = repo.findAll();
		return result;
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public Clientes createCliente(@RequestBody Clientes clientes) {
		return repo.save(clientes);
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Clientes> readCliente(@PathVariable Long id){
		Clientes clientes = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id Não Encontrado: "+id));
		return ResponseEntity.ok(clientes);
	}
		
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Clientes> updateCliente(@PathVariable Long id, @RequestBody Clientes clienteDetalhes){
		Clientes clientes = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id Não Encontrado: "+id));
		clientes.setNome(clienteDetalhes.getNome());
		clientes.setEmail(clienteDetalhes.getEmail());
		clientes.setSenha(clienteDetalhes.getSenha());
		Clientes updateCliente = repo.save(clientes);
		return ResponseEntity.ok(updateCliente);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCliente(@PathVariable Long id){
		Clientes clientes = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id Não Encontrado: "+id));
		repo.delete(clientes);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deletado",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
