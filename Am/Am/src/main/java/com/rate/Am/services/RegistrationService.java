package com.rate.Am.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rate.Am.models.Rater;
import com.rate.Am.repositories.RatersRepository;


/**
 * @author Anton Muzhytskyi
 */

@Service
public class RegistrationService {
	
	private final RatersRepository ratersRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired	
	public RegistrationService(RatersRepository ratersRepository, PasswordEncoder passwordEncoder) {
		super();
		this.ratersRepository = ratersRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public void register(Rater rater) {
		rater.setPassword(passwordEncoder. encode(rater.getPassword()));
		rater.setRole("USER");
		ratersRepository.save(rater);	
	}
	
}
