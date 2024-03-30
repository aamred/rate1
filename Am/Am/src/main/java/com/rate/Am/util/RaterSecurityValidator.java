package com.rate.Am.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rate.Am.models.Rater;
import com.rate.Am.services.RaterDetailsService;


/**
 * @author Anton Muzhytskyi
 */

@Component
public class RaterSecurityValidator implements Validator {

private final RaterDetailsService raterDetailsService;
	

	@Autowired
	public RaterSecurityValidator(RaterDetailsService raterDetailsService) {
		super();
		this.raterDetailsService = raterDetailsService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Rater.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Rater rater = (Rater)target;
		
		try {
			raterDetailsService.loadUserByUsername(rater.getNickname());
		} catch (UsernameNotFoundException ignored) {
			
		}
		errors.rejectValue("nickname","", "Person with this nickname already exist");	
	}
}
