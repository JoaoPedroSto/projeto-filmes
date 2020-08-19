package com.pessoal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pessoal.model.Filme;

@Repository
public interface FilmeRepository extends MongoRepository<Filme, String>{
	public Filme findByTitulo(String titulo);
}
