package com.pessoal.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

	private String titulo;
	private String genero;
	
}
