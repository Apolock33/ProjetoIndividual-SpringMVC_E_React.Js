package br.com.theWandererApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.theWandererApi.models.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long>{

}
