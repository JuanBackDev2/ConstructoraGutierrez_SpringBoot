package com.constructora.gutierrez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.CompradorDTO;
import com.constructora.gutierrez.entities.Comprador;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.CompradorRepository;

@Service
public class CompradorServiceImp implements CompradorService{
	
	@Autowired
	CompradorRepository compradorRepository;

	@Override
	public boolean existsById(String id) {
		return compradorRepository.existsById(id);
	}

	@Override
	public Page<CompradorDTO> obtenerCompradores(Pageable pageable) {
		
		Page<Comprador> compradores = compradorRepository.findAll(pageable);
		Page<CompradorDTO> compradoresDTO = Helpers.mapPage(compradores, CompradorDTO.class);
		
		return compradoresDTO;
	}

	@Override
	public void registrarComprador(CompradorDTO compradorDTO) {
		Comprador comprador = Helpers.modelmapper().map(compradorDTO, Comprador.class);
		compradorRepository.save(comprador);
		
	}

	@Override
	public void eliminarComprador(String id) {
		Comprador comprador = compradorRepository.findById(id);
		compradorRepository.delete(comprador);
		
	}


}
