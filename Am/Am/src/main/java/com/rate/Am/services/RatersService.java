package com.rate.Am.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rate.Am.models.Rater;
import com.rate.Am.repositories.RatersRepository;
import com.rate.Am.util.RaterNotFoundException;

/**
 * @author Anton Muzhytskyi
 */

@Service
@Transactional(readOnly = true)
public class RatersService {
	
	private RatersRepository ratersRepository;

	@Autowired
	public RatersService(RatersRepository ratersRepository) {
		//super();
		this.ratersRepository = ratersRepository;
	}

	public  List<Rater> findAll(){      //static?
		return ratersRepository.findAll();
	}
	
	public Rater findOne(int raterId) {
		Optional<Rater> foundUser = ratersRepository.findById(raterId);
		return foundUser.orElseThrow(RaterNotFoundException::new);
	}
	
	public Rater findOne(String telephone) {
		Optional<Rater> foundUser = ratersRepository.findByTelephone(telephone);
		return foundUser.orElseThrow(RaterNotFoundException::new);
	}
	
	public Rater findOneByNickname(String nickname) {
		Optional<Rater> foundUser = ratersRepository.findByNickname(nickname);
		return foundUser.orElseThrow(RaterNotFoundException::new);
	} 
	
	
	@Transactional
	public void save(Rater rater) {
		enrichUser(rater);
		ratersRepository.save(rater);
	}
	
	private void enrichUser(Rater rater) {
		rater.setRole("USER");
		
	}

	
}
