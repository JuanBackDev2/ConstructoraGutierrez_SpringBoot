package com.constructora.gutierrez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.ObraDTO;
import com.constructora.gutierrez.entities.Obra;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.ObraRepository;

@Service
public class ObraServiceImp implements ObraService{
	
	@Autowired
	ObraRepository obraRepository;

	@Override
	public Page<ObraDTO> obtenerObras(Pageable pageable) {
		Page<Obra> obras =  obraRepository.findAll(pageable);
		
		Page<ObraDTO> obrasDTO = Helpers.mapPage(obras, ObraDTO.class);
		
		return obrasDTO;
	}

	@Override
	public ObraDTO obtenerObra(String id) {
		Obra obra = obraRepository.findById(id);
		
		ObraDTO obraDTO = Helpers.modelmapper().map(obra, ObraDTO.class);
		
		return obraDTO;
	}

}
