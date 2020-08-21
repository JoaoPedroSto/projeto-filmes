package com.pessoal.domain.dto;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pessoal.domain.entity.Elenco;
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

	@JsonIgnore
	private String id;
	private String nome;
	private LocalDate dataNascimento;
	private List<String> filmografia;
	private Ocupacao ocupacao;

	public ElencoDTO(Elenco elenco) {
		if (ObjectUtils.isNotEmpty(elenco)) {
			this.id = elenco.getId();
			this.nome = elenco.getNome();
			this.dataNascimento = elenco.getDataNascimento();
			this.filmografia = elenco.getFilmografia();
			this.ocupacao = elenco.getOcupacao();
		}
	}

}
