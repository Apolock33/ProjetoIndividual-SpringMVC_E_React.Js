package br.com.theWandererApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.theWandererApi.Models.Destinos;

@Repository
public interface DestinosRepository extends JpaRepository<Destinos, Long>{

}
