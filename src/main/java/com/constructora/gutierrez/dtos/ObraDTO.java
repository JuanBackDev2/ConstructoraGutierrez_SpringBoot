package com.constructora.gutierrez.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ObraDTO {

	private String obraId;
	
	private String nombre;
	
	private double tamano;
	
	private String ubicacion;
	
	private int estrato;
	
	private String linderos;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
	private Date anioInicioObra;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
	private Date anioFinObra;
	
	private double inversion;
	
	private String estado;
	
	private String terrenoid;
	
	private String compradorId;
}
