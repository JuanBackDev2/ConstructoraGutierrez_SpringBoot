package com.constructora.gutierrez.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="administrador")
public class Administrador {

	@Id
	@Column(name="administradorid")
	private String adminId;
	
	@Column(name="pass")
	private String pass;
}
