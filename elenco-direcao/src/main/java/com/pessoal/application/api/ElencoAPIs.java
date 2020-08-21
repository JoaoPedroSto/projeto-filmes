package com.pessoal.application.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoal.domain.dto.ElencoDTO;
import com.pessoal.domain.service.ElencoService;

@RestController()
@RequestMapping("/elenco")
public class ElencoAPIs {

	@Autowired
	private ElencoService elencoService;
	
	@PostMapping()
	public ResponseEntity<ElencoDTO> salvarElenco(@RequestBody ElencoDTO elenco){
		return ResponseEntity.ok(elencoService.salvarElenco(elenco));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<ElencoDTO> buscarElencoPorNome(@PathVariable String nome){
		return ResponseEntity.ok(elencoService.buscarElencoPorNome(nome));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ElencoDTO> buscarElencoPorID(@PathVariable String id){
		return ResponseEntity.ok(elencoService.buscarElencoPorID(id));
	}
	
	@PutMapping()
	public ResponseEntity<ElencoDTO> atualizarElenco(@RequestBody ElencoDTO elenco){
		return ResponseEntity.ok(elencoService.atualizarElenco(elenco));
	}
}
