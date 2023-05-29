package com.constructora.gutierrez.dtos;

import java.util.Date;

import com.constructora.gutierrez.entities.Obra;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FacturaObraDTO {
	private String facturaId;
	private String estadoPago;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
	private Date fechaPago;
	private String obraId;
	private double cantidad;
}
