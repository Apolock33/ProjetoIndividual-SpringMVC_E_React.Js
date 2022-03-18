package br.com.theWandererApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.theWandererApi.Models.Destinos;
import br.com.theWandererApi.Service.DestinosService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/destinos")
@RestController
public class DestinosController {

	@Autowired
	private DestinosService service;

	@GetMapping
	public ResponseEntity<List<Destinos>> getAll() {
		return ResponseEntity.ok().body(service.getAll());
	}

	@PostMapping("/add")
	public ResponseEntity<Destinos> save(@RequestBody Destinos destinos) {
		try {
			service.save(destinos);
			return ResponseEntity.ok().body(destinos);
		} catch (Exception ex) {
			// TODO: handle exception
			throw ex;
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Destinos> getById(@PathVariable Long id) {
		try {
			Destinos destinos = service.getById(id);
			return ResponseEntity.ok().body(destinos);
		} catch (Exception err) {
			throw err;
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Destinos> update(@RequestBody Destinos destinos) {
		try {
			service.update(destinos);
			return ResponseEntity.ok().body(destinos);
		} catch (Exception err) {
			throw err;
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Destinos> delete(@PathVariable Long id) {
		try {
			Destinos destinos = service.getById(id);
			service.delete(destinos);
			return ResponseEntity.ok().body(destinos);
		} catch (Exception err) {
			throw err;
		}
	}
}
