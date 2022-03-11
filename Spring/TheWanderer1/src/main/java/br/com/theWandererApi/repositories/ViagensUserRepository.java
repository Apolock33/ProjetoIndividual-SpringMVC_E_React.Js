package br.com.theWandererApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.theWandererApi.models.ViagensUser;

@Repository
public interface ViagensUserRepository extends JpaRepository<ViagensUser, Long>{
	
	ViagensUser findByUsername(String username);
	
}
