package com.pessoal.domain.service;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoal.domain.dto.FilmeDTO;
import com.pessoal.domain.entity.Elenco;
import com.pessoal.domain.entity.Filme;
import com.pessoal.infra.feign.ElencoDirecaoFeign;
import com.pessoal.infra.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repository;

	@Autowired
	private ElencoDirecaoFeign elencoDirecaoFeign;

	@Autowired
	private ModelMapper modelMapper;

	public FilmeDTO buscarPorTitulo(String titulo) {
		Filme filme = repository.findByTitulo(titulo);
		if (ObjectUtils.isNotEmpty(filme)) {
			atualizarReferenciaElenco(filme);
			return convertToDTO(repository.save(filme));
		} else
			return null;
	}

	public FilmeDTO salvarFilme(FilmeDTO filmeDTO) {
		Filme filme = convertToEntity(filmeDTO);
		filme.getElenco().forEach(elenco -> elencoDirecaoFeign.salvarElenco(elenco).getId());
		return convertToDTO(repository.save(filme));
	}

	private void atualizarReferenciaElenco(Filme filme) {
		if (ObjectUtils.isEmpty(filme) && ObjectUtils.isEmpty(filme.getElenco())) {
			filme.getElenco().forEach(elenco -> {
				Elenco elencoBase = elencoDirecaoFeign.buscarElencoPorId(elenco.getId());
				elenco.setDataNascimento(elencoBase.getDataNascimento());
				elenco.setNome(elencoBase.getNome());
				elenco.setFilmografia(elencoBase.getFilmografia());
				elenco.setOcupacao(elencoBase.getOcupacao());
			});
		}
	}

	private FilmeDTO convertToDTO(Filme filme) {
		return modelMapper.map(filme, FilmeDTO.class);
	}

	private Filme convertToEntity(FilmeDTO filmeDTO) {
		return modelMapper.map(filmeDTO, Filme.class);
	}

}
