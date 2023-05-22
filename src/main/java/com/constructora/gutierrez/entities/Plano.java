package com.constructora.gutierrez.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="plano")
@Data
public class Plano {
	
	@Id
	@Column(name="planoid")
	String planoid;

	@Column(name="fecharealizacion")
	Date fecharealizacion;
	
	@Column(name="tipoplano")
	String tipoplano;
	
}
