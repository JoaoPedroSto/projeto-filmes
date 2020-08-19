package com.pessoal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoal.model.Elenco;
import com.pessoal.repository.ElencoRepository;

@Service
public class ElencoService {

	@Autowired
	private ElencoRepository repository;
	
	public Elenco salvarElenco(Elenco elenco) {
		return repository.save(elenco);
	}
	
	public Elenco buscarElencoPorNome(String nome) {
		Optional<Elenco> elenco = repository.findByNome(nome);
		if(elenco.isPresent()) {
			return elenco.get();
		}else{
			return null;
		}
	}
	
	public Elenco atualizarElenco(Elenco elenco) {
		
		Elenco elencoBase = buscarElencoPorNome(elenco.getNome());
		if(elencoBase != null) {
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
		Optional<Elenco> elenco = repository.findById(id);
		if(elenco.isPresent()) {
			return elenco.get();
		}else{
			return null;			
		}
	}
	
}
