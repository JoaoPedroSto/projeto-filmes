package com.pessoal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pessoal.model.Elenco;
import com.pessoal.service.ElencoService;

@RestController()
public class ElencoAPIs {

	@Autowired
	private ElencoService elencoService;
	
	@PostMapping("/elenco")
	public ResponseEntity<Elenco> salvarElenco(@RequestBody Elenco elenco){
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(elencoService.salvarElenco(elenco));
	}
	
	@GetMapping("/elenco/busca-nome/{nome}")
	public ResponseEntity<Elenco> buscarElencoPorNome(@PathVariable String nome){
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(elencoService.buscarElencoPorNome(nome));
	}
	
	@GetMapping("/elenco/busca-id/{id}")
	public ResponseEntity<Elenco> buscarElencoPorID(@PathVariable String id){
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(elencoService.buscarElencoPorID(id));
	}
	
	@PutMapping("/elenco")
	public ResponseEntity<Elenco> atualizarElenco(@RequestBody Elenco elenco){
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(elencoService.atualizarElenco(elenco));
	}
}
