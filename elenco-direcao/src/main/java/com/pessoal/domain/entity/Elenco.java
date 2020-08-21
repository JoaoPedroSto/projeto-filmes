package com.pessoal.domain.entity;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.annotation.Id;

import com.pessoal.domain.dto.ElencoDTO;
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
public class Elenco {

	@Id
	private String id;
	private String nome;
	private LocalDate dataNascimento;
	private List<String> filmografia;
	private Ocupacao ocupacao;
	
	public Elenco(ElencoDTO elencoDTO) {
		if(ObjectUtils.isNotEmpty(elencoDTO)) {
			this.id = elencoDTO.getId();
			this.nome = elencoDTO.getNome();
			this.dataNascimento = elencoDTO.getDataNascimento();
			this.filmografia = elencoDTO.getFilmografia();
			this.ocupacao = elencoDTO.getOcupacao();			
		}
	}

}
