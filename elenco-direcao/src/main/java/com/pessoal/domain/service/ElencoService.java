package com.pessoal.domain.service;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoal.domain.entity.Elenco;
import com.pessoal.infra.repository.ElencoRepository;

@Service
public class ElencoService {

	@Autowired
	private ElencoRepository repository;
	
	public Elenco salvarElenco(Elenco elenco) {
		return repository.save(elenco);
	}
	
	public Elenco buscarElencoPorNome(String nome) {
		return repository.findByNome(nome).orElse(null);
	}
	
	public Elenco atualizarElenco(Elenco elenco) {
		
		Elenco elencoBase = buscarElencoPorNome(elenco.getNome());
		if(ObjectUtils.isEmpty(elencoBase)) {
			elencoBase.setDataNascimento(elenco.getDataNascimento());
			elencoBase.setFilmografia(elenco.getFilmografia());
			elencoBase.setNome(elenco.getNome());
			elencoBase.setOcupacao(elenco.getOcupacao());
			return salvarElenco(elencoBase);
		}else {
			return null;			
		}
	}
	
	public Elenco buscarElencoPorID(String id) {
		return repository.findById(id).orElse(null);
	}
	
}
