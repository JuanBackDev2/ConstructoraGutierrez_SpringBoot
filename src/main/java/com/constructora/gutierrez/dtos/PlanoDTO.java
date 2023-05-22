package com.constructora.gutierrez.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PlanoDTO {

	
	String planoid;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
	Date fecharealizacion;
	
	String tipoplano;
}
