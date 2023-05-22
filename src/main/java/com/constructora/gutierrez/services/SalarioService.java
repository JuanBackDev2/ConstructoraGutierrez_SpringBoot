package com.constructora.gutierrez.services;

import com.constructora.gutierrez.dtos.PersonalDTO;

public interface SalarioService {

	public void registrarSalario(PersonalDTO personalDTO);
	public double findSalario(String personalId);
}
