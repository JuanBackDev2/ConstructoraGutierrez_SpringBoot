package com.constructora.gutierrez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.constructora.gutierrez.dtos.PersonalDTO;
import com.constructora.gutierrez.services.PersonalService;

@RestController
@RequestMapping("/personal")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonalController {

	@Autowired
	PersonalService ps;
	
	@GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonalDTO> obtenerPersonalPorId(@PathVariable("id")String id) {
		
		return new ResponseEntity<PersonalDTO>(ps.findById(id),HttpStatus.OK);
		
	}
}
