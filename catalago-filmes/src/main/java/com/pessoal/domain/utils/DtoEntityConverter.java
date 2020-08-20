package com.pessoal.domain.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pessoal.domain.dto.FilmeDTO;
import com.pessoal.domain.entity.Filme;

@Component
public class DtoEntityConverter {

	private Filme filme;
	private FilmeDTO filmeDTO;
	
	public Filme convertDtoToEntity(FilmeDTO filmeDTO) {
		BeanUtils.copyProperties(filmeDTO, filme);
		return filme;
	}

	public FilmeDTO convertEntityToDto(Filme filme) {
		BeanUtils.copyProperties(filme, filmeDTO);
		return filmeDTO;
	}
}
