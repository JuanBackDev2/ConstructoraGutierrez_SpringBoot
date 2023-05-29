package com.constructora.gutierrez.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.constructora.gutierrez.dtos.FacturaObraDTO;
import com.constructora.gutierrez.dtos.PersonalObraDTO;
public interface FacturaObraService {
	
	public Page<FacturaObraDTO>obtenerFacturasObra(Pageable page,String id);
	public void registrarFacturaObra(FacturaObraDTO po,String obraId);
	public void pagoFacturaObra(FacturaObraDTO po,String obraId);
	public void eliminarFacturaObra(String facturaId);

}
