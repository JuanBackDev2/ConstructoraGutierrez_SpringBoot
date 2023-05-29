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
import com.constructora.gutierrez.dtos.PersonalObraDTO;
import com.constructora.gutierrez.dtos.PlanoDTO;
import com.constructora.gutierrez.dtos.PlanoObraDTO;
import com.constructora.gutierrez.services.PlanoObraService;
import com.constructora.gutierrez.services.PlanoService;

@RestController
@RequestMapping("/plano")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanoController {
	
	@Autowired
	PlanoService planoService;
	
	@Autowired
	PlanoObraService planoObraService;

	
	@GetMapping
	public Page<PlanoDTO> obtenerPlanos(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue = "3") int size){
		Pageable paging = PageRequest.of(page, size);
        return planoService.obtenerPlanos(paging);
		
	}
	
	
	@GetMapping(path="/{id}")
	public ResponseEntity obtenerPlano(@PathVariable("id") String id) {
		return new ResponseEntity(planoService.obtenerPlano(id),HttpStatus.OK);
		
	}
	
	@PostMapping(path="/registrarPlano",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity registrarPlano(@RequestBody PlanoDTO planoDTO) {
		planoService.registrarPlano(planoDTO);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@PutMapping(path="/editarPlano/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity editarPlano(@PathVariable("id") String id,@RequestBody PlanoDTO planoDTO) {
		planoService.editarPlano(id, planoDTO);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/borrarPlano/{id}")
	public ResponseEntity eliminarPlano(@PathVariable("id") String id) {
		planoService.eliminarPlano(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@GetMapping(path="/existsById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity existsById (@PathVariable("id") String id) {
		if(planoService.existsById(id)) {
			return new ResponseEntity(MensajeDTO.builder().mensaje("V").build(),HttpStatus.OK);
		}
		return new ResponseEntity(MensajeDTO.builder().mensaje("F").build(),HttpStatus.OK);
		
	}
	
	@GetMapping(path="/obrasPlano/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Page<PlanoObraDTO> obtenerObrasByPlano(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue = "3") int size, @PathVariable("id") String id){
		Pageable paging = PageRequest.of(page, size);
		return (planoObraService.obrasByPlano(paging, id));
		
	}
}
