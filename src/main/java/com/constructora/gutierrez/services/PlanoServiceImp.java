package com.constructora.gutierrez.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.ObraDTO;
import com.constructora.gutierrez.dtos.PlanoDTO;
import com.constructora.gutierrez.entities.Obra;
import com.constructora.gutierrez.entities.Plano;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.PlanoRepository;

@Service
public class PlanoServiceImp implements PlanoService{
	
	@Autowired
	PlanoRepository planoRepository;

	@Override
	public Page<PlanoDTO> obtenerPlanos(Pageable pageable) {
		Page<Plano> planos = planoRepository.findAll(pageable);
		Page<PlanoDTO> planosDTO = Helpers.mapPage(planos, PlanoDTO.class);
		
		return planosDTO;
	}

	@Override
	public void registrarPlano(PlanoDTO planoDTO) {
		String uniqueID = UUID.randomUUID().toString();
		String planoId = "";
		
		switch(planoDTO.getTipoplano()) {
			case "Ejecucion": planoId = uniqueID.concat("-EJ");
				break;
			case "Desague": planoId = uniqueID.concat("-DE");
				break;
			case "Electricidad": planoId = uniqueID.concat("-EL");
				break;
			case "Plano de obra": planoId = uniqueID.concat("-PO");
			break;
		}
		
		Plano plano = Helpers.modelmapper().map(planoDTO, Plano.class);
		plano.setPlanoid(planoId);
		
		planoRepository.save(plano);
	}

	@Override
	public PlanoDTO obtenerPlano(String id) {
		Plano plano = planoRepository.findById(id);
		PlanoDTO planoDTO = Helpers.modelmapper().map(plano, PlanoDTO.class);
		return planoDTO;
	}

	@Override
	public void editarPlano(String id, PlanoDTO planoDTO) {
		
		Plano plano = planoRepository.findById(id);
		plano.setFecharealizacion(planoDTO.getFecharealizacion());
		plano.setTipoplano(planoDTO.getTipoplano());
		
		String editedString = "";
		StringBuilder stringBuilder = new StringBuilder(plano.getPlanoid());
		
		switch(planoDTO.getTipoplano()) {
		case "Ejecucion": 
			stringBuilder.setCharAt(plano.getPlanoid().length() - 2, 'E');
			stringBuilder.setCharAt(plano.getPlanoid().length() - 1, 'J');
			editedString = stringBuilder.toString();
			break;
		case "Desague": 
			stringBuilder.setCharAt(plano.getPlanoid().length() - 2, 'D');
			stringBuilder.setCharAt(plano.getPlanoid().length() - 1, 'E');
			editedString = stringBuilder.toString();
			break;
		case "Electricidad": 
			stringBuilder.setCharAt(plano.getPlanoid().length() - 2, 'E');
			stringBuilder.setCharAt(plano.getPlanoid().length() - 1, 'L');
			editedString = stringBuilder.toString();
			break;
		case "Plano de obra": 
			stringBuilder.setCharAt(plano.getPlanoid().length() - 2, 'P');
			stringBuilder.setCharAt(plano.getPlanoid().length() - 1, 'O');
			editedString = stringBuilder.toString();
			break;
		}
		planoRepository.delete(plano);
		plano.setPlanoid(editedString);
		planoRepository.save(plano);
		
	}
	
	@Override
	public void eliminarPlano(String id) {
		Plano plano = planoRepository.findById(id);
		planoRepository.delete(plano);
	}

	@Override
	public boolean existsById(String id) {
		return planoRepository.existsById(id);
	}

}
