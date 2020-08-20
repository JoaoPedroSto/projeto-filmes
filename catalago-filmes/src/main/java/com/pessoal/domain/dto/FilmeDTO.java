package com.pessoal.domain.dto;

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

	private String titulo;
	private String sinopse;
	private String diretor;
	private List<ElencoDTO> elenco;
	private String genero;
}
