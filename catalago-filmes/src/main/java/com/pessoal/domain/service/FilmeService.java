package com.pessoal.domain.service;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoal.domain.dto.FilmeDTO;
import com.pessoal.domain.entity.Elenco;
import com.pessoal.domain.entity.Filme;
import com.pessoal.domain.utils.DtoEntityConverter;
import com.pessoal.infra.feign.ElencoDirecaoFeign;
import com.pessoal.infra.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repository;

	@Autowired
	private ElencoDirecaoFeign elencoDirecaoFeign;
	
	@Autowired
	private DtoEntityConverter convert;

	public List<Filme> listarFilme() {
		return repository.findAll();
	}

	public FilmeDTO buscarPorTitulo(String titulo) {
		Filme filme = repository.findByTitulo(titulo);
		atualizarReferenciaElenco(filme);
		return convert.convertEntityToDto(repository.save(filme));
	}

	public FilmeDTO salvarFilme(FilmeDTO filmeDTO) {
		Filme filme = convert.convertDtoToEntity(filmeDTO);
		filme.getElenco().forEach(elenco -> elencoDirecaoFeign.salvarElenco(elenco).getId());
		return convert.convertEntityToDto(repository.save(filme));
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
