package com.constructora.gutierrez.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.ObraDTO;
import com.constructora.gutierrez.entities.Comprador;
import com.constructora.gutierrez.entities.Obra;
import com.constructora.gutierrez.entities.Terreno;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.CompradorRepository;
import com.constructora.gutierrez.repositories.ObraRepository;
import com.constructora.gutierrez.repositories.TerrenoRepository;

@Service
public class ObraServiceImp implements ObraService{
	
	@Autowired
	ObraRepository obraRepository;
	
	@Autowired
	TerrenoRepository terrenoRepository;
	
	@Autowired
	CompradorRepository compradorRepository;

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
	
	
	public void registrarObra(ObraDTO obraDTO) {
		
		Terreno terreno = terrenoRepository.findById(obraDTO.getTerrenoid());
		Comprador comprador = compradorRepository.findById(obraDTO.getCompradorId());
		
		String uniqueID = UUID.randomUUID().toString();
		
		//servicio en el front para verificar que si existe el terreno y el comprador
		Obra obra = Helpers.modelmapper().map(obraDTO, Obra.class);
		obra.setObraId(uniqueID);
		obra.setTerrenoid(terreno);
		obra.setCompradorId(comprador);
		obra.setEstado("Inactivo");
		
		obraRepository.save(obra);
		
	}

	@Override
	public void eliminarObra(String id) {
		Obra obra = obraRepository.findById(id);
		obraRepository.delete(obra);
	}

	@Override
	public void editarObra(String id, ObraDTO obraDTO) {
		Obra obra = obraRepository.findById(id);
		Terreno terreno = terrenoRepository.findById(obraDTO.getTerrenoid());
		Comprador comprador = compradorRepository.findById(obraDTO.getCompradorId());
		
		obra.setAnioInicioObra(obraDTO.getAnioInicioObra());
		obra.setAnioFinObra(obraDTO.getAnioFinObra());
		obra.setTerrenoid(terreno);
		obra.setCompradorId(comprador);
		obra.setInversion(obraDTO.getInversion());
		obra.setEstrato(obra.getEstrato());
		obra.setLinderos(obraDTO.getLinderos());
		obra.setNombre(obraDTO.getNombre());
		obra.setTamano(obraDTO.getTamano());
		obra.setUbicacion(obraDTO.getUbicacion());
		
		obraRepository.save(obra);
		
	}

	@Override
	public boolean existsById(String id) {
		return obraRepository.existsById(id);
	}

	

}
