package com.pessoal.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.pessoal.utils.Ocupacao;

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
public class Elenco {

	@Id
	private String id;
	private String nome;
	private LocalDate dataNascimento;
	private List<Filme> filmografia;
	private Ocupacao ocupacao;
	
}
