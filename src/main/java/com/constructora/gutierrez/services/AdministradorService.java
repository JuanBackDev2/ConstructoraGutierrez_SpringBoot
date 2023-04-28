package com.constructora.gutierrez.services;

import com.constructora.gutierrez.dtos.AdministradorDTO;
import com.constructora.gutierrez.dtos.TokenDTO;


public interface AdministradorService {

	public void registrarAdmin(AdministradorDTO adminDTO) throws Exception;
	public TokenDTO verificarCredenciales(AdministradorDTO adminDTO) throws Exception;
}
