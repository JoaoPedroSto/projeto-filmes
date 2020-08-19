package com.pessoal.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

	@Id
	private String id;
	private String titulo;
	private String sinopse;
	private String diretor;
	private List<Elenco> elenco;
	private String genero;
	
}
