package com.rate.Am.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rate.Am.models.Rater;
import com.rate.Am.services.RatersService;


/**
 * @author Anton Muzhytskyi
 */

@Component
public class RaterValidator implements Validator {

	private final RatersService ratersService;
	
	
	@Autowired
	public RaterValidator(RatersService ratersService) {
		//super();
		this.ratersService = ratersService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Rater.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Rater rater = (Rater) target;
		Optional<Rater> existingUser = Optional.of(ratersService.findOne(rater.getRaterId()));
	    if (existingUser.isPresent()) {
	        errors.rejectValue("raterId", "", "User with this id already exists");
	    }
		
	}
	

}
