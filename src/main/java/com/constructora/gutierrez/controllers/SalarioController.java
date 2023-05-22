package com.constructora.gutierrez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.constructora.gutierrez.repositories.SalarioRepository;
import com.constructora.gutierrez.services.SalarioService;

@RestController
@RequestMapping("/salario")
@CrossOrigin(origins = "http://localhost:4200")
public class SalarioController {
	
	@Autowired
	SalarioService salarioService;

	@GetMapping(path="findSalario/{id}")
	public double findSalario(@PathVariable("id") String id) {
		return salarioService.findSalario(id);
	}
}
