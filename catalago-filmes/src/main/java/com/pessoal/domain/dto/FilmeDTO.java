package com.pessoal.domain.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDTO {

	private String id;
	
	private String titulo;
	
	private String sinopse;
	
	private String diretor;
	
	@Builder.Default
	private List<ElencoDTO> elenco = new ArrayList<>();
	
	private String genero;
}
