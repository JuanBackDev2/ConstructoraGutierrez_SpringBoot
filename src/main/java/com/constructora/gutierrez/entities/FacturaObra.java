package com.constructora.gutierrez.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="facturas_obra")
public class FacturaObra {

	@Id
	@Column(name="facturaid")
	private String facturaId;

	@Column(name="estadopago")
	private String estadoPago;
	
	@Column(name="fechapago")
	private Date fechaPago;
	
	@Column(name="cantidad")
	private double cantidad;
	
	@ManyToOne
	@JoinColumn(name="obraid")
	private Obra obraId;
}
