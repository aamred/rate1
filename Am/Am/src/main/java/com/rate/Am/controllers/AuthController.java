package com.rate.Am.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rate.Am.models.Rater;

import com.rate.Am.services.RegistrationService;
import com.rate.Am.util.RaterValidator;


import jakarta.validation.Valid;

/**
 * @author Anton Muzhytskyi
 */

//@RestControler
@Controller
@RequestMapping("/auth")
public class AuthController {
	
	private final RegistrationService registrationService;
	private final RaterValidator raterValidator;
	
	@Autowired
	public AuthController(RegistrationService registrationService, RaterValidator raterValidator) {
		//super();
		this.registrationService = registrationService;
		this.raterValidator = raterValidator;
	}

	@GetMapping("/login")
	public String loginPage() {
		return "/auth/login";
	}

	@GetMapping("/registration")
	public String registrationPage(@ModelAttribute("rater") Rater rater) {
		return "/auth/registration";
	}
	
	@PostMapping("/registration")
	public String  performRegistration(@ModelAttribute("rater") @Valid Rater rater,
			BindingResult bindingResult) {
		raterValidator.validate(rater, bindingResult);
		if(bindingResult.hasErrors())
			return "/auth/registration";
		
		registrationService.register(rater);
		return "redirect:/auth/login";
	}
	
	//    ///////////////////////////////////////////////
	
//	 @PostMapping("/register")
//	    public Verification registerVerification(@RequestBody Verification verification) {
//	        return verificationService.registerVerification(verification);
//	    }
//
//	    @GetMapping("/{id}")
//	    public Verification getVerificationById(@PathVariable int id) {
//	        return verificationService.getVerificationById(id);
//	    }
//
//	    @PutMapping("/{id}")
//	    public Verification updateVerification(@PathVariable int id, @RequestBody Verification verification) {
//	        return verificationService.updateVerification(id, verification);
//	    }
//
//	    @DeleteMapping("/{id}")
//	    public void deleteVerification(@PathVariable int id) {
//	        verificationService.deleteVerification(id);
//	    }
	    //postman
	    //Request Type: POST
	    //URL: http://localhost:8080/auth/login
	    //Headers: Content-Type: application/json
	    //Body (Raw JSON):

}
