package com.pessoal.domain.service;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoal.domain.dto.ElencoDTO;
import com.pessoal.domain.entity.Elenco;
import com.pessoal.infra.repository.ElencoRepository;

@Service
public class ElencoService {

	@Autowired
	private ElencoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public ElencoDTO salvarElenco(ElencoDTO elencoDTO) {
		repository.save(convertToEntity(elencoDTO));
		return elencoDTO;
	}

	public ElencoDTO buscarElencoPorNome(String nome) {
		Elenco elenco = repository.findByNome(nome).orElse(null);
		if (ObjectUtils.isNotEmpty(elenco)) {
			return convertToDTO(elenco);
		}
		return null;
	}

	public ElencoDTO atualizarElenco(ElencoDTO elenco) {
		Elenco elencoBase = repository.findByNome(elenco.getNome()).orElse(null);
		if (ObjectUtils.isNotEmpty(elencoBase)) {
			elencoBase.setDataNascimento(elenco.getDataNascimento());
			elencoBase.setFilmografia(elenco.getFilmografia());
			elencoBase.setNome(elenco.getNome());
			elencoBase.setOcupacao(elenco.getOcupacao());
			return convertToDTO(repository.save(elencoBase));
		} else
			return null;
	}

	public ElencoDTO buscarElencoPorID(String id) {
		Elenco elenco = repository.findById(id).orElse(null);
		if (ObjectUtils.isNotEmpty(elenco)) {
			return convertToDTO(repository.findById(id).orElse(null));
		} else
			return null;
	}

	private ElencoDTO convertToDTO(Elenco elenco) {
		return modelMapper.map(elenco, ElencoDTO.class);
	}

	private Elenco convertToEntity(ElencoDTO elencoDTO) {
		return modelMapper.map(elencoDTO, Elenco.class);
	}

}
