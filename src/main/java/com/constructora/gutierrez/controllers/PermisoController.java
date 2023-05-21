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
import com.constructora.gutierrez.dtos.PermisoDTO;
import com.constructora.gutierrez.services.PermisoService;

@RestController
@RequestMapping("/permisos")
@CrossOrigin(origins = "http://localhost:4200")
public class PermisoController {
	
	@Autowired
	PermisoService ps;

	
	@GetMapping
	public Page<PermisoDTO> getAllPermisos(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue = "3") int size){
		Pageable paging = PageRequest.of(page, size);
		return ps.findAll(paging);
	}
	
	@PostMapping(path="/registrarPermisos",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity registrarPermisos(@RequestBody PermisoDTO permisoDTO) {
		ps.registrarPermiso(permisoDTO);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping(path="/borrarPermiso/{id}")
	public ResponseEntity borrarPermisos(@PathVariable("id") String id) {
		ps.borrarPermiso(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
