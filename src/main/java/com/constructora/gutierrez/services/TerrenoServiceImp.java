package com.constructora.gutierrez.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.TerrenoDTO;
import com.constructora.gutierrez.entities.Terreno;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.TerrenoRepository;

@Service
public class TerrenoServiceImp implements TerrenoService{
	
	@Autowired
	TerrenoRepository terrenoRepository;

	@Override
	public Page<TerrenoDTO> obtenerTerrenos(Pageable pageable) {
		
		Page<Terreno> terrenos = terrenoRepository.findAll(pageable);
		
		Page<TerrenoDTO> terrenosDTO = Helpers.mapPage(terrenos, TerrenoDTO.class);
		
		return terrenosDTO;
	}

	@Override
	public boolean existsById(String id) {
		return terrenoRepository.existsById(id);
	}

	@Override
	public void registrarTerreno(TerrenoDTO terrenoDTO) {
		String uniqueID = UUID.randomUUID().toString();
		Terreno terreno = Helpers.modelmapper().map(terrenoDTO, Terreno.class);
		terreno.setTerrenoid(uniqueID);
		
		terrenoRepository.save(terreno);
	}

	@Override
	public TerrenoDTO obtenerTerreno(String id) {
		Terreno terreno = terrenoRepository.findById(id);
		TerrenoDTO terrenoDTO = Helpers.modelmapper().map(terreno, TerrenoDTO.class);
		
		return terrenoDTO;
	}

	@Override
	public void editarTerreno(String id, TerrenoDTO terrenoDTO) {
		Terreno terreno = terrenoRepository.findById(id);
		terreno.setDescripcion(terrenoDTO.getDescripcion());
		terreno.setDireccion(terrenoDTO.getDireccion());
		terreno.setPrecio(terrenoDTO.getPrecio());
		terreno.setTamano(terrenoDTO.getTamano());
		terreno.setTipoTerreno(terrenoDTO.getTipoTerreno());
		terreno.setZona(terrenoDTO.getZona());
		
		terrenoRepository.save(terreno);
		
	}

	@Override
	public void eliminarTerreno(String id) {
		Terreno terreno = terrenoRepository.findById(id);
		terrenoRepository.delete(terreno);
		
	}

}
