package com.pessoal.application.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pessoal.domain.dto.FilmeDTO;
import com.pessoal.domain.entity.Filme;
import com.pessoal.domain.service.FilmeService;

@RestController()
public class CatalogoFilmesAPIs {

	@Autowired
	private FilmeService filmeService;

	@PostMapping("/filme")
	public ResponseEntity<FilmeDTO> salvarFilme(@RequestBody FilmeDTO filme) {
		return ResponseEntity.ok(filmeService.salvarFilme(filme));
	}

	@GetMapping("/filme/{titulo}")
	public ResponseEntity<FilmeDTO> buscarFilmePorTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(filmeService.buscarPorTitulo(titulo));
	}

	@GetMapping("/filme")
	public ResponseEntity<List<Filme>> listarFilmes() {
		return ResponseEntity.ok(filmeService.listarFilme());
	}
}
