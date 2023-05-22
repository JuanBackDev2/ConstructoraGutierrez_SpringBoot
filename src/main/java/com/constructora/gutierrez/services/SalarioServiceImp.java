package com.constructora.gutierrez.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.PersonalDTO;
import com.constructora.gutierrez.entities.Salario;
import com.constructora.gutierrez.repositories.SalarioRepository;

@Service
public class SalarioServiceImp implements SalarioService{
	
	@Autowired
	SalarioRepository salarioRepository;

	@Override
	public void registrarSalario(PersonalDTO personalDTO) {
		String uniqueID = UUID.randomUUID().toString();
		
		Salario salario = new Salario();
		salario.setPersonalid(personalDTO.getPersonalId());
		salario.setSalarioid(uniqueID);
		
		switch(personalDTO.getCargo()) {
			case "Jefe de obra":
				salario.setSalariobase(100000);
				break;
			case "Obrero":
				salario.setSalariobase(30000);
				break;
			case "Hidraulico":
				salario.setSalariobase(35000);
				break;
			case "Electricista":
				salario.setSalariobase(35000);
				break;
			case "Obra blanca":
				salario.setSalariobase(40000);
				break;
		}
		double porcentaje = 1.08;
		salario.setPorcentajeincremento(porcentaje);
		
		salarioRepository.save(salario);
	}

	@Override
	public double findSalario(String personalId) {
		Salario salario = salarioRepository.findByPersonalid(personalId);
		return salario.getSalariobase()* salario.getPorcentajeincremento();
	}

}
