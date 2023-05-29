package com.constructora.gutierrez.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.PersonalObraDTO;
import com.constructora.gutierrez.dtos.PlanoObraDTO;
import com.constructora.gutierrez.entities.Obra;
import com.constructora.gutierrez.entities.Personal;
import com.constructora.gutierrez.entities.PersonalObra;
import com.constructora.gutierrez.entities.Plano;
import com.constructora.gutierrez.entities.PlanoObra;
import com.constructora.gutierrez.entities.CKeys.PersonalObraPK;
import com.constructora.gutierrez.entities.CKeys.PlanoObraPK;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.ObraRepository;
import com.constructora.gutierrez.repositories.PlanoObraRepository;
import com.constructora.gutierrez.repositories.PlanoRepository;

@Service
public class PlanoObraServiceImp implements PlanoObraService {
	
	@Autowired
	PlanoObraRepository planoObraRepository;
	
	@Autowired
	ObraRepository obraRepository;
	
	@Autowired
	PlanoRepository planoRepository;

	@Override
	public Page<PlanoObraDTO> obtenerPlanoObra(Pageable pageable, String id) {
		
		Obra obra = obraRepository.findById(id);
		
		Page<PlanoObra> planoObra = planoObraRepository.findByObra(obra, pageable);
		Page<PlanoObraDTO> poDTO = Helpers.mapPage(planoObra, PlanoObraDTO.class);
		
		return poDTO;
		
	}

	@Override
	public void registrarPlanoObra(PlanoObraDTO po, String obraId) {
		
		Plano plano = planoRepository.findById(po.getPlanoid());
		Obra obra = obraRepository.findById(obraId);
		
		PlanoObraPK pk = new PlanoObraPK();
		pk.setObra(obraId);
		pk.setPlanoid(po.getPlanoid());
		
		planoObraRepository.save(PlanoObra.builder()
									  .obra(obra)
									  .planoid(plano)
									  .id(pk)
									  .build());
		
	}

	@Override
	public void eliminarPlanoObra(String obraId, String planoId) {
		Obra obra = obraRepository.findById(obraId);
		Plano plano = planoRepository.findById(planoId);
		
		PlanoObra planoObra = planoObraRepository.findByObraAndPlanoid(obra, plano);
		planoObraRepository.delete(planoObra);
		
	}

	@Override
	public Page<PlanoObraDTO> obrasByPlano(Pageable pageable, String id) {
		Plano plano = planoRepository.findById(id);
		Page<PlanoObra> obrasPlano = planoObraRepository.findByPlanoid(plano, pageable);
		Page<PlanoObraDTO> obrasPlanoDTO = Helpers.mapPage(obrasPlano, PlanoObraDTO.class);
		return obrasPlanoDTO;
	}

}
