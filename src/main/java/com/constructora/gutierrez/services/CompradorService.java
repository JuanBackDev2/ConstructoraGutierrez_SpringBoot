package com.constructora.gutierrez.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.constructora.gutierrez.dtos.CompradorDTO;
import com.constructora.gutierrez.dtos.ObraDTO;

public interface CompradorService {
	
	public boolean existsById(String id);
	public Page<CompradorDTO> obtenerCompradores(Pageable pageable);
	public void registrarComprador(CompradorDTO compradorDTO);
	public void eliminarComprador(String id);

}
