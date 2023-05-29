package com.constructora.gutierrez.entities.CKeys;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PlanoObraPK implements Serializable {

	private String planoid;
	private String obra;
	 
}
