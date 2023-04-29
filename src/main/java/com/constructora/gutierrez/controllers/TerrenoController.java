package com.constructora.gutierrez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
