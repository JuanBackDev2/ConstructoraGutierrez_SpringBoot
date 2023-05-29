package com.constructora.gutierrez.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.constructora.gutierrez.dtos.PersonalObraDTO;
import com.constructora.gutierrez.dtos.PlanoObraDTO;

public interface PlanoObraService {
	public Page<PlanoObraDTO> obtenerPlanoObra(Pageable pageable,String id);
	public void registrarPlanoObra(PlanoObraDTO po,String obraId);
	public void eliminarPlanoObra(String obraId, String planoId);
	public	Page<PlanoObraDTO> obrasByPlano(Pageable pageable,String id);
}
