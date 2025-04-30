package com.respwrapper.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoDTO {
    
	private Long id;
	private String nombre;
	private Double precio;
}
