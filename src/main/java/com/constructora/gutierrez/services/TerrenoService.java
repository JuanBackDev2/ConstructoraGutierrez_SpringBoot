package com.constructora.gutierrez.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.constructora.gutierrez.dtos.ObraDTO;
import com.constructora.gutierrez.dtos.TerrenoDTO;
public interface TerrenoService {

	public Page<TerrenoDTO> obtenerTerrenos(Pageable pageable);
	public boolean existsById(String id);
	public void registrarTerreno(TerrenoDTO terrenoDTO);
	public TerrenoDTO obtenerTerreno(String id);
	public void editarTerreno(String id,TerrenoDTO terrenoDTO);
	public void eliminarTerreno(String id);
}
