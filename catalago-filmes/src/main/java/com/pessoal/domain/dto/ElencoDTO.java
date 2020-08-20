package com.pessoal.domain.dto;

import java.time.LocalDate;
import java.util.List;

import com.pessoal.domain.utils.Ocupacao;

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
public class ElencoDTO {

	private String nome;
	private LocalDate dataNascimento;
	private List<FilmeDTO> filmografia;
	private Ocupacao ocupacao;
	
}
