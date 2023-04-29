package com.constructora.gutierrez.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="obra")
public class Obra {

	@Id
	@Column(name="obraid")
	private String obraId;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="tamano")
	private double tamano;
	
	@Column(name="ubicacion")
	private String ubicacion;
	
	@Column(name="estrato")
	private int estrato;
	
	@Column(name="linderos")
	private String linderos;
	
	@Column(name="anioinicioobra")
	private Date anioInicioObra;
	
	@Column(name="aniofinobra")
	private Date anioFinObra;
	
	@Column(name="inversion")
	private double inversion;
	
	@Column(name="estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="terrenoid")
	private Terreno terrenoid;
	
	@Column(name="compradorid")
	private String compradorId;
	
	
}
