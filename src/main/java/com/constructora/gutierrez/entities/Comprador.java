package com.constructora.gutierrez.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="comprador")
public class Comprador {
	
	@Id
	@Column(name="compradorid")
	private String compradorId;
	
	@OneToMany(mappedBy="compradorId",cascade = CascadeType.ALL)
	private List<Obra> obra;
}
