package com.pessoal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoal.model.Elenco;
import com.pessoal.service.ElencoService;

@RestController()
@RequestMapping("/elenco")
public class ElencoAPIs {

	@Autowired
	private ElencoService elencoService;
	
	@PostMapping()
	public ResponseEntity<Elenco> salvarElenco(@RequestBody Elenco elenco){
		return ResponseEntity.ok(elencoService.salvarElenco(elenco));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Elenco> buscarElencoPorNome(@PathVariable String nome){
		return ResponseEntity.ok(elencoService.buscarElencoPorNome(nome));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Elenco> buscarElencoPorID(@PathVariable String id){
		return ResponseEntity.ok(elencoService.buscarElencoPorID(id));
	}
	
	@PutMapping()
	public ResponseEntity<Elenco> atualizarElenco(@RequestBody Elenco elenco){
		return ResponseEntity.ok(elencoService.atualizarElenco(elenco));
	}
}
