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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.constructora.gutierrez.dtos.CompradorDTO;
import com.constructora.gutierrez.dtos.MensajeDTO;
import com.constructora.gutierrez.dtos.ObraDTO;
import com.constructora.gutierrez.services.CompradorService;

@RestController
@RequestMapping("/comprador")
@CrossOrigin(origins = "http://localhost:4200")
public class CompradorController {
	
	@Autowired
	CompradorService compradorService;
	
	@GetMapping
	public Page<CompradorDTO> obtenerCompradores(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue = "3") int size){
		Pageable paging = PageRequest.of(page, size);
        return compradorService.obtenerCompradores(paging);
		
	}
	
	@GetMapping(path="/existsById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity existsById(@PathVariable("id")String id) {
		if(compradorService.existsById(id)) {
			return new ResponseEntity(MensajeDTO.builder().mensaje("V").build(),HttpStatus.OK);
		}
		return new ResponseEntity(MensajeDTO.builder().mensaje("F").build(),HttpStatus.OK);
	}
	
	@PostMapping(path="/registrarComprador",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity registrarComprador(@RequestBody CompradorDTO compradorDTO) {
		compradorService.registrarComprador(compradorDTO);
		return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@DeleteMapping(path="/borrarComprador/{id}")
	public ResponseEntity eliminarComprador(@PathVariable("id") String id) {
		compradorService.eliminarComprador(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
