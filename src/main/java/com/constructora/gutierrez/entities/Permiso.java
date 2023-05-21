package com.constructora.gutierrez.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="permisosobra")
public class Permiso {

	@Id
	@Column(name="permisoid")
	String permisoid;
	
	@Column(name="fechaemisionpermiso")
	Date fechaemisionpermiso;
	
	@Column(name="tipopermiso")
	String tipopermiso;
	
	@Column(name="estadopermiso")
	String estadopermiso;
	
	@Column(name="obraid")
	String obraid;
}
