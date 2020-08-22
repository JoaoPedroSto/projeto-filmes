package com.pessoal.domain.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.pessoal.domain.utils.Ocupacao;

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
	private List<String> filmografia;
	private Ocupacao ocupacao;
}
