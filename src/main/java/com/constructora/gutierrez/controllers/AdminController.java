package com.constructora.gutierrez.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.constructora.gutierrez.dtos.AdministradorDTO;
import com.constructora.gutierrez.dtos.MensajeDTO;
import com.constructora.gutierrez.services.AdministradorService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	AdministradorService as;
	
	@PostMapping(path = "/registrarAdmin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity registrarAdmin(@RequestBody AdministradorDTO administradorDTO) {
		try {
			as.registrarAdmin(administradorDTO);
			return new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping(path="/verificarCredenciales", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity verificarCredenciales(@RequestBody AdministradorDTO administradorDTO) {
		try {
			return new ResponseEntity(as.verificarCredenciales(administradorDTO),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
