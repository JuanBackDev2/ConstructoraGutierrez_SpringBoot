package com.constructora.gutierrez.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class PermisoDTO {

	
	String permisoid;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
	Date fechaemisionpermiso;
	String tipopermiso;
	String estadopermiso;
	String obraid;
}
