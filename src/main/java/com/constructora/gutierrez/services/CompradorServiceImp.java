package com.constructora.gutierrez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.repositories.CompradorRepository;

@Service
public class CompradorServiceImp implements CompradorService{
	
	@Autowired
	CompradorRepository compradorRepository;

	@Override
	public boolean existsById(String id) {
		return compradorRepository.existsById(id);
	}


}
