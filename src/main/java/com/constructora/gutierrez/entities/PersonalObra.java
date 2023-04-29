package com.constructora.gutierrez.entities;

import com.constructora.gutierrez.entities.CKeys.PersonalObraPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="personal_obra")
public class PersonalObra {

	@EmbeddedId
	private PersonalObraPK id;
	
	@Column(name="diastrabajados")
	private int diasTrabajados;
	
	@ManyToOne
    @JoinColumn(name = "personalid")
    @MapsId("personalid")
    private Personal personal;

	
	@ManyToOne
    @JoinColumn(name = "obraid")
    @MapsId("obra")
    private Obra obra;
}
