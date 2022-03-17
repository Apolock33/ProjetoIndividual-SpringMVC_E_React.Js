package br.com.theWandererApi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.theWandererApi.Models.Destinos;
import br.com.theWandererApi.Repository.DestinosRepository;

@Service
public class DestinosService {
	
	@Autowired
	private DestinosRepository repo;
	
	public List<Destinos> getAll() {
		return repo.findAll();
	}

	public Destinos getById(Long id) {
		Optional<Destinos> destinos = repo.findById(id);
		if (destinos.isPresent()) {
			return destinos.get();
		} else {
			return null;
		}
	}

	public void save(Destinos destinos) {
		try {
			repo.save(destinos);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void update(Destinos destinos) {
		try {
			repo.save(destinos);
		}catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}
	
	public void deleteById(Long id) {
		Optional<Destinos> destinos = repo.findById(id);
		if(destinos.isPresent()) {
			repo.delete(destinos.get());
		}
	}
	
	public void delete(Destinos destinos) {
		try {
			repo.delete(destinos);
		}catch(Exception err) {
			System.out.println(err.getMessage());
		}
	}
}
