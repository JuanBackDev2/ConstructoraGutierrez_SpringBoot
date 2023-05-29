package com.constructora.gutierrez.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	//@Column(name="compradorid")
	@ManyToOne
	@JoinColumn(name="compradorid")
	private Comprador compradorId;
	
	@OneToMany(mappedBy = "obra",cascade = CascadeType.ALL)
	List<PersonalObra> personalObra;
	
	@OneToMany(mappedBy = "obra",cascade = CascadeType.ALL)
	List<PlanoObra> planoObra;
	
	@OneToMany(mappedBy = "obraId",cascade = CascadeType.ALL)
	List<FacturaObra> facturasObra;
}
