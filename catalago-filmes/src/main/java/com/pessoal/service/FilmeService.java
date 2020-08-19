package com.pessoal.service;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoal.feign.ElencoDirecaoFeign;
import com.pessoal.model.Elenco;
import com.pessoal.model.Filme;
import com.pessoal.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repository;

	@Autowired
	private ElencoDirecaoFeign elencoDirecaoFeign;

	public List<Filme> listarFilme() {
		return repository.findAll();
	}

	public Filme buscarPorTitulo(String titulo) {
		Filme filme = repository.findByTitulo(titulo);
		atualizarReferenciaElenco(filme);
		return repository.save(filme);
	}

	public Filme salvarFilme(Filme filme) {
		filme.getElenco().forEach(elenco -> elencoDirecaoFeign.salvarElenco(elenco).getId());

		return repository.save(filme);
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

}
