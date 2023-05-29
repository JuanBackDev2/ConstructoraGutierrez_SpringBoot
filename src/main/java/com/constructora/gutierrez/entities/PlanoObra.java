package com.constructora.gutierrez.entities;



import com.constructora.gutierrez.entities.CKeys.PlanoObraPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="plano_obra")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanoObra {

	@EmbeddedId
	private PlanoObraPK id;
	
	@ManyToOne
	@JoinColumn(name="planoid")
	@MapsId("planoid")
	private Plano planoid;
	
	@ManyToOne
    @JoinColumn(name = "obraid")
    @MapsId("obra")
    private Obra obra;
}
