package com.pessoal.infra.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pessoal.domain.entity.Elenco;

@Component
@FeignClient(name = "salvarElenco", url = "localhost:8081")
public interface ElencoDirecaoFeign {

	@PostMapping("/elenco")
	Elenco salvarElenco(@RequestBody Elenco elenco);
	
	@GetMapping("/elenco/busca-id/{id}")
	Elenco buscarElencoPorId(@PathVariable String id);
	
}
	