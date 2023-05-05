package com.constructora.gutierrez.entities.CKeys;

import java.io.Serializable;

import com.constructora.gutierrez.entities.Obra;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class PersonalObraPK implements Serializable{

    private String obra;
    private String personalid;
}
