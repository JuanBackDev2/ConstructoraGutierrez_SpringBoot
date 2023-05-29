package com.constructora.gutierrez.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.FacturaObraDTO;
import com.constructora.gutierrez.entities.FacturaObra;
import com.constructora.gutierrez.entities.Obra;
import com.constructora.gutierrez.helpers.Helpers;
import com.constructora.gutierrez.repositories.FacturaObraRepository;
import com.constructora.gutierrez.repositories.ObraRepository;

@Service
public class FacturaObraServiceImp implements FacturaObraService {
	
	
	@Autowired
	FacturaObraRepository facturaObraRepository;
	
	@Autowired
	ObraRepository obraRepository;

	@Override
	public Page<FacturaObraDTO> obtenerFacturasObra(Pageable pageable, String id) {

		Obra obra = obraRepository.findById(id);
		Page<FacturaObra> facturasObra = facturaObraRepository.findByObraId(obra, pageable);
		Page<FacturaObraDTO> foDTO = Helpers.mapPage(facturasObra, FacturaObraDTO.class);
		return foDTO;
	}

	@Override
	public void registrarFacturaObra(FacturaObraDTO po, String obraId) {
		String uniqueID = UUID.randomUUID().toString();
		Obra obra = obraRepository.findById(obraId);
		FacturaObra facturaObra = Helpers.modelmapper().map(po, FacturaObra.class);
		
		facturaObra.setEstadoPago("No pagado");
		facturaObra.setObraId(obra);
		facturaObra.setFacturaId(uniqueID);
		
		facturaObraRepository.save(facturaObra);
	}

	@Override
	public void pagoFacturaObra(FacturaObraDTO po, String facturaId) {
		FacturaObra fo = facturaObraRepository.findById(facturaId);
		fo.setFechaPago(po.getFechaPago());
		fo.setEstadoPago("Pagado");
		facturaObraRepository.save(fo);
	}

	@Override
	public void eliminarFacturaObra(String facturaId) {
		FacturaObra fo = facturaObraRepository.findById(facturaId);
		facturaObraRepository.delete(fo);
		
	}

}
