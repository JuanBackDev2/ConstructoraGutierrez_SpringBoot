package com.constructora.gutierrez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.constructora.gutierrez.dtos.MensajeDTO;
import com.constructora.gutierrez.dtos.ObraDTO;
import com.constructora.gutierrez.dtos.TerrenoDTO;
import com.constructora.gutierrez.services.TerrenoService;

@RestController
@RequestMapping("/terreno")
@CrossOrigin(origins = "http://localhost:4200")
public class TerrenoController {
	
	@Autowired
	TerrenoService terrenoService;

	@GetMapping
	public Page<TerrenoDTO> obtenerTerrenos(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="3") int size){
		Pageable paging = PageRequest.of(page, size);
		
		return terrenoService.obtenerTerrenos(paging);
		
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity obtenerTerreno(@PathVariable("id") String id) {
		return new ResponseEntity(terrenoService.obtenerTerreno(id),HttpStatus.OK);
		
	}
	
	@GetMapping(path="/existsById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity existsById(@PathVariable("id") String id) {
		if(terrenoService.existsById(id)) {
			return new ResponseEntity(MensajeDTO.builder().mensaje("V").build(),HttpStatus.OK);
		}
		return new ResponseEntity(MensajeDTO.builder().mensaje("F").build(),HttpStatus.OK);
	}
	
	@PostMapping(path="/registrarTerreno",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity registrarObra(@RequestBody TerrenoDTO terrenoDTO) {
		terrenoService.registrarTerreno(terrenoDTO);
		return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@PutMapping(path="/editarTerreno/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity editarTerreno(@PathVariable("id") String id,@RequestBody TerrenoDTO terrenoDTO) {
		terrenoService.editarTerreno(id, terrenoDTO);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity eliminarTerreno(@PathVariable("id") String id) {
		terrenoService.eliminarTerreno(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
