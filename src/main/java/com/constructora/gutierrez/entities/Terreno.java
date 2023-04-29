package com.constructora.gutierrez.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="terreno")
public class Terreno {

	@Id
	@Column(name="terrenoid")
	private String terrenoid;
	
	@Column(name="tamano")
	private double tamano;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="zona")
	private String zona;
	
	@Column(name="precio")
	private double precio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="tipoterreno")
	private String tipoTerreno;
	
	@OneToMany(mappedBy = "terrenoid",cascade = CascadeType.ALL)
	private List<Obra> obras;
	
}
