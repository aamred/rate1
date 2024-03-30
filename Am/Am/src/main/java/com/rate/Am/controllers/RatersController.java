package com.rate.Am.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rate.Am.dto.RaterDTO;
import com.rate.Am.models.Rater;
import com.rate.Am.services.RatersService;
import com.rate.Am.util.RaterErrorResponse;
import com.rate.Am.util.RaterNotCreatedException;
import com.rate.Am.util.RaterNotFoundException;
import com.rate.Am.util.RaterValidator;



import jakarta.validation.Valid;

/**
 * @author Anton Muzhytskyi
 */

@RestController
@RequestMapping("/raters")
public class RatersController {
	
	private final RatersService ratersService;
	private final RaterValidator raterValidator;
	private final ModelMapper modelMapper;
	
	@Autowired
	public RatersController(RatersService ratersService, RaterValidator raterValidator, ModelMapper modelMapper) {
		//super();
		this.ratersService = ratersService;
		this.raterValidator = raterValidator;
		this.modelMapper = modelMapper;
	}

	
	@GetMapping()
	public List<RaterDTO> getRaters(){
        return ratersService.findAll().stream()
        		.map(rater -> modelMapper.map(rater, RaterDTO.class))
                .collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public RaterDTO getRater(@PathVariable("id") int raterId) {
		return convertToRaterDTO(ratersService.findOne(raterId));
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> create(@RequestBody @Valid RaterDTO raterDTO
			, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			
			StringBuilder errorMsg = new StringBuilder();
			
			List<FieldError> errors = bindingResult.getFieldErrors();
			for(FieldError error : errors) {
				errorMsg.append(error.getField())
					.append(" - ").append(error.getDefaultMessage()).append(" ; ");
			}
			throw new RaterNotCreatedException(errorMsg.toString());
		}
		
		ratersService.save(convertToRater(raterDTO));
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	
	@ExceptionHandler       
	private ResponseEntity<RaterErrorResponse> handleException(RaterNotFoundException e){
		RaterErrorResponse response = new RaterErrorResponse(
				"Person with this id was not found",
				System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);   //not found = 404 status	
	}
	
	@ExceptionHandler       
	private ResponseEntity<RaterErrorResponse> handleException(RaterNotCreatedException e){
		RaterErrorResponse response = new RaterErrorResponse(
				e.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);   //not found = 404 status		
	}
	
	
	private RaterDTO convertToRaterDTO(Rater rater) {
		return modelMapper.map(rater, RaterDTO.class);
	}

	private Rater convertToRater(RaterDTO raterDTO) {
		return modelMapper.map(raterDTO, Rater.class);
	}
	
}
