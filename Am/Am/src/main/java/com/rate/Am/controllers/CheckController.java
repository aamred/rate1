package com.rate.Am.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anton Muzhytskyi
 */

@RestController
@RequestMapping("api")
public class CheckController {

	@GetMapping("/check")
	public String checking() {
		return "checked!";
	}
}
