package com.constructora.gutierrez.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="salario")
@Data
public class Salario {

	@Id
	@Column(name="salarioid")
	String salarioid;
	
	@Column(name="personalid")
	String personalid;
	
	@Column(name="salariobase")
	double salariobase;
	
	@Column(name="porcentajeincremento")
	double porcentajeincremento;
	
}
