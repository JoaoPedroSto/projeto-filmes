package com.pessoal.infra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pessoal.domain.entity.Filme;

@Repository
public interface FilmeRepository extends MongoRepository<Filme, String>{
	public Filme findByTitulo(String titulo);
}
