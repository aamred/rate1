package com.rate.Am.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rate.Am.models.Rater;
import com.rate.Am.repositories.RatersRepository;


import com.rate.Am.security.RaterDetails;

/**
 * @author Anton Muzhytskyi
 */

@Service
public class RaterDetailsService implements UserDetailsService {

	private final RatersRepository ratersRepository;

	@Autowired
	public RaterDetailsService(RatersRepository ratersRepository) {
		//super();
		this.ratersRepository = ratersRepository;
	}

	@Override
	public RaterDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
		Optional<Rater> rater = ratersRepository.findByNickname(nickname);
		
		if(rater.empty() == null) 
			throw new UsernameNotFoundException("User Not Found");
		return new RaterDetails(rater.get());
	}
	
	
	public RaterDetails loadUserByTelephone(String telephone) throws UsernameNotFoundException {
		Optional<Rater> rater = ratersRepository.findByTelephone(telephone);
		
		if(rater.empty() == null) 
			throw new UsernameNotFoundException("User Not Found");
		return new RaterDetails(rater.get());
	}
		
}
