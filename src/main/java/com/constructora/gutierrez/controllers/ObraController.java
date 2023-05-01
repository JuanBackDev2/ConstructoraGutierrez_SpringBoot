package com.constructora.gutierrez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.constructora.gutierrez.dtos.ObraDTO;
import com.constructora.gutierrez.dtos.PersonalObraDTO;
import com.constructora.gutierrez.entities.Obra;
import com.constructora.gutierrez.entities.PersonalObra;
import com.constructora.gutierrez.repositories.ObraRepository;
import com.constructora.gutierrez.services.ObraService;
import com.constructora.gutierrez.services.PersonalObraService;

@RestController
@RequestMapping("/obra")
@CrossOrigin(origins = "http://localhost:4200")
public class ObraController {
	
	@Autowired
	ObraService obraService;
	
	@Autowired
	PersonalObraService poService;

	@GetMapping
	public Page<ObraDTO> obtenerObras(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue = "3") int size){
		Pageable paging = PageRequest.of(page, size);
        return obraService.obtenerObras(paging);
		
	}
	
	
	@GetMapping(path="/{id}")
	public ResponseEntity obtenerObra(@PathVariable("id") String id) {
		return new ResponseEntity(obraService.obtenerObra(id),HttpStatus.OK);
		
	}
	
	
	@GetMapping(path="/personalObra/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<PersonalObraDTO> obtenerPersonalObra(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue = "3") int size,@PathVariable String id){
		Pageable paging = PageRequest.of(page, size);
		return poService.obtenerPersonalObra(paging,id);
		
	}
	
}
