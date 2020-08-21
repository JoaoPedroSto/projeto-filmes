package com.pessoal.domain.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pessoal.domain.dto.ElencoDTO;
import com.pessoal.domain.dto.FilmeDTO;
import com.pessoal.domain.entity.Elenco;
import com.pessoal.domain.entity.Filme;

@Component
public class DtoEntityConverter {
	
	public Filme convertDtoToEntity(FilmeDTO filmeDTO) {
		Filme filme = new Filme();
		Elenco elenco = new Elenco();
		BeanUtils.copyProperties(filmeDTO, filme, "elenco");
		filmeDTO.getElenco().forEach(elencoDTO -> {
			BeanUtils.copyProperties(elencoDTO, elenco);
			filme.getElenco().add(elenco);
		});
		return filme;
	}

	public FilmeDTO convertEntityToDto(Filme filme) {
		FilmeDTO filmeDTO = new FilmeDTO();
		ElencoDTO elencoDTO = new ElencoDTO();
		BeanUtils.copyProperties(filme, filmeDTO, "elenco");
		filme.getElenco().forEach(elenco -> {
			BeanUtils.copyProperties(elenco, elencoDTO);
			filmeDTO.getElenco().add(elencoDTO);
		});
		return filmeDTO;
	}
}
