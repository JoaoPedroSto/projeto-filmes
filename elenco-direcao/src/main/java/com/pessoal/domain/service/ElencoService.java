package com.pessoal.domain.service;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoal.domain.dto.ElencoDTO;
import com.pessoal.domain.entity.Elenco;
import com.pessoal.infra.repository.ElencoRepository;

@Service
public class ElencoService {

	@Autowired
	private ElencoRepository repository;

	public ElencoDTO salvarElenco(ElencoDTO elencoDTO) {
		Elenco elenco = new Elenco(elencoDTO);
		BeanUtils.copyProperties(repository.save(elenco), elencoDTO);
		return elencoDTO;
	}

	public ElencoDTO buscarElencoPorNome(String nome) {
		return new ElencoDTO(repository.findByNome(nome).orElse(null));
	}

	public ElencoDTO atualizarElenco(ElencoDTO elenco) {
		Elenco elencoBase = repository.findByNome(elenco.getNome()).orElse(null);
		if (ObjectUtils.isNotEmpty(elencoBase)) {
			elencoBase.setDataNascimento(elenco.getDataNascimento());
			elencoBase.setFilmografia(elenco.getFilmografia());
			elencoBase.setNome(elenco.getNome());
			elencoBase.setOcupacao(elenco.getOcupacao());
			return new ElencoDTO(repository.save(elencoBase));
		} else {
			return null;
		}
	}

	public ElencoDTO buscarElencoPorID(String id) {
		return new ElencoDTO(repository.findById(id).orElse(null));
	}

}
