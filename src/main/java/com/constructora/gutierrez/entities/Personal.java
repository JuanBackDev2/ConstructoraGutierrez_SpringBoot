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
@Table(name="personal")
public class Personal {

	@Id
	@Column(name="personalid")
	private String personalId;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="cargo")
	private String cargo;
	
	@OneToMany(mappedBy="personal",cascade = CascadeType.ALL)
	private List<PersonalObra> personalObra;
}
