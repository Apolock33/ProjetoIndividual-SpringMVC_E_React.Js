package br.com.theWandererApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.theWandererApi.repositories.ViagensUserRepository;

@Service
public class ViagensUserService implements UserDetailsService{
	
	@Autowired(required=true)
	private ViagensUserRepository viagensUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(viagensUserRepository.findByUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("Usuario Não Encontrado"));
	}

}
