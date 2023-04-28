package com.constructora.gutierrez.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constructora.gutierrez.dtos.AdministradorDTO;
import com.constructora.gutierrez.dtos.TokenDTO;
import com.constructora.gutierrez.entities.Administrador;
import com.constructora.gutierrez.helpers.JWTUtil;
import com.constructora.gutierrez.repositories.AdministradorRepository;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityNotFoundException;


@Service
public class AdministradorServiceImp implements AdministradorService{

	@Autowired
	private AdministradorRepository ar;
	
	@Autowired  //Inyectamos el componente
	private JWTUtil jwt;
	
	@Override
	public void registrarAdmin(AdministradorDTO adminDTO) throws Exception {
		
		try {
			Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			String hash = argon.hash(1, 1024, 1,adminDTO.getPass());
			
			Administrador admin = new Administrador();
			admin.setAdminId(adminDTO.getAdminId());
			admin.setPass(hash);
			ar.save(admin);
		}catch(Exception e) {
			throw new Exception("No se pudo guardar el registro");
		}
	}

	@Override
	public TokenDTO verificarCredenciales(AdministradorDTO adminDTO) throws Exception {
		try {
			Administrador admin = ar.findById(adminDTO.getAdminId()).orElseThrow(EntityNotFoundException::new);
			String hashedPass = admin.getPass();
			
			//Crear instancia de argon
			Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			String uniqueID = UUID.randomUUID().toString();
			
			if(argon.verify(hashedPass, adminDTO.getPass())) {
				String token = jwt.create(String.valueOf(admin.getAdminId()),uniqueID);
				return TokenDTO.builder().token(token).build();
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			throw new Exception("Id de administrador o contraseña incorrectos");
		}
		
	}

}
